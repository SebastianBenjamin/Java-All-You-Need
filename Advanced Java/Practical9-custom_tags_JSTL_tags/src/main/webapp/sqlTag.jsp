
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Sql Tags</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
<sql:setDataSource
        var="dataSource"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/fruitstore"
        user="root"
        password=""
/>
<sql:query dataSource="${dataSource}" var="result">
    SELECT * from fruits;
</sql:query>

<!-- Table to display the query results -->
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Color</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.name}"/></td>
            <td><c:out value="${row.color}"/></td>
            <td><c:out value="${row.price}"/></td>
            <td><c:out value="${row.quantity}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
