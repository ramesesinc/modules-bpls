import React, { useState } from "react";
import {
  Button,
  Radio,
  ActionBar,
  BackLink,
  Item,
  Spacer,
  Error,
  Text,
  Subtitle,
  Page,
  Card,
  Title,
  useData,
} from 'rsi-react-web-components';
import { ACTIONS } from "./reducer"

const SelectTxnTypePage = ({
  partner, 
  service, 
  history, 
  title,
  appService,
  moveNextStep,
}) => {
  const [error, setError] = useState();
  const [appType, setAppType]= useState("new");
  const [appno, setAppno] = useState();

  const [ctx, dispatch] = useData();

  const submitAppType = () => {
    if (appType === "new") {
      moveNextStep();
    } else {
      if (!appno) {
        setError("Tracking No. is required.");
      } else {
        appService.invoke("getApplication", {controlno: appno}, (err, app) => {
          if (!err) {
            app.infos = [];
            app.lobs = [];
            dispatch({type: ACTIONS.SET_APP, app});
            moveNextStep(app.step);
          } else  {
            setError(err);
          }
        });
      };
    };
  }

  return (
    <Card>
      <Title>{service.title}</Title>
      <Subtitle>Select an action</Subtitle>
      <Spacer height={30} />
      <Radio value={appType} onChange={setAppType} >
        <Item caption="Create New Application" value="new" />
        <Item caption="Resume Pending Application" value="resume" />
      </Radio>
      <Text
        caption="Application Tracking No."
        value={appno} onChange={setAppno}
        visibleWhen={appType === "resume"}
        variant="outlined"
        fullWidth={false}
        required
        style={{marginLeft: 40}}
        error={error}
        helperText={error}
        size="small"
        autoFocus={true} 
        />
      <ActionBar>
        <BackLink caption="Cancel" action={() => history.goBack()} />
        <Button caption="Next" action={submitAppType} />
      </ActionBar>
    </Card>
  )
}

export default SelectTxnTypePage;
