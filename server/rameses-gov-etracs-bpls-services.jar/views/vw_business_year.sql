DROP VIEW IF EXISTS vw_business_year;
CREATE VIEW vw_business_year AS
SELECT 
b.*,
bac.businessname,
gi.orgtype,
gi.tradename,
gi.owner_objid,
gi.owner_name,
gi.owner_address_objid,
gi.owner_address_text,
gi.address_type,
gi.address_text,
gi.address_bldgno,
gi.address_unitno,
gi.address_subdivision,
gi.address_bldgname,
gi.address_street,
gi.address_barangay_objid,
gi.address_barangay_name,	
gi.address_city,
gi.address_province,
gi.address_municipality,
gi.address_pin,
gi.lessor_objid,
gi.lessor_name,
gi.lessor_address_text,
gi.lessor_address_objid,
gi.rentedaddressid,
gi.ownedaddressid,
gi.phoneno,
gi.mobileno,
gi.email,
ba.apptype,
ba.appno,
ba.appdate,
bt.state   
FROM business_year b
INNER JOIN business_account bac ON b.businessacctid=bac.objid
INNER JOIN business_generalinfo gi ON b.geninfoid = gi.objid
INNER JOIN business_application ba ON b.appid = ba.objid
INNER JOIN business_application_task bt ON ba.taskid=bt.taskid