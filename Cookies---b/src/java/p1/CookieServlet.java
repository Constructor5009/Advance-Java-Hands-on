
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebServlet(name = "CookieServlet", urlPatterns = {"/CookieServlet"})
public class CookieServlet extends HttpServlet {

   static int i=1;

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

         Cookie ck[]=request.getCookies();
         
        if(ck==null)
        {
        out.println("Welcome");
        }
        else
        {
        int v=Integer.parseInt(ck[0].getValue());
          out.println("Hello you visited:"+v+" times");
        }
        i++;
        Cookie c=new Cookie("Visitno",String.valueOf(i));
        response.addCookie(c);
        
        
        
    }

    

}
