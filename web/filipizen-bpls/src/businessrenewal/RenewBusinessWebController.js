import React, { useState, useEffect } from "react";
import {
  Panel,
  Service,
  Stepper,
  Content,
  Page,
  StateProvider,
} from "rsi-react-web-components";
import "rsi-react-web-components/dist/index.css";

import reducer, { initialState } from "./reducer";

import SelectTxnTypePage from "./SelectTxnTypePage.js";
import InitialPage from "./InitialPage";
import GeneralInfoPage from "./GeneralInfoPage";
import EditInfoPage from "./EditInfoPage";
import RequirementPage from "./RequirementPage";
import ConfirmPage from "./ConfirmPage";
import CompletedPage from "./CompletedPage";

const pages = [
  { step: 0, name: "select", caption: "Select Application Type", component: SelectTxnTypePage },
  { step: 1, name: "initial", caption: "Initial", component: InitialPage },
  { step: 2, name: "info", caption: "General Information", component: GeneralInfoPage },
  { step: 3, name: "edit-info", caption: "Edit Information", component: EditInfoPage },
  { step: 4, name: "requirements", caption: "Requirements", component: RequirementPage },
  { step: 5, name: 'confirm', caption: 'Confirm', component: ConfirmPage },
  { step: 6, name: 'completed', caption: 'Completed', component: CompletedPage },
];

const RenewBusinessWebController = ({
  partner,
  service,
  location,
  history,
  initialStep=0
}) => {

  const [step, setStep] = useState(initialStep);
  const [app, setApp] = useState({step: 0});
  
  const moveNextStep = (nextStep) => {
    if (typeof(nextStep) === "number") {
      setStep(nextStep);
    } else {
      nextStep = step+1;
      setStep(cs => cs+1);
    }
    setApp({...app, step: nextStep});
  }

  const movePrevStep = () => {
    if (step === 0) {
      history.goBack();
    } else {
      setStep(cs => cs-1);
    }
  }

  const handleStep = (step) => {
    const actualStep = step + 2;
    setStep(actualStep);
  };

   const page = pages[step];
  const PageComponent = page.component;
  
  const compProps = {
    partner,
    service,
    location,
    history,
    moveNextStep,
    movePrevStep,
    appService: Service.lookup(`${partner.id}:OnlineBusinessRenewalService`, "bpls"),
    stepCompleted: step < app.step,
    title: "Business Renewal Application",
  };

  return (
    <StateProvider initialState={initialState} reducer={reducer}>
      <Page>
        {step > 1 && (
          <Panel target="left" style={styles.stepperContainer}>
            <Stepper
              steps={pages.filter(pg => pg.step > 1)}
              completedStep={app.step - 1}
              activeStep={step - 2}
              handleStep={handleStep}
            />
          </Panel>
        )}
        <Content center>
          <Panel>
            <PageComponent page={page} {...compProps} />
          </Panel>
        </Content>
      </Page>
      }
    </StateProvider>
  );
};

const styles = {
  stepperContainer: {
    paddingTop: 30,
    paddingLeft: 40,
  },
};

export default RenewBusinessWebController;
