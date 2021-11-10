

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
             String n=request.getParameter("t1");
             String a=(request.getParameter("t2"));
             String chk[]=request.getParameterValues("c1");
             String r=request.getParameter("r1");
             String e=request.getParameter("t3");
             int age=Integer.parseInt(a);
         if(n.equals("")||chk==null||a==null||e.equals("")||r==null)
         {   
          out.println("Enter the values");      
         }
             
             else if(age<0&&age<100)
             {
                out.println("enter the valid age"); 
             }
             else if(!e.contains("@")||!e.contains(".com"))
                     {
                      out.println("enter the valid email");   
                     }
             else if(chk==null)
             {
                 out.println("select the hobby");
             }
             
           
             else
             { 
                 out.println("name is:"+n);
                 out.println("age is:"+a);
                 out.println("hobby is:");
             for(int i=0;i<chk.length;i++)
             {
                 out.println(chk[i]);
             }
             
             out.println("Gender is:"+r);
             out.println("Email is:"+e);
             }
         }
         catch(Exception e)
                 {
                     out.println("error"+e.getMessage());
                 }
         %>
        
    </body>
</html>
