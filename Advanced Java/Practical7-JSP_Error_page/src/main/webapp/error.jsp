<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h2>Error Occurred!</h2>
<p>Exception: <%= exception.getClass().getName() %></p>
<p>Message: <%= exception.getMessage() %></p>
</body>
</html>