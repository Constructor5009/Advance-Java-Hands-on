/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thakur imp for mapping with servlet
 */
@WebServlet(name = "CalcServlet", urlPatterns = {"/CalcServlet"})
public class CalcServlet extends HttpServlet {

    
 
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
            response.setContentType("text");
            PrintWriter out=response.getWriter();
            try
            {
            int a=Integer.parseInt(request.getParameter("t1"));
            int b=Integer.parseInt(request.getParameter("t2"));
            int c=0;
            String op=request.getParameter("btn");
            if(op.equals("+"))
            { c=a+b;
            }
            
            if(op.equals("-"))
            { c=a-b;
            }
            
            if(op.equals("*"))
            { c=a*b;
            }
            
            if(op.equals("/"))
            { c=a/b;
            }
            
            if(op.equals("%"))
            { c=a%b;
            }
            
            out.println("<html><body>");
            out.println("Result="+c);
            out.println("</html></body>");
            
            }
       catch(Exception e)
       {
       out.println(e.getMessage());
            
       }
        
    }

 

}
