DROP VIEW IF EXISTS vw_business_application_subproc;
CREATE VIEW vw_business_application_subproc AS
SELECT 
bs.objid,
bs.taskid,
br.org_objid AS org_objid,
ba.appno,
ba.apptype,
ba.appdate,
byr.year,
byr.monthlyrent,
bac.objid AS businessacctid,
bac.bin,
bac.businessname,
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
bgi.phoneno,
bgi.mobileno,
bgi.email
FROM business_application_subproc bs 
INNER JOIN businessrequirementtype br ON bs.typeid = br.objid
INNER JOIN business_application ba ON bs.appid=ba.objid
INNER JOIN business_year byr ON byr.objid=ba.businessyearid
INNER JOIN business_account bac ON bac.objid = byr.businessacctid
INNER JOIN business_generalinfo bgi ON  bgi.objid = ba.geninfoid