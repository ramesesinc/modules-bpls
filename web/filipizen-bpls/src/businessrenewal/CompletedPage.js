import React from "react";
import {
  Card,
  Subtitle,
  Subtitle2,
  Panel,
  Button,
  ActionBar,
  Spacer,
  Title,
  useData,
} from "rsi-react-web-components";
import "rsi-react-web-components/dist/index.css";


const CompletedPage = ({
  history,
  location,
  partner,
  title,
}) => {

  const [ctx, dispatch] = useData();
  const { contact, app } = ctx;

  const completeHandler = () => {
    history.replace(`/partner/${partner.name}/services`, {partner});
  }

  return (
    <Card>
      <Panel>
        <Title>{title}</Title>
        <Subtitle2>{`Tracking No. ${app.controlno}`}</Subtitle2>
        <Subtitle>Application Completed</Subtitle>
        <Spacer height={30} />
        <p>
        Your application has been successfully submitted. 
        </p>
        <p>
        A notification would be sent on your business email account
        upon approval of your application for payment.
        </p>
        <p>
        Thank you for using this service.
        </p>
        <ActionBar>
          <Button caption="Return" action={completeHandler} />
        </ActionBar>
      </Panel>
    </Card>
  );
};

export default CompletedPage;
