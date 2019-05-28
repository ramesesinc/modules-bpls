DROP VIEW IF EXISTS vw_business_application_lob;
CREATE VIEW vw_business_application_lob AS
SELECT 
   bl.objid,
   bl.appid,   
   bl.lobid,
   lob.name AS lob_name,
   lob.classificationid AS lob_classificationid,
   bl.particulars,
   bl.assessmenttype,

   (SELECT decimalvalue FROM business_application_info WHERE appid=bl.appid AND lobid=lob.objid AND name='CAPITAL' ) AS capital,
   (SELECT decimalvalue FROM business_application_info WHERE appid=bl.appid AND lobid=lob.objid AND name='GROSS') AS gross,
   (SELECT 1 FROM lob_lobattribute WHERE lobid=lob.objid AND lobattributeid='ESSENTIAL' ) AS essential
   
FROM business_application_lob bl
INNER JOIN lob ON bl.lobid = lob.objid

UNION 

SELECT 
   blr.objid,
   blr.appid,
   bl.lobid,
   lob.name AS lob_name,
   lob.classificationid AS lob_classificationid,
   blr.particulars,
   'RETIRE' AS assessmenttype,
   NULL AS capital,
   (SELECT decimalvalue FROM business_application_info WHERE appid=blr.appid AND lobid=lob.objid AND name='GROSS') AS gross,
   (SELECT 1 FROM lob_lobattribute WHERE lobid=lob.objid AND lobattributeid='ESSENTIAL' ) AS essential
FROM business_application_lob_retired blr
INNER JOIN business_application_lob bl ON blr.businesslobid=bl.objid
INNER JOIN lob ON bl.lobid = lob.objid
INNER JOIN business_application ba ON bl.appid=ba.objid;
