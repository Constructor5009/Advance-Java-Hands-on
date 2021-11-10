
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.beans.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
      <%
        String eno= request.getParameter("t1");
String name=request.getParameter("t2");
String age=request.getParameter("t3");
String designation=request.getParameter("t4");
String salary=request.getParameter("t5");
if(eno!= null)
{
Class.forName("org.apache.derby.jdbc.ClientDriver");
Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbname","root","root");
PreparedStatement ps = null;
try
{

String sql="update tablename set empname=?,age=?,designation=?,salary=? where empno=?";
ps = con.prepareStatement(sql);


ps.setString(1, name);
ps.setString(2, age);
ps.setString(3, designation);
ps.setString(4, salary);
ps.setString(5, eno);
int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
} 
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>
           
           

       
    </body>
</html>
