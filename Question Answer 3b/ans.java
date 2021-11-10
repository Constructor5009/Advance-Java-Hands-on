
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/ans"})
public class ans extends HttpServlet {

   
    protected void Service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html");
          PrintWriter out=response.getWriter();
          try
          {
             out.print("<html><body>");
             int total=Integer.parseInt(request.getParameter("total"));
             int marks=0;
             for(int i=1;i<=total;i++)
             {
                 String sel=request.getParameter(Integer.toString(i));
                 String ans=request.getParameter(i+"ans");
                 if(sel.equals(ans))
                 {
                     marks++;
                 }
                 out.println("Total marks= "+marks);
                 out.println("</body></html>");
             }
          }
          catch(Exception e)
          {
              out.println("Error "+e.getMessage());
          }
       
       
    }

}
