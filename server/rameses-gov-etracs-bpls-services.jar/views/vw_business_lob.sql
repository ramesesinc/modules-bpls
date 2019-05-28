DROP VIEW IF EXISTS vw_business_lob;
CREATE VIEW vw_business_lob AS  
SELECT 
  bl.*,
  lob.name AS lob_name,
  lob.psic_objid AS lob_psic_objid,
  lob.classification_objid AS lob_classification_objid,
  CASE WHEN br.objid IS NULL THEN 0 ELSE 1 END AS retired  
FROM business_application_lob bl
INNER JOIN lob ON bl.lobid = lob.objid
LEFT JOIN business_application_lob_retired br ON bl.objid=br.businesslobid;
