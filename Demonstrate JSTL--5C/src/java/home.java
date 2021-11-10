

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/home"})
public class home extends HttpServlet {

 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        {
            List<Employee1>emplist=new ArrayList<Employee1>();
            
            Employee1 e1=new Employee1();
            e1.setId(1);e1.setName("Aman");e1.setRole("Devoloper");
            
             Employee1 e2=new Employee1();
            e2.setId(2);e2.setName("Arun");e2.setRole("Tester");
            
            emplist.add(e1);
            emplist.add(e2);
            
            
            request.setAttribute("emplist",emplist);
            request.setAttribute("Html Tag Data","<br/>Create new line");
            request.setAttribute("URl","www.abc.com");
            RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
            rd.forward(request,response);
            
            
        }
       
    }

    private void setId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

    
    


