<%@ page import="java.util.Date" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <title>Page Directives Demo</title>
</head>
<body>
<h1>Page Directives </h1>
<p>Current Date and Time: <%= new Date() %> </p>
<%
int x=100/0;
%>
</body>
</html>