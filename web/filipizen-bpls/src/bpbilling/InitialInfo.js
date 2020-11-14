import React, { useState } from 'react'
import {
  Text,
  Title,
  Button,
  ActionBar,
  Subtitle,
  Spacer,
  Service,
  Error,
  BackLink,
  useData,
  Card
} from 'rsi-react-web-components'

const InitialInfo = ({
  title,
  partner,
  moveNextStep,
  movePrevStep,
}) => {

  const [ctx, dispatch] = useData();
  const { txntype } = ctx;

  const [error, setError] = useState()
  const [loading, setLoading] = useState(false)
  const [refno, setRefno] = useState()

  const getBilling = async () => {
    const params = {txntype, refno, qtr: 4, showdetails:true};
    const svc = Service.lookupAsync(`${partner.id}:OnlineBusinessBillingService`, "bpls");
    return await svc.invoke("getBilling", params);
  }  

  const loadBill = () => {
    setLoading(true);
    setError(null);
    getBilling().then(data => {
      const bill = data.info;
      bill.qtr = 4;
      if (bill.amount == 0) {
        bill.items = [];
      }
      dispatch({type: "SET_BILL", refno: refno, bill: bill});
      moveNextStep();
    }).catch(err => {
      setError(err.toString());
      setLoading(false)
    })
  }

  return (
    <React.Fragment>
    <Card>
      <Title>{title}</Title>
      <Subtitle>Initial Information</Subtitle>
      <Spacer />
      <Error msg={error} />
      <Text 
        name="appno" 
        caption="BIN or Application No." 
        value={refno} 
        onChange={setRefno} 
        autoFocus={true} 
      />
      <ActionBar>
        <BackLink caption='Back' variant="text" action={movePrevStep} />
        <Button caption='Next' action={loadBill} loading={loading} disabled={loading} />
      </ActionBar>
    </Card>
    </React.Fragment>
  )
}

export default InitialInfo
