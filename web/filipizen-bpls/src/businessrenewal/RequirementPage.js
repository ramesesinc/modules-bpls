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


const Requirement = ({
  requirement,
  onUpload
}) => {

  const uploadHandler = (file) => {
    onUpload(requirement, file)
  }
  
  return (
    <Panel style={{display: "flex", justifyContent: "flex-start"}}>
      <Label style={{marginRight: 20}}>{requirement.caption}</Label>
      <UploadButton 
        onUpload={uploadHandler} 
        uploadedFile={requirement.file} 
      />
    </Panel>
  );
}

const RequirementPage = ({
  appService,
  moveNextStep,
  movePrevStep,
  title,
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
        setRequirements(requirements);
      } else {
        setError(err);
      }
      setLoading(false);
    });
  }, [])


  const submit = () => {
    moveNextStep();
  }

  const onUpload = (file, requirement) => {
    const updatedRequirements = requirements.map(req => {
      if (req.objid === requirement.objid ) {
        return {...requirement, file};
      }
      return req;
    })
    console.log("updatedRequirements", updatedRequirements)
    setRequirements(updatedRequirements);
  }

  return (
    <Card>
      <Error msg={error}/>
      <Title>{title}</Title>
      <Subtitle>Requirements</Subtitle>
      <h4>Please attach the following documents:</h4>
      <Panel>
      {requirements.map(req => 
        <UploadButton 
          key={req.objid} 
          data={req}
          caption={req.caption} 
          onUploadFile={onUpload}
          uploadedFile={req.file}
        />
      )}
      </Panel>
      <ActionBar>
        <BackLink caption="Back" action={movePrevStep} />
        <Button caption="Next" action={submit} />
      </ActionBar>
    </Card>
  );
};


export default RequirementPage;
