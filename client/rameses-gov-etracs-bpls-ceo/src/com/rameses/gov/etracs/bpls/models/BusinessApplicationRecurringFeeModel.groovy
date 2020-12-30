package com.rameses.gov.etracs.bpls.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import java.rmi.server.*;

class BusinessApplicationRecurringFeeModel  {

    @Service("PersistenceService")
    def service;

    @Service("QueryService")
    def queryService;

    boolean app;
    def entity;
    def list;
    def businessid;
    def selectedItem;
    def task;

    String title = "Recurring Fees";

    void initApp() {
        businessid = entity.business.objid;
        app = true;
    }

    void initBusiness() {
        businessid = entity.objid;
        app = false;
    }

    def listModel = [
        fetchList: { o->
            def m = [_schemaname:'business_recurringfee'];
            m.findBy = [businessid: businessid]
            return queryService.getList( m ); 
        },
        onOpenItem: { o, col->
            return updateFee();
        }
    ] as BasicListModel;

    def updateFee() {
        if(!selectedItem) return 

        def mm = [_schemaname:'business_recurringfee'];
        mm.objid = selectedItem.objid;
        def m = service.read( mm );
        def h = { x->
            x._schemaname= 'business_recurringfee';
            service.update( x );
            listModel.reload();
        }
        def opener = InvokerUtil.lookupOpener("bpls_recurringfee_entry:open", [ entity: m, handler:h ]);
        opener.target = "popup";
        return opener;
    }

    def addFee() {
        def h = { o->
            o._schemaname = 'business_recurringfee';
            o.state = 'ACTIVE';
            o.businessid = businessid;            
            service.create( o );
            listModel.reload();
        }
        return Inv.lookupOpener("bpls_recurringfee_entry:create", [handler:h]); 
    }

    def removeFee() {
        if(!selectedItem) return;
        if( MsgBox.confirm("You are about to remove this item. Proceed?")) {
            def r = [_schemaname:'business_recurringfee'];
            r.objid = selectedItem.objid;
            service.removeEntity( r );
            listModel.reload();
        }
    }
}        
