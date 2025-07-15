package org.example;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/genericservlet")
public class ServletGeneric extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Generic Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>This is a Generic Servet</h1>");
        out.println("Request prarameter value :"+req.getParameter("param").toString());
        out.println("<br><br>");
        out.println("<a href='httpservlet?param=100'>Go to Http servlet</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
