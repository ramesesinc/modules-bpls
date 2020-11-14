import React from 'react'
import {
  Decimal,
  Integer,
}
from "rsi-react-web-components";
import styles from "./EditInfo.css";

const components = {
  "decimal": Decimal,
  "integer": Integer,
}

const EditInfo = ({
  dataType="integer",
  caption,
  name,
}) => {
  const HandlerComponent = components[dataType];
  
  return (
    <div className={styles.EditInfo}>
      <label>{caption}</label>
      <HandlerComponent
        className={styles.EditInfo__item}
        name={name}
        fullWidth={false}
        variant='outlined'
        size='small'
      />
    </div>
  )
}

export default EditInfo
