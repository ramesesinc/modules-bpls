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
  autoFocus=false,
  error=false,
  helperText
}) => {
  const HandlerComponent = components[dataType];
  
  return (
    <div className={styles.EditInfo}>
      <label style={{width: 350}}>{caption}</label>
      <HandlerComponent
        className={styles.EditInfo__item}
        name={name}
        fullWidth={false}
        variant='outlined'
        size='small'
        required={true}
        autoFocus={autoFocus}
        helperText={helperText}
        error={error}
      />
    </div>
  )
}

export default EditInfo
