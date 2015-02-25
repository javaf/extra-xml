// @wolfram77
package main;

// required modules
import org.data.*;



public class Main {
    
    public static void main(String[] args) throws Exception {
        Xml data = new Xml("<data><user><id>wolfram77</id><pass>incorrect</pass></user></data>");
        Xml user = data.child();
        for(Xml child : user.children("id"))
            System.out.println(child.name());
    }
}
