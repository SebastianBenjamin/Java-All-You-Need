<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="org.example.Student" %>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
<jsp:useBean id="student1" class="org.example.Student" scope="request" />
<jsp:setProperty name="student1" property="*" />

<h2>Student Information</h2>
Name: <jsp:getProperty name="student1" property="name" /><br>
Email: <jsp:getProperty name="student1" property="email" /><br>
</body>
</html>
