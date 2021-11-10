

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Person p=new Employee();
        p.setName("Aman");
        request.setAttribute("person",p);
        Employee emp=new Employee();
        Address add=new Address();
        add.setAddress("India");
        emp.setAddress(add);
        emp.setID(1);
        emp.setName("Shyam");
        HttpSession s= request.getSession();
        s.setAttribute("employee",emp);
        response.addCookie(new Cookie("cname","GlassFishuser"));
        getServletContext().setAttribute("User.Cookie","GlassFishuser");
        
        RequestDispatcher rd=getServletContext(). getRequestDispatcher("/Home.jsp");
        rd.forward(request,response);   
    }

}