import React from "react";
import {
  Table,
  TableColumn,
  currencyFormat,
} from "rsi-react-web-components";
import "rsi-react-web-components/dist/index.css";

const LobList = ({ 
    lobs,
    isPreviousInfo=true
}) => {
  return (
    <React.Fragment>
      <Table items={lobs} showPagination={false}>
        <TableColumn caption="Line of Business" expr="lob.name" />
        <TableColumn
          caption={isPreviousInfo ? "Previous Gross (Php)" : "Gross (Php)"}
          expr={(item) => currencyFormat((isPreviousInfo ? item.prevgross : item.gross))}
          type="decimal"
          align="right"
        />
      </Table>
    </React.Fragment>
  );
};

export default LobList;
