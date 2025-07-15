package org.example.servlets;
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/StudentServlet")
public class Servlet extends HttpServlet {

    Connection con;
    Statement stmt;
    final String DB_NAME = "studentdatabase";

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection rootCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            Statement rootStmt = rootCon.createStatement();
            rootStmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            rootCon.close();

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, "root", "");
            stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS studentdetails ("
                    + "ID INT PRIMARY KEY AUTO_INCREMENT,"
                    + "Name VARCHAR(100),"
                    + "Email VARCHAR(100),"
                    + "City VARCHAR(100),"
                    + "Java INT,"
                    + "Python INT,"
                    + "Cprogram INT)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String action = req.getParameter("action");

        try {
            if (action.equals("insert")) {
                String name = req.getParameter("name");
                String email = req.getParameter("email");
                String city = req.getParameter("city");
                int java = Integer.parseInt(req.getParameter("java"));
                int python = Integer.parseInt(req.getParameter("python"));
                int c = Integer.parseInt(req.getParameter("c"));

                String q = "INSERT INTO studentdetails (Name, Email, City, Java, Python, Cprogram) "
                        + "VALUES ('" + name + "','" + email + "','" + city + "'," + java + "," + python + "," + c + ")";
                stmt.executeUpdate(q);
                out.println("<h3>✅ Student inserted!</h3>");

            } else if (action.equals("delete")) {
                int id = Integer.parseInt(req.getParameter("id"));
                int rows = stmt.executeUpdate("DELETE FROM studentdetails WHERE ID = " + id);
                out.println(rows > 0 ? "<h3>✅ Deleted!</h3>" : "<h3>❌ ID not found.</h3>");

            } else if (action.equals("update")) {
                int id = Integer.parseInt(req.getParameter("id"));
                String email = req.getParameter("email");
                String city = req.getParameter("city");
                int rows = stmt.executeUpdate("UPDATE studentdetails SET Email='" + email + "', City='" + city + "' WHERE ID=" + id);
                out.println(rows > 0 ? "<h3>✅ Updated!</h3>" : "<h3>❌ ID not found.</h3>");

            } else if (action.equals("show")) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM studentdetails");
                out.println("<h2>All Students:</h2><table border='1'><tr><th>ID</th><th>Name</th><th>Email</th><th>City</th><th>Java</th><th>Python</th><th>C</th></tr>");
                while (rs.next()) {
                    out.println("<tr><td>" + rs.getInt("ID") + "</td><td>" +
                            rs.getString("Name") + "</td><td>" +
                            rs.getString("Email") + "</td><td>" +
                            rs.getString("City") + "</td><td>" +
                            rs.getInt("Java") + "</td><td>" +
                            rs.getInt("Python") + "</td><td>" +
                            rs.getInt("Cprogram") + "</td></tr>");
                }
                out.println("</table>");
            } else {
                out.println("<h3>❌ Unknown action.</h3>");
            }

            out.println("<br><a href='index.html'>Back to Home</a>");

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }

    public void destroy() {
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
