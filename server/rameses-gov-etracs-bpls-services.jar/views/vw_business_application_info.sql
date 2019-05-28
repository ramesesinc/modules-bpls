DROP VIEW IF EXISTS vw_business_application_info; 
CREATE VIEW vw_business_application_info AS
SELECT ai.*,
CASE ai.datatype
WHEN 'decimal' THEN ai.decimalvalue
WHEN 'integer' THEN ai.intvalue
WHEN 'date' THEN ai.datevalue
WHEN 'boolean' THEN ai.booleanvalue
ELSE ai.stringvalue
END AS value,
lob.name AS lob_name,
lob.objid AS lob_objid 
FROM business_application_info ai
LEFT JOIN lob ON ai.lobid = lob.objid
WHERE type = 'appinfo';