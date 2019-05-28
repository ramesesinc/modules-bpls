package bpls.facts;

import  enterprise.facts.*;

public class BusinessInfo extends VariableInfo {
    
    BPApplication application;
    LOB	lob;
    int year;   //this is for late renewal support
    int qtr;    //this is for qtr support for LGUs who report qtr gross for new business.
    def handler; //this is just dummy so it will not produce an error
    def value;

    public int hashCode() {
        def buff = new StringBuilder();
        if( lob?.objid !=null ) {
            buff.append( lob.objid + "-" );
        }
        buff.append( name );
        return buff.toString().hashCode();
    }
    
    public def toMap() {
        def m = super.toMap();
        if( lob ) {
            m.lob = lob.toMap();
            //this is for the info below
            m.category = lob.name;
            m.sortorder = 1000 + m.sortorder;
        }
        return m;
    }    

    public void setValue( def d ) {
        if(datatype==null) throw new Exception("datatype must not be null");
        this.value = d;
        if(datatype == "decimal") {
            decimalvalue = d;
        }   
        else if(datatype=="integer") {
            intvalue = d;
        }   
        else if(datatype=="boolean") {
            booleanvalue = d;
        }   
        else if(datatype == "date" ) {
            datevalue = d;
        }   
        else {
            stringvalue = d;
        }   
    }

}
