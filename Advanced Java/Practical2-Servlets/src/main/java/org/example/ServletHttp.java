package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/httpservlet")
public class ServletHttp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Http Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>This is a Http Servet</h1>");
        out.println("Request prarameter value :"+req.getParameter("param").toString());
        out.println("<br><br>");
        out.println("<a href='genericservlet?param=200'>Go to Generic servlet</a>");
        out.println("</body>");
        out.println("</html>");


    }
}
