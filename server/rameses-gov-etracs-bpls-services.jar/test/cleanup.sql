UPDATE business_account SET currentyearid = NULL,closureid = NULL, ;
UPDATE business_year SET appid = NULL, geninfoid = NULL, permitid = NULL;
UPDATE business_application SET taskid = NULL, geninfoid = NULL, businessyearid = NULL;
UPDATE business_permit SET appid = NULL, businessyearid = NULL, geninfoid = NULL;

DELETE FROM business_payment_item;
DELETE FROM business_payment;
DELETE FROM business_closure;
DELETE FROM business_permit_lob;
DELETE FROM business_permit;
DELETE FROM business_application_fee;
DELETE FROM business_application_info;
DELETE FROM business_application_requirement;
DELETE FROM business_application_lob_retired;
DELETE FROM business_application_lob;

DELETE FROM business_generalinfo;
DELETE FROM business_application_task;
DELETE FROM business_application;
DELETE FROM business_year;
DELETE FROM business_account;

