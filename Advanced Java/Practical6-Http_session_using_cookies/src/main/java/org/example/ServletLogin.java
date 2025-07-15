package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index.html")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ServletLogin</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Login</h1>");

        if (req.getParameter("email") == null||req.getParameter("password") == null) {
        out.println("<form action=\"index.html\" method=\"post\">");
            out.println("<input type=\"email\" name=\"email\" required><br><br>");
            out.println("<input type=\"password\" name=\"password\" required><br><br>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        }
        out.println("</body>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("email").equals("ben@google.com")&&req.getParameter("password").equals("12345")) {
            Cookie cookie = new Cookie("email", req.getParameter("email"));
            cookie.setMaxAge(3600);
            resp.addCookie(cookie);
            HttpSession session = req.getSession();
            session.setAttribute("password", req.getParameter("password"));

            String url=resp.encodeURL("servletdata?count=100");
            resp.sendRedirect(url);


        }else{
            PrintWriter out = resp.getWriter();
            out.println("<h2>Invalid email or password</h2>");
        }
    }
}
