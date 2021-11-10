<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
             try
             {
              String regno=request.getParameter("t1");
              String un=request.getParameter("t2");
              String pwd=request.getParameter("p1");
             
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/user19","root","root");
	 PreparedStatement ps=con.prepareStatement("insert into ANIL19 values(?,?,?)");
        ps.setString(1,regno);
        ps.setString(2,un);
        ps.setString(3,pwd);
        ps.executeUpdate();
             }
             catch(Exception e)
             {
                 
             }
                %>
      Registration successfully!
      kindly login here:
      <form method="post" action="welcome.jsp">
          <br><br> Username:<input type="text" name="t2">
            <br><br> Password<input type="password" name="p1">
            <br><br><input type="submit" value="login">
            </form>
    </body>
</html>
