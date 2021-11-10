
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
   
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
      
        try
        {
            String un=request.getParameter("un");
            String ps=request.getParameter("pass");

            if(ps.equals("servlet") )
            {
                RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
                rd.forward(request, response);
            }
            else
            {
            out.println("UserName:"+un+"PasswordInvalid");
             RequestDispatcher rd=request.getRequestDispatcher("/index.html");
             rd.include(request, response);
             
            }

        }
        catch(ServletException | IOException e)
        {
        out.println("Error is:"+e);
        
        }
    }
  
  }
