// @wolfram77
package main;

// required modules
import org.data.*;



public class Main {
    
    public static void main(String[] args) throws Exception {
        Xml data = new Xml("<data><user><id>wolfram77</id><pass>incorrect</pass></user></data>");
        Xml user = data.child();
        Xml user2 = user.copy();
        System.out.println(user.equals(user2));
        System.out.println(user.same(user2));
    }
}
