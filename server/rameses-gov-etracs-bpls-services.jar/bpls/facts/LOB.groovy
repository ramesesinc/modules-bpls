package bpls.facts;

public class LOB {
    
    BPApplication application;
    String objid; 
    String lobid;			
    String name;
    String classification;
    String attributes;
    String assessmenttype;
    
    /** Creates a new instance of LOB */
    public LOB() {
    }

    public void printInfo() {
        /*print lob*/
        println "Lob Fact"
        println "objid " + this.objid;
        println "assessment type " + this.assessmenttype;  
    }

    public int hashCode() {
        return objid.hashCode();
    }

    public String toString() {
        return "Lob Fact:"+ this.objid + ";assessmenttype:"+this.assessmenttype+"attrs:"+attributes+";class:"+this.classification;
    }

    public def toMap() {
        def m = [:];
        m.objid = objid;
        m.name = name;
        m.classification = classification;
        m.assessmenttype = assessmenttype;
        return m;
    }

}
