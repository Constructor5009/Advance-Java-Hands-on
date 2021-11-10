
package login_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

   
   

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        response.setContentType("text");
            PrintWriter out=response.getWriter();
            try
            {
            String us=request.getParameter("user");
            String ps=request.getParameter("pass");
            String msg="";
            
            String op=request.getParameter("btn");
            
            if(us.equals("Admin") && ps.equals("123"))
            { msg="Hello"+us;
            }
            
           else 
            {
                msg="Login Failed!!";
            }
            
             out.println("<html><body>");
            out.println(msg);
            out.println("</html></body>");
          }
       catch(Exception e)
       {
       out.println(e.getMessage());
            
       }
        
    }

   

}
