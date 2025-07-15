package org.example.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;

public class GreetingTag extends SimpleTagSupport {
    public String name;
    public String password;

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void doTag() throws JspException, IOException {

        getJspContext().getOut().println("<h1>Hello " + name + " password : "+password+" !</h1>");

    }
}
