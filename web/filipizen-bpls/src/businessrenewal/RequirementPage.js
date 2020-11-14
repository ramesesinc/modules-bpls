import React, { useState, useEffect } from "react";
import {
  Card,
  Panel,
  Error,
  Button,
  ActionBar,
  BackLink,
  Title,
  Label,
  Subtitle,
  useData,
  UploadButton
} from "rsi-react-web-components";

import { ACTIONS } from "./reducer";
import RequirementList from "./components/RequirementList";

const RequirementPage = ({
  appService,
  moveNextStep,
  movePrevStep,
  title,
  stepCompleted
}) => {
  
  const [ctx, dispatch] = useData();
  const { contact, app } = ctx;

  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [requirements, setRequirements] = useState([]);

  useEffect(() => {
    setLoading(true);
    appService.invoke("getRequirements", app, (err, requirements) => {
      if (!err) {
        dispatch({type: ACTIONS.SET_APP, app: {...app, step: 4}});
        setRequirements(requirements);
      } else {
        setError(err);
      }
      setLoading(false);
    });
  }, []);

  const deleteRequirement = (deletedRequirement) => {
    const deletedIdx = requirements.findIndex(req => req.objid === deletedRequirement.objid);
    const updatedRequirements = [...requirements];
    updatedRequirements[deletedIdx].attachment = {};
    setRequirements(updatedRequirements);
    saveRequirements(updatedRequirements);
  };

  const saveRequirements = (updatedRequirements) => {
    const updatedApp = {objid: app.objid, requirements: updatedRequirements};
    appService.invoke("update", updatedApp, (err, _) => {
      if (err) {
        setError(err);
      }
    });
  }

  const submit = () => {
    setLoading(false);
    const updatedApp = {objid: app.objid, step: app.step+1}
    appService.invoke("update", updatedApp, (err, _) => {
      if (!err) {
        moveNextStep();
      } else {
        setError(err);
      }
      setLoading(false);
    });
  }

  const onUpload = (attachment, requirement) => {
    const idx = requirements.findIndex(req => req.objid === requirement.objid);
    const updatedRequirements = [...requirements];
    updatedRequirements[idx].attachment = attachment;
    setRequirements(updatedRequirements);
    saveRequirements(updatedRequirements);
  }

  const requirementsCompleted = requirements.findIndex(req => typeof(req.attachment) === "undefined") == -1;

  return (
    <Card>
      <Error msg={error}/>
      <Title>{title}</Title>
      <Subtitle>Requirements</Subtitle>
      <h4>Please attach the following documents:</h4>
      <RequirementList 
        requirements={requirements} 
        onUpload={onUpload}
        deleteRequirement={deleteRequirement} 
      />
      <ActionBar visibleWhen={!stepCompleted}>
        <BackLink caption="Back" action={movePrevStep} />
        <Button caption="Next" action={submit} disableWhen={!requirementsCompleted} />
      </ActionBar>
    </Card>
  );
};


export default RequirementPage;
