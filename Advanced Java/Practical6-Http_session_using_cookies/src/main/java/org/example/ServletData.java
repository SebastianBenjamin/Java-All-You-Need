package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletdata")
public class ServletData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionData = session.getAttribute("password").toString();
        Cookie[] cookies = req.getCookies();
        String email = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("email".equals(cookie.getName())) {
                    email = cookie.getValue();
                    break;
                }
            }
        }
        String urldata = req.getParameter("count");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ServletData</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>ServletData</h1>");
        out.println("<p> Session data : " + sessionData + "</p>");
        out.println("<p> Cookie data : " + email + "</p>");
        out.println("<p> Url data : " + urldata + "</p>");
        out.println("</body>");
        out.println("</html>");

    }
}
