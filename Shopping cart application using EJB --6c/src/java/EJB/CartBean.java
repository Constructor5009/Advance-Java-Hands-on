
package EJB;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;


@Stateful
public class CartBean implements CartBeanLocal {

    String cn, cid;
    List<String> cont;
    @Override
    public void intialize(String person, String id) throws Exception {
        if (person == null) {
            throw new Exception("Null person not allowed");
        } else {
            cn = person;
        }
        if (person.equals("ABC")&&id.equals("101")) {
            cid = id;
        } else {
            throw new Exception("Invalid Id" + id);
        }
        cont=new ArrayList<String> ();
    }

    @Override
    public void addbook(String title) {
    
            cont.add(title);
}

    @Override
    public void remove() {
        cont = null;
    }
    @Override
    public void removeBook(String title) throws Exception {
        boolean r = cont.remove(title);
        if (r == false) {
            throw new Exception(title +"not in cart");
        }
    }

    @Override
    public List<String> getContent() {
                return cont;

    }

}
