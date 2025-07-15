<%@ page import="java.util.*, controllers.classfiles.Quiz, controllers.classfiles.Question" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Available Quizzes</title>
    <link href="https://img.icons8.com/cute-clipart/64/ask-question.png" rel="icon">

    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center p-6">

<div class="bg-white p-10 rounded-2xl shadow-2xl w-full max-w-5xl">
    <h1 class="text-3xl font-bold text-center text-gray-800 mb-8">Available Quizzes</h1>

    <!-- Quiz Cards -->
    <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
        <%
            List<Quiz> quizes = (List<Quiz>) request.getAttribute("quiz");
            if (quizes != null && !quizes.isEmpty()) {
                for (Quiz quiz : quizes) {
        %>
        <form action="quizresult" method="post" class="bg-blue-50 p-6 rounded-xl shadow flex flex-col">
            <span class="text-xl font-semibold text-gray-800 mb-2"><%= quiz.getTitle() %> Quiz</span>
            <span class="text-sm text-gray-600 mb-4">Questions: <%= quiz.getQuestions().size() %></span>

            <!-- Send quiz title as hidden -->
            <input type="hidden" name="quizTitle" value="<%= quiz.getTitle() %>">
            <input type="hidden" name="quiz" value="<%= quiz %>">

            <div class="space-y-4">
                <%
                    int questionCounter = 0;
                    for (Question q : quiz.getQuestions()) {
                %>

                <div class="bg-white p-4 rounded-lg border border-gray-200">
                    <p class="text-md font-medium text-gray-700 mb-2">
                        <%= ++questionCounter %>. <%= q.getQuestion() %>
                        <input name="answer<%=q.getId()%>" value="<%=q.getAnswer()%>" hidden="hidden">

                    </p>

                    <div class="space-y-1 ml-4">
                        <%

                            String[] options = q.getOptions();
                            for (int i = 0; i < options.length; i++) {
                        %>

                        <label class="flex items-center text-sm text-gray-600">
                            <input type="radio" name="q<%=q.getId() %>" value="<%= i %>" class="mr-2" required>

                            <%= options[i] %>
                        </label>
                        <% } %>
                    </div>
                </div>
                <% } %>
            </div>

            <button type="submit" class="mt-6 bg-green-600 text-white px-4 py-2 rounded-xl hover:bg-green-700 transition">
                Submit Quiz
            </button>
        </form>
        <%
            }
        } else {
        %>
        <p class="text-red-500 font-semibold">No quizzes available.</p>
        <%
            }
        %>
    </div>
</div>

</body>
</html>
