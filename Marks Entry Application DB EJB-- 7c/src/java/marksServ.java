

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/marksServ"})
public class marksServ extends HttpServlet {

@EJB ejb.marks m;   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       try
       {
       String name=request.getParameter("t1");
       String sub1=request.getParameter("t2");
       String sub2=request.getParameter("t3");
       String sub3=request.getParameter("t4");
       m.SubjectMarks(name,sub1, sub2, sub3);
       out.println("Record Inserted Successfull");
       }
       catch(Exception e)
       {
           out.println(e.getMessage());
       }
    }

    

}
