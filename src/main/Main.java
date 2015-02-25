// @wolfram77
package main;

// required modules
import org.data.*;



public class Main {
    
    public static void main(String[] args) throws Exception {
        Xml data = new Xml("<data><user><id>wolfram77</id><pass>incorrect</pass></user></data>");
        Xml id = data.child().child();
        System.out.println(id);
        System.out.println(id.parent("user"));
        System.out.println(id.parent("abc"));
        System.out.println(id.parent());
        System.out.println(id.root());
    }
}
