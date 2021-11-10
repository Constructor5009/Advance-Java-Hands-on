
package ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.ejb.Stateless;


@Stateless
public class marks {
    public void SubjectMarks(String name,String sub1,String sub2,String sub3)
    {
    try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbname", "root", "root");
            PreparedStatement ps = con.prepareStatement("insert into MARKS  values(?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,sub1);
            ps.setString(3,sub2);
            ps.setString(4,sub3);
            ps.executeUpdate();
            
        }
    catch(Exception e)
      {
        System.out.println(e.getMessage());
      }
    }
}   
