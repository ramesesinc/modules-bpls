DROP VIEW IF EXISTS vw_business_account;
CREATE VIEW vw_business_account AS 
SELECT ba.*,
byr.year, 
byr.monthlyrent,
byr.renewaldate,
bgi.objid AS geninfoid, 
bgi.orgtype,
bgi.tradename,
bgi.owner_objid,
bgi.owner_name,
bgi.owner_address_objid,
bgi.owner_address_text,
bgi.address_type,
bgi.address_text,
bgi.address_bldgno,
bgi.address_unitno,
bgi.address_subdivision,
bgi.address_bldgname,
bgi.address_street,
bgi.address_barangay_objid,
bgi.address_barangay_name,
bgi.address_city,
bgi.address_province,
bgi.address_municipality,
bgi.address_pin,
bgi.lessor_objid,
bgi.lessor_name,
bgi.lessor_address_text,
bgi.lessor_address_objid,
bgi.rentedaddressid,
bgi.ownedaddressid,
bgi.refid,
bgi.phoneno,
bgi.mobileno,
bgi.email,
bp.objid AS permitid,
bp.permitno,
bp.expirydate AS permitexpirydate,
bt.state AS taskstate
FROM business_account ba
INNER JOIN business_year byr ON ba.currentyearid=byr.objid
INNER JOIN business_application bapp ON byr.appid = bapp.objid
INNER JOIN business_application_task bt ON bapp.taskid=bt.taskid
INNER JOIN business_generalinfo bgi ON byr.geninfoid = bgi.objid
LEFT JOIN business_permit bp ON byr.permitid = bp.objid 


