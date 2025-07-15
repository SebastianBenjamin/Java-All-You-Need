<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Page</title>
    <!-- Bootstrap CSS for responsiveness and styling -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            padding: 50px;
        }

        .error-container {
            max-width: 600px;
            margin: 0 auto;
            text-align: center;
        }

        .error-code {
            font-size: 120px;
            font-weight: bold;
            color: #dc3545;
        }

        .error-message {
            font-size: 24px;
            color: #343a40;
        }

        .error-details {
            font-size: 16px;
            color: #6c757d;
        }

        .btn-primary {
            margin-top: 20px;
        }
    </style>
</head>

<body>
<div class="error-container">
    <div class="error-code">
        <%-- Dynamically show the error code, e.g., 404, 500, etc. --%>
        <%= request.getAttribute("javax.servlet.error.status_code") != null ?
                request.getAttribute("javax.servlet.error.status_code") : "Error" %>
    </div>
    <div class="error-message">
        <%-- Display a generic error message or specific one based on the error code --%>
        <% String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
            if (errorMessage == null) {
                errorMessage = "An unexpected error occurred.";
            }
        %>
        <%= errorMessage %>
    </div>
    <div class="error-details">
        <%-- Optionally, show the exception details if available (useful for debugging) --%>
        <%
            Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
            if (exception != null) {
        %>
        <p><strong>Details:</strong> <%= exception.getMessage() %></p>
        <% } %>
        <p>We apologize for the inconvenience. Please try again later.</p>
    </div>
    <a href="/" class="btn btn-primary">Go to Home</a>
</div>

<!-- Bootstrap JS and Popper.js (needed for Bootstrap's interactive components) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
