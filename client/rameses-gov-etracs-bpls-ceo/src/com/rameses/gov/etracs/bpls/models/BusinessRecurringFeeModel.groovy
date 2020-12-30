package com.rameses.gov.etracs.bpls.models;

import com.rameses.rcp.common.*;
import com.rameses.rcp.annotations.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;

class BusinessRecurringFeeModel {
    
    def entity;
    def handler
    def mode;

    @PropertyChangeListener
    def listener = [
        "entity.txntype" : { o->
            entity.account = o.account;
            entity.txntypeid = o.objid;
        }
    ];

    void create() {
        entity = [:];
        mode = 'create'
    }

    void open() {
        mode = 'edit'
    }

    def doOk() {
        if( handler) handler(entity);
        return "_close";
    }

    def doCancel() {
        return "_close";
    }

}
        