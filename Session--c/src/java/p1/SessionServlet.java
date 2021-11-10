
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet {

  
  

  
int cnt=0;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        HttpSession s=request.getSession();
        
        if(s.isNew())
        {
        out.println("This is the 1st time you are visiting this page");
        }
        else
        {
        out.println("Welcome back to this page");
        }
        
        synchronized(this)
        {
            
            out.println("You have visited this page"+(++cnt));
            
            if(cnt==5)
            {
            s.invalidate();
            }
        }
        
      
    }

  
    
}
