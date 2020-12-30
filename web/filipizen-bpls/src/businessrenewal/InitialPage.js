import React, { useState, useEffect } from "react";
import {
  Card,
  Content,
  FormPanel,
  Panel,
  Button,
  Error,
  ActionBar,
  BackLink,
  Spacer,
  Title,
  Text,
  Subtitle,
  Table,
  TableColumn,
  useData
} from "rsi-react-web-components";

import { ACTIONS } from "./reducer"

import { ContactVerification, isBlur } from "rsi-react-filipizen-components";
import Confirmation from "../components/Confirmation";
import TrackingInfo from "../components/TrackingInfo";

import LobList from "./components/LobList";

const steps = [
  { name: "contact", caption: "Contact Information" },
  { name: "enter-bin", caption: "Business Identification Number" },
  { name: "email-verification", caption: "Email Verification" },
  { name: "app-notice", caption: "Business Renewal Notice" },
  { name: "verify-info", caption: "Business Verify Information" },
  { name: "confirmation", caption: "Confirmation" },
  { name: "newapp", caption: "New Application " },
];

const InitialPage = ({
  partner, 
  service, 
  history, 
  title,
  appService,
  moveNextStep: exitInitial
}) => {
  
  const [ctx, dispatch] = useData();
  const { contact } = ctx;

  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);

  const [agreeDisclaimer, setAgreeDisclaimer] = useState(false);
  const [app, setApp] = useState({});
  const [email, setEmail] = useState();
  const [keyCode, setKeyCode] = useState();

  const [currentStep, setCurrentStep] = useState(0);
  

  const step = steps[currentStep];

  const moveNextStep = () => {
    setCurrentStep((cs) => cs + 1);
  };

  const movePrevStep = () => {
    setCurrentStep((cs) => cs - 1);
  };

  const validateBin = () => {
    setError(null);
    setLoading(true);
    appService.invoke("validateBin", { ...app, contact}, (err, validatedApp) => {
      if (!err) {
        setApp(validatedApp);
        moveNextStep()
      } else {
        setError(err);
      }
      setLoading(false);
    });
  };

  const verifyCode = () => {
    setError(null);
    if (app.key !== keyCode) {
      setError("Code is incorrect");
    } else {
      verifyApplication()
    }
  };

  const verifyApplication = () => {
    setError(null);
    setLoading(true);
    appService.invoke("openBin", app, (err, validatedApp) => {
      if (!err) {
        let idx;
        if (validatedApp.redflags.length == 0) {
          idx = steps.findIndex(step => step.name === "verify-info");
        } else {
          idx = steps.findIndex(step => step.name === "app-notice");
        }
        validatedApp.step = 1;
        setApp(validatedApp);
        setCurrentStep(idx);
      } else {
        setError(err);
      }
      setLoading(false);
    });
  };

  const saveApp = () => {
    appService.invoke("create", app, (err, app) => {
      if (!err) {
        app.redflags = [];
        dispatch({type: ACTIONS.SET_APP, app});     
        setApp(app);
        moveNextStep();
      } else {
        setError(err);
      }
    });
  };

  return (
    <React.Fragment>
    {step.name === "contact" ? (
      <ContactVerification
        partner={partner}
        showName={true}
        moveNextStep={moveNextStep}
        movePrevStep={movePrevStep}
        title={title}
        subtitle="Contact Verification"
        emailRequired={true}
      />
    ): (
      <Card>
        <Spacer />

        <FormPanel context={app} handler={setApp} visibleWhen={step.name === "enter-bin"}>
          <Title>{title}</Title>
          <Subtitle>{step.caption}</Subtitle>
          <Spacer />
          <Error msg={error} />
          <Text caption="Enter BIN" name="bin" required={true} autoFocus={true} />
          <ActionBar>
            <BackLink caption="Cancel" action={() => history.goBack()} />
            <Button caption="Next" action={validateBin} loading={loading} disableWhen={!app.bin} />
          </ActionBar>
        </FormPanel>

        <Panel visibleWhen={step.name === "email-verification"}>
          <Title>{title}</Title>
          <Subtitle>{step.caption}</Subtitle>
          <Spacer />
          <Content center>
            <span>Enter the code sent to your business email</span>
            <span>address at {contact.email}</span>
          </Content>
          <Spacer />
          <Text
            label="Email Code"
            placeholder="Enter code sent to your email"
            name="keyCode"
            value={keyCode}
            onChange={setKeyCode}
            maxLength={6}
            autoFocus={true}
            error={error ? true : false}
            helperText={error}
          />
          <ActionBar>
            <Button label="Verify" action={verifyCode} loading={loading} disableWhen={loading} />
          </ActionBar>
        </Panel>

        <FormPanel visibleWhen={step.name === "app-notice"} context={app} handler={setApp}>
          <Title>{title}</Title>
          <Subtitle>{step.caption}</Subtitle>
          <Spacer height={30} />
          <Panel row>
            <Text caption="BIN" name="bin" readOnly={true} />
            <Text caption="Application No." name="prevapp.appno" readOnly={true} />
          </Panel>
          <Panel row>
            <Text caption="Application Year" name="prevapp.appyear" readOnly={true} />
            <Text caption="Application Type" name="prevapp.apptype" readOnly={true} />
          </Panel>
          <Text caption="Trade Name" name="tradename" readOnly={true} />
          <Text caption="Owner Name" name="owner.name" readOnly={true} />
          <Text caption="Business Address" name="businessaddress" readOnly={true} />

          <p>
          You cannot renew business due to the following issues. Please settle it
          with the corresponding offices. You can contact our helpdesk at {partner.phoneno}.
          </p>

          <Table items={app.redflags} showPagination={false}>
            <TableColumn caption="Issue" width={300} expr="issue" />
            <TableColumn caption="Office/Department" expr="office" />
          </Table>

          <ActionBar>
            <BackLink caption="Cancel" action={() => history.goBack()} />
          </ActionBar>
        </FormPanel>
        
        <FormPanel visibleWhen={step.name === "verify-info"} context={app} handler={setApp}>
          <Title>{title}</Title>
          <Subtitle>{step.caption}</Subtitle>
          <Spacer height={30} />
          <Panel row>
            <Text caption="BIN" name="bin" readOnly={true} />
            <Text caption="Application No." name="prevapp.appno" readOnly={true} />
          </Panel>
          <Panel row>
            <Text caption="Application Year" name="prevapp.appyear" readOnly={true} />
            <Text caption="Application Type" name="prevapp.apptype" readOnly={true} />
          </Panel>
          <Text caption="Trade Name" name="tradename" readOnly={true} />
          <Text caption="Owner Name" name="owner.name" readOnly={true} />
          <Text caption="Business Address" name="businessaddress" readOnly={true} />
          <Spacer />
          <h3>Line of Businesses Operated</h3>
          <LobList lobs={app.lobs} />
          <ActionBar>
            <BackLink caption="Back" action={() => setCurrentStep(1)} />
            <Button caption="Next" action={moveNextStep} />
          </ActionBar>
        </FormPanel>

        <Panel visibleWhen={step.name === "confirmation"}>
          <Title>{title}</Title>
          <Confirmation
            title="Business Renewal Application"
            partner={partner}
            error={error}
            onCancel={movePrevStep}
            onContinue={saveApp}
          />
        </Panel>

        <Panel visibleWhen={step.name === "newapp"} width={400}>
          <Title>{title}</Title>
          <TrackingInfo appno={app.controlno} onContinue={exitInitial} />
        </Panel>
      </Card>
    )}
      </React.Fragment>
    );
};

export default InitialPage;
