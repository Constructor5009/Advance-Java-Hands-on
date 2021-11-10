

import EJB.CurrencyBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/CurrencyServlet"})
public class CurrencyServlet extends HttpServlet {

   
 
    @EJB CurrencyBean cb;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       
       try
       {
           String amt=request.getParameter("t1");
           String fc=request.getParameter("from");
           String tc=request.getParameter("to");
           if(amt!=null&& amt.length()>0)
           {
               double d=Double.parseDouble(amt);
               double ca=cb.convert(fc, tc, d);
               out.println(amt+fc+"="+ca+" (CONVERTED AMT)");
               out.println("<a href=index.jsp>Back</a>");
           }
           
       }  
           catch(Exception e)
                   {
                   out.println(e.getMessage());
                   }
   
    }

   

}
