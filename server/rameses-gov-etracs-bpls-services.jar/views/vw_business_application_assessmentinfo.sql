DROP VIEW IF EXISTS vw_business_application_assessmentinfo; 
CREATE VIEW vw_business_application_assessmentinfo AS
SELECT *,
CASE datatype
WHEN 'decimal' THEN decimalvalue
WHEN 'integer' THEN intvalue
WHEN 'date' THEN datevalue
WHEN 'boolean' THEN booleanvalue
ELSE stringvalue
END AS value 
FROM business_application_info WHERE type = 'assessment';

