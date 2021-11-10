

import EJB.CountBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/ss"})
public class ss extends HttpServlet {
 @EJB
CountBean obj;
    

   
  

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("tex/html;charset=UTF-8");
            PrintWriter out =response.getWriter();
       
        try
        {
            
            out.println("No. of times page is accessed is"+obj.getCount() );
            
        }
    

catch(Exception e)
{
out.println(e);
}
}
}   


