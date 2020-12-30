import React, { useState, useEffect } from "react";
import {
  Card,
  FormPanel,
  Panel,
  Error,
  Button,
  ActionBar,
  BackLink,
  Spacer,
  Title,
  Text,
  Subtitle,
  Subtitle2,
  useData,
} from "rsi-react-web-components";

import EditInfo from "./components/EditInfo";
import { ACTIONS } from "./reducer";

const EditInfoPage = ({
  appService,
  moveNextStep,
  movePrevStep,
  title
}) => {
  
  const [ctx, dispatch] = useData();
  const { contact, app: initialApp } = ctx;
  const [errors, setErrors] = useState([]);
  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [app, setApp] = useState(initialApp);

  useEffect(() => {
    setLoading(true);
    appService.invoke("getInfos", app, (err, app) => {
      if (!err) {
        setApp(app);
        dispatch({type: ACTIONS.SET_APP, app});
      } else {
        setError(err);
      }
      setLoading(false);
    });
  }, [])

  const validLobInfos = () => {
    const errors = [];
    app.lobs.forEach((lob, idx) => {
      if (!lob.gross) 
        errors.push("Gross is required");
      else 
        errors.push(null);
    });
    setErrors(errors);
    return errors.findIndex(err => err != null) < 0;
  }

  const submitInfo = () => {
    if (!validLobInfos()) return;

    setError(null);
    setLoading(true);
    const infos = {objid: app.objid, step: 4, lobs: app.lobs, infos: app.infos};
    appService.invoke("saveInfos", infos, (err, res) => {
      if (!err) {
        moveNextStep();
      } else {
        setError(err);
      }
      setLoading(false);
    });
  }

  return (
    <Card>
      <Error msg={error}/>
      <FormPanel context={app} handler={setApp}>
        <Title>{title}</Title>
        <Subtitle2>Tracking No. {app.controlno}</Subtitle2>
        <Subtitle>Edit Information</Subtitle>
        <Spacer height={30} />
        <Panel row>
            <Text caption="BIN" name="bin" readOnly={true} />
            <Text caption="Application No." name="controlno" readOnly={true} />
          </Panel>
          <Panel row>
            <Text caption="Application Year" name="appyear" readOnly={true} />
            <Text caption="Application Type" name="apptype" readOnly={true} />
          </Panel>
        <Text caption="Trade Name" name="tradename" readOnly={true} />
        <Text caption="Owner Name" name="owner.name" readOnly={true} />
        <Text caption="Business Address" name="businessaddress" readOnly={true} />
        <Spacer />
          <h4>Business Information</h4>
          {app.infos.map((info, idx) => 
            <EditInfo
              key={`${info.name}:${idx}`}
              name={`infos[${idx}].value`}
              dataType={info.datatype}
              caption={info.caption}
              autoFocus={idx===0}
            />
          )}
          <Spacer />
          <Panel style={styles.lobTitles}>
            <h4>Line of Businesses</h4>
            <h4>Last Year Gross (Php)</h4>
          </Panel>
          {app.lobs.map((lob, idx) => 
            <EditInfo
              key={`${lob.name}:${idx}`}
              name={`lobs[${idx}].gross`}
              dataType="decimal"
              caption={lob.lob.name}
              error={errors[idx]}
              helperText={errors[idx]} 
            />
          )}
        <ActionBar>
          <BackLink caption="Back" action={movePrevStep} />
          <Button caption="Next" action={submitInfo} loading={loading} disableWhen={loading} />
        </ActionBar>
      </FormPanel>
    </Card>
  );
};

const styles = {
  lobTitles: {
    display: "flex",
    justifyContent: "space-between",
  },
}


export default EditInfoPage;
