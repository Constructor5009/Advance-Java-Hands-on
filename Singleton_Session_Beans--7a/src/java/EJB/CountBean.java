
package EJB;

import javax.ejb.Singleton;


@Singleton
public class CountBean {

   private int  count;
   public synchronized int getCount()
   {
       return count++;
   }
           
           
      
}
