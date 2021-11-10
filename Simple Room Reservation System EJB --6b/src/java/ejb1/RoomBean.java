
package ejb1;


import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.Stateless;


@Stateless
public class RoomBean {


   public String bookRoom(String rt,String cn,String cm)
    {
        String msg="";
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/dbname","root","root");
            PreparedStatement ps=con.prepareStatement("select * from room where roomtype=? and status='Not Booked'");
            ps.setString(1,rt);
            ResultSet rs=ps.executeQuery();
            String rno;
            if(rs.next())
            {
                rno=rs.getString(1);
                PreparedStatement ps1=con.prepareStatement("update room set customername=?,mobile=?,status=? where roomid=?");
                ps1.setString(1,cn);
                ps1.setString(2,cm);
                ps1.setString(3,"Booked");
                ps1.setString(4,rno);
                ps1.executeUpdate();
                msg="Room "+rno+" booked. Charges =Rs."+rs.getString(3);
                return msg;
            }
            else
            {
                msg="Room "+rt+" not available";
                return msg;
            }
            
        }
        
       catch(Exception e)
        {
            msg=e.getMessage();
            return msg;
        } 
    
    
    }

}

