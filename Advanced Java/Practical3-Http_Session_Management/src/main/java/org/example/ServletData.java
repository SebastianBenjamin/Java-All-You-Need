package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/servletData")
public class ServletData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String course=req.getParameter("course")!=null ? req.getParameter("course"):"<a href=\"servletData?course=MCA&college=KJSIM\">Click here to load course</a>";

        Cookie[] cookies = req.getCookies();
        Cookie cookie = (cookies != null && cookies.length > 0) ? cookies[0] : null;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ServletData</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Data - Session Management</h1>");
        out.println("<fieldset><legend>Cookies</legend>");
        out.println("<h3>Username : "+cookie.getValue()+"</h3>");
        out.println("</fieldset>");
        out.println("<fieldset><legend>Session</legend>");
        out.println("<h3>Age : "+req.getSession().getAttribute("age")+"</h3>");
        out.println("</fieldset>");
        out.println("<fieldset><legend>Url Re-writing</legend>");
        out.println("<h3>Course : "+course+"</h3>");
        out.println("</fieldset>");
        out.println("<fieldset><legend>Hidden Form</legend>");
        out.println("<h3>College : "+req.getParameter("college")+"</h3>");
        out.println("</fieldset>");
        out.println("</body>");
    }
}
