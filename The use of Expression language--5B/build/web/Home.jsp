x<%-- 
    Document   : home
    Created on : 16 Aug, 2018, 9:24:14 AM
    Author     : Synthrax
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <% List<String> names = new ArrayList<String>(); 
            names.add("SUKRITI");
            names.add("ANIL");
            pageContext.setAttribute("names",names);
        %>
        <b> ELeg with scope</b>
        ${requestScope.person}<br>
        <b>ELeg without scope</b>
        ${person}
        <b>Simple[] Example </b>
        ${names[1]}
        <b>Simple[] Example</b>
        ${applicationScope["User.Cookie"]}
        <b>Multiples EL Example </b>
        ${sessionScope.employee.address.address}
        <b>HeaderInfo </b>
        ${header["Accept-Encoding"]}
        <b> Cookie Eg </b>
        ${cookie["cname"].value}
        <b>PageContext Eg </b>
        ${pageContext.request.method}  
    </body>
</html>
