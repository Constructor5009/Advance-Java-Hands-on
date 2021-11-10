<%-- 
    Document   : index
    Created on : Sep 6, 2018, 7:29:10 AM
    Author     : anil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <form method="post" action="CurrencyServlet">
        <h2 align="center">Currency Converter</h2><br><br>
        <h4>Enter The Amount To Convert:</h4>
        <input type="text" name="t1"/><br><br>
        <h4>From This currency:</h4>
        <select name="from">
            <option value="USD">USD</option>
            <option value="INR">INR</option>
        </select><br><br>
        <h4>To This Currency</h4>
        <select name="to">
            <option value="USD">USD</option>
            <option value="INR">INR</option>
        </select><br><br>
        <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
