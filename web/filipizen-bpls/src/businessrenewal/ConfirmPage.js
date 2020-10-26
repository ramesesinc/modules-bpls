import React, { useState, useEffect } from "react";
import {
  Card,
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
  useData,
} from "rsi-react-web-components";
import "rsi-react-web-components/dist/index.css";

import LobList from "./components/LobList";


const ConfirmPage = ({
  moveNextStep,
  movePrevStep,
  appService, 
  title,
}) => {

  const [ctx, dispatch] = useData();
  const { contact, app: initialApp } = ctx;

  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [app, setApp] = useState(initialApp);

  useEffect(() => {
    setLoading(true);
    appService.getApplication({objid: app.objid}, (err, app) => {
      if (!err) {
        setApp(app);
      } else {
        setError(err);
      }
      setLoading(false);
    })
  }, [])

  const submit = () => {
    appService.submit(app, (err, app) => {
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
        <Subtitle>Confirmation</Subtitle>
        <Spacer height={30} />
        <Text caption="BIN" name="bin" readOnly={true} />
        <Text caption="Trade Name" name="tradename" readOnly={true} />
        <Text caption="Owner Name" name="owner.name" readOnly={true} />
        <Text caption="Business Address" name="businessaddress" readOnly={true} />
        <Spacer />
        {app.infos.map(info => 
          <Label key={info.name} caption={info.caption} >{info.value}</Label>
        )}
        <Spacer />
        <LobList lobs={app.lobs} isPreviousInfo={false}  />
        <ActionBar>
          <BackLink caption="Back" action={movePrevStep} />
          <Button caption="Next" action={submit} />
        </ActionBar>
      </FormPanel>
    </Card>
  );
};

export default ConfirmPage;
