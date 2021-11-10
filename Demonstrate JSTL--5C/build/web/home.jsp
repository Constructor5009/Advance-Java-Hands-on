<%-- 
    Document   : home
    Created on : Aug 23, 2018, 8:34:12 AM
    Author     : anil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
    </head>
    <body>
        <table border="2">
            <tr><th>ID</th><th>Name</th><th>Role</th></tr>
            <c:forEach items="${requestScope.emplist}" var="emp">
                <tr>
                    <td><c:out value="${emp.id}"/></td>
                    <td><c:out value="${emp.name}"/></td>
                    <td><c:out value="${emp.role}"/></td>
                </tr>
                </c:forEach>
        </table>
        <c:set var="id" value="5" scope="request"/>
        <c:out value="${request.id}"/><br>
        <c:catch var="exception">
            <%int x=5/0;%>
        </c:catch>
        
        <c:if test="id${excpetion ne null}">
            <p>Exception is:${exception}
                <br>
                Exception message:
                ${exception.message}</p>
        </c:if>
        <br>
        <br>
        <a href="<c:url value="${requestScope.url}"/>
           Click me</a>
            
    </body>
</html>
