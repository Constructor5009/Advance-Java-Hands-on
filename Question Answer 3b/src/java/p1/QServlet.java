package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns = {"/QServlet"})
public class QServlet extends HttpServlet {

    
   
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       try
       {
           out.println("<html><body><br>");
           out.println("<form method=post action=RServlet>");
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/dbname","root","root");
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery("select *from QNA");
           if(!(rs.isBeforeFirst()))
           {
               out.println("No records are present");
           }
           else
           {
               int i=0;
               out.println("<center><h3><u>Online Exam</u></h3></center>");
               while(rs.next())
               {
                   i++;
                   out.println("<br><br>"+i);
                   out.println(rs.getString(2));
                   out.println("<br><input type=radio name="+i+" value=1>"+rs.getString(3));
                   out.println("<br><input type=radio name="+i+" value=2>"+rs.getString(4));
                   out.println("<br><input type=radio name="+i+" value=3>"+rs.getString(5));
                   out.println("<br><input type=radio name="+i+" value=4>"+rs.getString(6));
                   String ans=i+"ans";
                   out.println("<br><input type=hidden name="+ans+" value="+rs.getString(7)+" >");
               }
                  out.println("<input type=hidden name=total value="+i+" >"); 
                  out.println("<input type=submit value=submit>");
                  out.println("</form> </body> </html>");
                   
               }
           }
       
       catch(Exception e)
       {
           out.println("Error "+e.getMessage());
       }
    }
}

   

