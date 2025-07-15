
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%
List<String> Fruits =new ArrayList<>();
Fruits.add("Apple");
Fruits.add("Orange");
Fruits.add("Mango");
Fruits.add("Lychee");
Fruits.add("Chikku");
request.setAttribute("Fruits", Fruits);
%>

<html>
<head>
    <title>CoreTags
    </title>
</head>
<body>
<c:forEach var="Fruit" items="${Fruits}">
    <h1>${Fruit}</h1>
</c:forEach>
</body>
</html>
