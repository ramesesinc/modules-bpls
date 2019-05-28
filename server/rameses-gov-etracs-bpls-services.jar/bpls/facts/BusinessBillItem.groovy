package bpls.facts;

import treasury.facts.*;

public class BusinessBillItem extends BillItem {
    
    BPApplication application;
    LOB	lob;
    String assessmenttype;
    String taxfeetype;

    public def toMap() {
        def m = super.toMap();
        if( lob ) {
            m.lob = lob.toMap();
        }
        m.assessmenttype = assessmenttype;
        m.taxfeetype = taxfeetype;
        return m;
    }    

    public int hashCode() {
        def sb = new StringBuilder();
        if( lob ) {
            sb.append(lob.objid+"-");
        }
        if( account?.objid ) {
            sb.append( account.objid );
        }
        else if(txntype) {
            sb.append( txntype );
        }
        return sb.toString().hashCode();
    }

}