import React, { useState, useEffect } from 'react'
import {
  Card,
  Panel,
  Button,
  Label,
  ActionBar,
  Spacer,
  Service,
  Error,
  Subtitle,
  Title,
  BackLink,
  useData,
  Table,
  TableColumn,
  currencyFormat
} from 'rsi-react-web-components'

import PayOption from './PayOption'

const ORIGIN = 'filipizen'

const OnlineBilling = ({
  title,
  partner,
  onCancel,
  onSubmit,
  error: paymentError
}) => {
  const [ctx, dispatch] = useData();
  const { refno, txntype, contact, bill: initialBill } = ctx;

  const [bill, setBill] = useState(initialBill);
  const [error, setError] = useState(paymentError);
  const [loading, setLoading] = useState(false)
  const [showPayOption, setShowPayOption] = useState(false)
  const [qtr, setQtr] = useState(4)
  const [barcode, setBarcode] = useState()

  const getBilling = async () => {
    const params = {txntype, refno, qtr, showdetails:true};
    const svc = await Service.lookupAsync(`${partner.id}:OnlineBusinessBillingService`);
    return await svc.getBilling(params)
  }

  const loadBill = () => {
    setLoading(true);
    setError(null);
      getBilling().then(bill => {
        console.log("BILL RECEIVED", bill);
        bill.qtr = qtr;
        if (bill.amount == 0) {
          bill.items = [];
        }
        setBill(bill);
        setBarcode(`51001:${bill.billno}`); 					
        setLoading(false)
      }).catch(err => {
        setError(err.toString());
        setLoading(false)
      })
  }

  useEffect(() => {
    if (refno) {
      loadBill();
    }
  }, [qtr])

  const payOptionHandler = (billOption) => {
    setShowPayOption(false)
    setQtr(billOption.billtoqtr);
  }

  const checkoutPayment = () => {
    onSubmit({
      refno,
      txntype,
      origin: ORIGIN,
      orgcode: partner.id,
      qtr,
      info: { data: bill, qtr },
      paidby: bill.paidby,
      paidbyaddress: bill.paidbyaddress,
      amount: bill.amount,
      particulars: `Business Tax for Application No. ${bill.appno}`,
    })
  }

  const onCancelBilling = () => {
    onCancel(0);
  }

  const blur = contact && contact.email !== bill.email;

  return (
    <Card style={{maxWidth: 800}}>
      <Title>{title}</Title>
      <Subtitle>Billing Information</Subtitle>
      <Spacer />
      <Error msg={error} />
      <Panel>
        <Label context={bill} caption="Application No." expr="appno" />
        <Label context={bill} caption="Application Type" expr="apptype" />
        <Label context={bill} caption="Date Filed" expr="appdate" />
        <Label context={bill} caption="BIN" expr="bin" />
        <Label context={bill} caption="Trade Name" expr="tradename" blur={blur} />
        <Label context={bill} caption="Owner Name" expr="ownername" blur={blur} />
        <Label context={bill} caption="Business Address" expr="address" blur={blur} />
        <Spacer />
        <Panel style={{display: "flex", justifyContent: "flex-start"}}>
          <Button variant="outlined" caption='Pay Option' action={() => setShowPayOption(true)} />
        </Panel>
        <Table items={bill ? bill.items : []} size="small" showPagination={false} >
          <TableColumn caption="Particulars" expr={item => (item.lobname ? item.lobname : "") +  ` -${item.account}`} />
          <TableColumn caption="Amount" expr="amount" align="right" format="currency" />
          <TableColumn caption="Surcharge" expr="surcharge" align="right" format="currency" />
          <TableColumn caption="Interest" expr="interest" align="right" format="currency" />
          <TableColumn caption="Total" expr="total" align="right" format="currency" />
        </Table>
        <Panel style={{display: "flex", flexDirection: "row", justifyContent: "flex-end", paddingRight: 15}}>
          <Label context={bill} caption="Bill Amount:" expr={item => currencyFormat(item.amount)} />
        </Panel>
      </Panel>
      <ActionBar disabled={loading}>
        <BackLink caption='Back' action={onCancelBilling} />
        <Button caption='Confirm Payment' action={checkoutPayment} disableWhen={bill.amount === 0} />
      </ActionBar>

      <PayOption
          initialValue={bill && { qtr }}
          open={showPayOption}
          onAccept={payOptionHandler}
          onCancel={() => setShowPayOption(false)}
        />
    </Card>
  )
}

export default OnlineBilling
