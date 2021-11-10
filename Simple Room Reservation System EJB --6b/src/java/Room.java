

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Room"})
public class Room extends HttpServlet {


    @EJB ejb1.RoomBean rb;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       try
       {
         String rt=request.getParameter("t1");
         String cn=request.getParameter("t2");
         String cm=request.getParameter("t3");
         String msg=rb.bookRoom(rt,cn,cm);
         out.println(msg);
        }
        catch(Exception e)
        {
            out.println(e.getMessage());
        }
    }
       
}

  


