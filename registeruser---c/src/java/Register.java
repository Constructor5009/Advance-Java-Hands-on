import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Register extends HttpServlet {
   
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
                
                 
		String n=request.getParameter("userName");
		String p=request.getParameter("userPass");
		String e=request.getParameter("userEmail");
		String c=request.getParameter("userCountry");
		
		try{
	            Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/dbname","root","root");
	            PreparedStatement ps=con.prepareStatement("insert into TEST values(?,?,?,?)");
		
                ps.setString(1,n);
		ps.setString(2,p);
		ps.setString(3,e);
		ps.setString(4,c);
		
		int i=ps.executeUpdate();
              
		if(i>0)
		out.print("You are successfully registered...");
		else
                    out.println("Problem in registration");
			
		}
                catch (Exception e2)
                {out.println(e2);}
		
		out.close();
	}

}
