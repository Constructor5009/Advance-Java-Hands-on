<%-- 
    Document   : index
    Created on : Oct 4, 2018, 7:23:43 AM
    Author     : anil
--%>
<%@page import="javax.naming.InitialContext,ejb.VisitorStat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
private static VisitorStat visits;
public void jspInit()
{
    try
    {
        InitialContext ic=new InitialContext();
        visits=(VisitorStat)ic.lookup("java:global/7b_messageDriven/VisitorStat");
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
}
%>
<%
    visits.addVisitor(request.getRemoteAddr());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Welcome To Home Page</h1>
    </body>
</html>
