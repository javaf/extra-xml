// @wolfram77
package main;

// required modules
import org.data.*;



public class Main {
    
    public static void main(String[] args) throws Exception {
        Xml data = new Xml("<data><user><id>wolfram77</id><pass>incorrect</pass></user></data>");
        Xml user = data.child();
        Xml id = user.child("id");
        Xml pass = user.child("pass");
        System.out.println(id);
        System.out.println(pass);
        System.out.println(pass.prev());
        System.out.println(id.next());
        System.out.println(user.prev());
        System.out.println(user.next());
    }
}
