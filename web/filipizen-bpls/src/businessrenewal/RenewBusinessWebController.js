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

import InitialPage from "./InitialPage";
import GeneralInfoPage from "./GeneralInfoPage";
import EditInfoPage from "./EditInfoPage";
import RequirementPage from "./RequirementPage";
import ConfirmPage from "./ConfirmPage";
import CompletedPage from "./CompletedPage";

const pages = [
  { step: 0, name: "initial", caption: "Initial", component: InitialPage },
  { step: 1, name: "info", caption: "General Information", component: GeneralInfoPage },
  { step: 2, name: "enter-info", caption: "Enter Information", component: EditInfoPage },
  { step: 3, name: "requirements", caption: "Requirements", component: RequirementPage },
  { step: 4, name: 'confirm', caption: 'Confirm', component: ConfirmPage },
  { step: 5, name: 'completed', caption: 'Completed', component: CompletedPage },
];

const RenewBusinessWebController = ({
  partner,
  service,
  location,
  history,
  initialStep=0, //TODO: SET TO 0
}) => {

  const [step, setStep] = useState(initialStep);
  const [app, setApp] = useState({});
  
  const moveNextStep = () => {
    setStep(cs => cs+1);
  }

  const movePrevStep = () => {
    if (step === 0) {
      history.goBack();
    } else {
      setStep(cs => cs-1);
    }
  }

  const handleStep = (step) => {
    setStep(step);
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
        {step > 0 && app.step < pages.length && (
          <Panel target="left" style={styles.stepperContainer}>
            <Stepper
              steps={pages}
              completedStep={app.step}
              activeStep={step}
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
