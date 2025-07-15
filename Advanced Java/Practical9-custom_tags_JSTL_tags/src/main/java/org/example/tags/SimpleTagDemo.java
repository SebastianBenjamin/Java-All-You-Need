package org.example.tags;

import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;
public class SimpleTagDemo extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SimpleTagDemo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>SimpleTagDemo</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}
