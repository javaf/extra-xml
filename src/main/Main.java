// @wolfram77
package main;

// required modules
import org.data.*;



public class Main {
    
    public static void main(String[] args) throws Exception {
        Xml data = new Xml("<data><user><id>wolfram77</id><pass>incorrect</pass></user></data>");
        Xml user = data.child();
        user.child("id").name("ids").val("oye");
        for(Xml child : user.children())
            System.out.println(child.name()+" : "+child.val());
    }
}
