
package EJB;

import java.util.List;
import javax.ejb.Local;


@Local
public interface CartBeanLocal {
      public void intialize(String person, String id)throws Exception;
   public void addbook(String title);
   public void removeBook(String title) throws Exception;
   public List<String> getContent();
   public void remove();
    
}
