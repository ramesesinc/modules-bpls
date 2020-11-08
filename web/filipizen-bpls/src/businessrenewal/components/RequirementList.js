import React, { useState, useEffect } from "react";
import { Button, UploadButton, BackupIcon } from "rsi-react-web-components";
import styles from "./RequirementList.css";

const RequirementList = ({ requirements, deleteRequirement, onUpload }) => {
  const [requirement, setRequirement] = useState({ ref:{}, attachment:{}});
  const [selectedIndex, setSelectedIndex] = useState(-1);

  useEffect(() => {
    if (requirements.length > 0 && selectedIndex < 0) {
      setRequirement(requirements[0]);
      setSelectedIndex(0);
    }
  }, [requirements]);

  const onSelectItem = (item) => {
    setSelectedIndex(requirements.findIndex(req => req.objid === item.objid));
    setRequirement(item);
  };

  return (
    <div className={styles.container}>
      <div className={styles.list}>
        {requirements.map((req, idx) => {
          const classNames = selectedIndex === idx ? `${styles.listItem} ${styles.selected}` : styles.listItem;
          return (
            <div key={req.objid} 
              className={classNames} 
              onClick={() => onSelectItem(req)}
            >
              <label>{req.ref.title}</label>
              {req.attachment && req.attachment.path && 
                <BackupIcon style={{fontSize: 20, color: "green"}} />
              }
            </div>
          )
        })}
      </div>
      <div className={styles.viewer}>
          <div className={styles.menubar}>
            <label className={styles.menubar__label}>{requirement.ref.title}</label>
            {requirement.attachment.path &&
              <Button caption="Delete" color="secondary" action={() => deleteRequirement(requirement)}/>
            }
          </div>
          <div className={styles.imageContainer}>
            {requirement.attachment.path ? (
              <img className={styles.imageContainer__image}
                src={requirement.attachment.path}
                alt={requirement.attachment.name} />
              ): (
                <UploadButton 
                  key={requirement.objid} 
                  fileId={requirement.objid}
                  data={requirement}
                  onUpload={(attachment) => onUpload(attachment, requirement)}
                  uploadedFile={requirement.attachment}
                />
            )}
          </div>
      </div>
    </div>
  );
};

export default RequirementList;
