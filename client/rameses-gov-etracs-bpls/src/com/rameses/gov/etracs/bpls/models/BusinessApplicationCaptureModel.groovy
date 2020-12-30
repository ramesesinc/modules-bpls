package com.rameses.gov.etracs.bpls.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import java.rmi.server.*;

/****************************************************
* capture types:
*   info - basic capture info only for current year
*   unpaid - business has remaining balance
*   processing - application still unfinished
*   delinquent - has delinquent
*   datasource - use datasource
*****************************************************/
class BusinessApplicationCaptureModel extends PageFlowController {

    @Service("DateService")
    def dateSvc;

    @Service("BusinessCaptureService")
    def service;

    @Script("BusinessApplicationUtil")
    def application;

    @Script("BusinessVerificationUtil")
    def verifyList;

    @Script("BusinessOwnerUtil")
    def owner;

    @Script("BusinessLobUtil")
    def lob;

    @Script("BusinessAddressUtil")
    def address;

    @Script("BusinessCaptureUtil")
    def capture;

    @Script("BusinessInfoUtil")
    def appinfo;

    @FormTitle
    def title = "Capture Business";

    @Service("BusinessUserRoleService")
    def userRoleSvc;

    def entity;

    def start() {
        return super.start();
    }

    void init() {
        capture.validateTxnType(); 
        application.init([ txnmode:'CAPTURE' ]);
        
        def currentYear = dateSvc.getServerYear();
        switch( capture.type ) {
            case 'current':
                entity.apptype = capture.current_apptype;
                entity.appyear = currentYear;
                entity.activeyear = currentYear;
                entity.state = 'ACTIVE';
                break;
            case 'processing':     
                entity.apptype = capture.processing_apptype;
                entity.dtfiled = capture.processing_dateapplied;
                entity.appyear = currentYear;
                entity.state = 'PROCESSING';
                break;
            case 'delinquent_renew':     
                entity.apptype = 'RENEW';
                entity.appyear = capture.delinquent_renew_year;
                entity.activeyear = entity.appyear;
                entity.yearstarted = null;
                entity.state = 'ACTIVE';
                if(entity.appyear < 2000 )
                    throw new Exception("Last year renewed must be greater than 2000");
                if( entity.appyear >= currentYear )
                    throw new Exception("Please choose a year before the current year");
                break;
            case 'delinquent_new':     
                entity.apptype = 'NEW';
                entity.appyear = capture.delinquent_new_year;
                entity.activeyear = entity.appyear;
                entity.yearstarted = entity.appyear;
                if(entity.appyear < 2000 )
                    throw new Exception("Last year renewed must be greater than 2000");
                entity.state = 'ACTIVE';
                if( entity.appyear > currentYear )
                    throw new Exception("Please choose a year before the current year");
                break;
        }    
        lob.reset();
        lob.lobAssessmentType = entity.apptype;
    }
    
    void verifyTxnDates() {
        def yearfiled = Integer.parseInt( entity.dtfiled.toString().split('-')[0]); 
        if ( yearfiled != entity.activeyear ) {
            throw new Exception('Date Applied must be within the application year'); 
        } 
        if ( entity.apptype == 'NEW' ) { 
            if ( capture.type == 'current' ) {
                // do nothing 
            } else if ( entity.yearstarted != entity.activeyear ) { 
                throw new Exception('Year started must be equal to the application year'); 
            } 
        } 
        else if ( entity.apptype == 'RENEW' ) {
            if ( entity.yearstarted >= entity.activeyear ) 
                throw new Exception('Year started must be less than the application year'); 
        }     
    } 
    
    void afterEditName() {
        verifyTxnDates(); 
        verifyList.check(); 
    } 
    
    void doVerifyName() { 
        verifyTxnDates(); 
        verifyList.verify();         
    } 

    void openEntry() {
        capture.openEntry();
        lob.reset();
        lob.lobAssessmentType = entity.apptype;
        entity.txnmode = 'CAPTURE';
    }

    void initAddressType() {
        if( application.copyOwnerAddress ) {
            owner.reload();
            entity.business.address = entity.business.owner.address;
            address.addressType = entity.business.address.type;
        }
        else {
            address.addressType = application.addressType;
        }
    }

    void save() {
        lob.verify(); 

        boolean test = false;
        appinfo.handler = {
            test = true;
        }
        Modal.show(appinfo.update());
        if(!test) throw new BreakException();

        appinfo.verify();

        if( !MsgBox.confirm("You are about to save this record. Proceed?") ) {
            throw new BreakException();
        }

        //entity.payments = [];
        //entity.taxfees = [];
        application.save();
    }

    void addAnother() {
        entity = [:];
    }
}