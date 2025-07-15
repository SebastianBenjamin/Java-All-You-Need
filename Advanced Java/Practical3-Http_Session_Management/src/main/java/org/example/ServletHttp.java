package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index.html")
public class ServletHttp extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie=new Cookie("username","Benjamin");
        response.addCookie(cookie);
        cookie.setMaxAge(3600);

        HttpSession session=request.getSession();
        session.setAttribute("age",21);
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Http Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Http Servlet - Session Management</h1>");
        out.println("<form action='servletData' method='GET'>");
        out.println("<input type='hidden' value='KJSIM' name='college'>");
        out.println("<input type='submit' value='See Data'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
