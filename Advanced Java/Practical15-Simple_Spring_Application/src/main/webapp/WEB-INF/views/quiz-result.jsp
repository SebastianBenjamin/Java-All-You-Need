<%@ page import="java.util.*, controllers.classfiles.Question" %>
<%@ page import="controllers.classfiles.Quiz" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
    <link href="https://img.icons8.com/cute-clipart/64/ask-question.png" rel="icon">

    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen p-6">
<div class="bg-white p-8 rounded-xl max-w-4xl mx-auto shadow-2xl">
    <h1 class="text-2xl font-bold text-center mb-6">Quiz Results</h1>

    <%
        List<Integer> gotAnswers = (List<Integer>) request.getAttribute("answers");
        List<Integer> crtAnswers = (List<Integer>) request.getAttribute("correctAnswers");
        List<Quiz> quizzes = (List<Quiz>) request.getAttribute("quiz");

        int correct = 0;
        for (int i = 0; i < crtAnswers.size(); i++) {
            if (gotAnswers.get(i).equals(crtAnswers.get(i))) {
                correct++;
            }
        }
        int percentage = (correct * 100) / crtAnswers.size();
    %>

    <p class="text-lg text-center text-green-700 mb-2">Score: <%= percentage %> %</p>
    <p class="text-center text-gray-700">Total Questions: <%= crtAnswers.size() %></p>
    <p class="text-center text-blue-700 mb-6">Correct: <%= correct %></p>

    <%
        int qIndex = 0;
        for (Quiz quiz : quizzes) {
            for (Question q : quiz.getQuestions()) {
                String[] options = q.getOptions();
                int correctIndex = q.getAnswer();
                int userIndex = gotAnswers.get(qIndex);
    %>
    <div class="mb-4 p-4 border border-gray-300 rounded-lg bg-white shadow-sm">
        <p class="font-semibold mb-2 text-gray-800">
            Q<%= (qIndex + 1) %>: <%= q.getQuestion() %>
        </p>
        <ul class="ml-4 space-y-1">
            <%
                for (int i = 0; i < options.length; i++) {
                    boolean isCorrect = (i == correctIndex);
                    boolean isUser = (i == userIndex);
                    String colorClass = isCorrect ? "text-green-600 font-bold" :
                            isUser ? "text-red-600 font-semibold" : "text-gray-700";
            %>
            <li class="<%= colorClass %>">
                <%= (char)('A' + i) %>. <%= options[i] %>
                <% if (isCorrect && isUser) { %> - Correct
                <% } else if (isUser && !isCorrect) { %> - Your Answer
                <% } else if (isCorrect) { %> - Correct Answer
                <% } %>
            </li>
            <% } %>
        </ul>
    </div>
    <%
                qIndex++;
            }
        }
    %>
</div>
</body>
</html>
