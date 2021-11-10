

import EJB.CartBean;
import EJB.CartBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/ss"})
public class ss extends HttpServlet {
    @EJB
    CartBeanLocal obj;
    
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        try
        {
        obj.intialize("ABC","101" );
        obj.addbook("Web");
        obj.addbook("Java");
        obj.addbook("DBMS");
        obj.addbook("SPM");
        List<String> books=obj.getContent();
        for(String s:books)
        {
            out.println(s+"<br>");
        }
        out.println("<br>");
        obj.removeBook("Java");
        obj.removeBook("DBMS");
        for(String s:books)
        {
            out.println(s+"<br>");
        }
        
        }
        catch(Exception e)
        {
            out.print(e);
        }
       
        
    }
}
