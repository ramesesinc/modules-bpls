package bpls.facts;

public class LOBAttribute {
    
    LOB lob;
    String name;
    String objid;

    public String toString() {
        return lob.name + " " + name;
    }

}
