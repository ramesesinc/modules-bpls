DROP VIEW IF EXISTS vw_business_account_lob;
CREATE VIEW vw_business_account_lob AS
SELECT 
   bl.objid,
   ba.objid AS appid,	
   byr.objid AS businessyearid,
   bl.lobid AS lobid,
   byr.businessacctid,
   lob.name AS lob_name,
   lob.classificationid AS lob_classificationid,
   bl.particulars,
   bl.assessmenttype,

   (SELECT decimalvalue FROM business_application_info WHERE appid=ba.objid AND lobid=lob.objid AND name='CAPITAL' ) AS capital,
   (SELECT decimalvalue FROM business_application_info WHERE appid=ba.objid AND lobid=lob.objid AND name='GROSS') AS gross,
   (SELECT 1 FROM lob_lobattribute WHERE lobid=lob.objid AND name='ESSENTIAL' ) AS essential
   
FROM business_application_lob bl
INNER JOIN lob ON bl.lobid = lob.objid
INNER JOIN business_application ba ON bl.appid=ba.objid
INNER JOIN business_year byr ON ba.businessyearid=byr.objid
LEFT JOIN business_application_lob_retired blr ON bl.objid = blr.businesslobid
WHERE blr.objid IS NULL;