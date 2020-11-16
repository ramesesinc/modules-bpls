import React, { useState, useEffect } from "react";
import {
  Card,
  Panel,
  FormPanel,
  Error,
  Button,
  ActionBar,
  BackLink,
  Spacer,
  Title,
  Label,
  Text,
  Subtitle,
  Subtitle2,
  useData,
} from "rsi-react-web-components";
import "rsi-react-web-components/dist/index.css";

import LobList from "./components/LobList";


const ConfirmPage = ({
  moveNextStep,
  movePrevStep,
  appService, 
  title,
  stepCompleted
}) => {

  const [ctx, dispatch] = useData();
  const { contact, app: initialApp } = ctx;

  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [app, setApp] = useState(initialApp);

  useEffect(() => {
    setLoading(true);
    appService.invoke("getInfos", {objid: app.objid}, (err, app) => {
      if (!err) {
        setApp(app);
      } else {
        setError(err);
      }
      setLoading(false);
    })
  }, [])

  const submit = () => {
    const submittedApp = { objid: app.objid, step: 2}
    appService.invoke("submit", submittedApp, (err, app) => {
      if (!err) {
        moveNextStep();
      } else {
        setError(err);
      }
    })
  }

  return (
    <Card>
      <Error msg={error}/>
      <FormPanel context={app} handler={setApp}>
        <Title>{title}</Title>
        <Subtitle2>Tracking No. {app.controlno}</Subtitle2>
        <Subtitle>Confirmation</Subtitle>
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
        {app.infos.map(info => 
          <Label key={info.name} caption={info.caption} captionStyle={{width: 300}} >{info.value}</Label>
        )}
        <Spacer />
        <LobList lobs={app.lobs} isPreviousInfo={false}  />
        <ActionBar>
          <BackLink caption="Back" action={movePrevStep} />
          <Button caption="Submit" action={submit} />
        </ActionBar>
      </FormPanel>
    </Card>
  );
};

export default ConfirmPage;
