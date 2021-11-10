
package ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.ejb.Stateless;


@Stateless
public class VisitorStat {

    Connection con;

    public void addVisitor(String host) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbname", "root", "root");
            PreparedStatement ps = con.prepareStatement("insert into USERSTATE  values(?,?,?)");
            ps.setString(1, new Date().toString());
            ps.setString(2, host);
            ps.setInt(3, 1);
            ps.executeUpdate();
        } catch (Exception e) {
            try {
                PreparedStatement ps;
                String sql = "update USERSTATE set visits=visits+1 where host_name=?";
                ps = con.prepareStatement(sql);

                ps.setString(1, host);
                
                ps.executeUpdate();
                
            } catch (Exception c) {
                System.out.println(c.getMessage());
            }
            System.out.println(e.getMessage());
        }
    }

}
