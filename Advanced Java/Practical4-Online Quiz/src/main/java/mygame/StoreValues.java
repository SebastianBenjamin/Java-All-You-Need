package mygame;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/StoreValues")
public class StoreValues extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String getValue = request.getParameter("o");
        String getQuestion = request.getParameter("q");
        String result = request.getParameter("result");

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("  <meta charset=\"UTF-8\">");
        out.println("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("  <title>Quiz Results</title> <link href='https://img.icons8.com/bubbles/50/brain.png' rel='icon'>");
        out.println("  <script src=\"https://cdn.tailwindcss.com\"></script>");
        out.println("</head>");
        out.println("<body class=\"bg-blue-50 min-h-screen\">");

        if (getValue == null || getQuestion == null || result == null) {
            out.println("<div class=\"flex items-center justify-center h-screen\">");
            out.println("  <div class=\"bg-red-100 border-l-4 border-red-500 text-red-700 p-4 rounded shadow-md\" role=\"alert\">");
            out.println("    <p class=\"font-bold\">Error</p>");
            out.println("    <p>Missing parameters. Please try again.</p>");
            out.println("  </div>");
            out.println("</div>");
            out.println("</body></html>");
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute(getQuestion, getValue);

        int sumOfMarks = 0;

        if ("1".equals(result)) {
            out.println("<header class=\"border-b-8 border-blue-800 bg-blue-100 shadow-lg mb-8 \">");
            out.println("  <div class=\"container mx-auto px-4 py-6\">");
            out.println("    <h1 class=\"text-3xl font-bold text-blue-900 text-center\">Quiz Results</h1>");
            out.println("  </div>");
            out.println("</header>");

            out.println("<main class=\"container mx-auto px-4 py-6 max-w-4xl\">");
            out.println("  <div class=\"bg-white rounded-lg shadow-md p-6 mb-8\">");

            try {
                int totalQuestions = Integer.parseInt(getQuestion);
                out.println("    <h2 class=\"text-xl font-semibold mb-4 text-gray-800\">Your Answers</h2>");
                out.println("    <div class=\"space-y-4\">");

                for (int i = 1; i <= totalQuestions; i++) {
                    String answer = (String) session.getAttribute(String.valueOf(i));

                    if (answer != null) {
                        boolean isCorrect = answer.trim().equals("1");
                        sumOfMarks += Integer.parseInt(answer);

                        out.println("      <div class=\"p-4 " + (isCorrect ? "bg-green-50 border-l-4 border-green-500" : "bg-red-50 border-l-4 border-red-500") + " rounded\">");
                        out.println("        <div class=\"flex items-center\">");
                        out.println("          <div class=\"flex-shrink-0\">");
                        out.println("            <svg class=\"h-5 w-5 " + (isCorrect ? "text-green-500" : "text-red-500") + "\" fill=\"currentColor\" viewBox=\"0 0 20 20\">");
                        if (isCorrect) {
                            out.println("              <path fill-rule=\"evenodd\" d=\"M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z\" clip-rule=\"evenodd\"/>");
                        } else {
                            out.println("              <path fill-rule=\"evenodd\" d=\"M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z\" clip-rule=\"evenodd\"/>");
                        }

                        out.println("            </svg>");
                        out.println("          </div>");
                        out.println("          <div class=\"ml-3\">");
                        out.println("            <p class=\"text-sm font-medium " + (isCorrect ? "text-green-800" : "text-red-800") + "\">Question " + i + "</p>");
                        out.println("            <p class=\"text-sm " + (isCorrect ? "text-green-700" : "text-red-700") + "\">" + (isCorrect ? "Correct answer!" : "Incorrect answer") + "</p>");
                        out.println("          </div>");
                        out.println("        </div>");
                        out.println("      </div>");
                    } else {
                        out.println("      <div class=\"p-4 bg-gray-50 border-l-4 border-gray-300 rounded\">");
                        out.println("        <p class=\"text-gray-700\">No answer recorded for Question " + i + "</p>");
                        out.println("      </div>");
                    }
                }
                out.println("    </div>");

                double percentage = (double) sumOfMarks / totalQuestions * 100;
                String scoreColorClass = percentage >= 70 ? "bg-green-100 text-green-800" :
                        (percentage >= 40 ? "bg-yellow-100 text-yellow-800" : "bg-red-100 text-red-800");

                out.println("    <div class=\"mt-8 p-6 rounded-lg " + scoreColorClass + "\">");
                out.println("      <h2 class=\"text-2xl font-bold mb-2\">Your Score</h2>");
                out.println("      <div class=\"flex items-center\">");
                out.println("        <div class=\"text-4xl font-bold mr-4\">" + sumOfMarks + "/" + totalQuestions + "</div>");
                out.println("        <div class=\"ml-4\">");
                out.println("          <div class=\"w-64 bg-gray-200 rounded-full h-4 overflow-hidden\">");
                out.println("            <div class=\"h-full " + (percentage >= 70 ? "bg-green-500" : (percentage >= 40 ? "bg-yellow-500" : "bg-red-500")) + "\" style=\"width: " + percentage + "%\"></div>");
                out.println("          </div>");
                out.println("          <p class=\"mt-1 text-sm\">" + String.format("%.1f", percentage) + "%</p>");
                out.println("        </div>");
                out.println("      </div>");
                out.println("    </div>");

            } catch (NumberFormatException e) {
                out.println("    <div class=\"bg-red-100 border-l-4 border-red-500 text-red-700 p-4 rounded\">");
                out.println("      <p class=\"font-bold\">Error</p>");
                out.println("      <p>Invalid question number format.</p>");
                out.println("    </div>");
            }

            out.println("  </div>");

            out.println("  <div class=\"flex justify-center gap-4 mt-6\">");
            out.println("    <a href=\"index.html\" class=\"px-6 py-3 bg-blue-600 text-white font-medium rounded-lg hover:bg-blue-700 transition-colors shadow-md\">Back to Home</a>");
            out.println("    <a href=\"PlayQuiz?q=1\" class=\"px-6 py-3 bg-green-600 text-white font-medium rounded-lg hover:bg-green-700 transition-colors shadow-md\">Try Again</a>");
            out.println("  </div>");
            out.println("</main>");

        } else {
            try {
                int nextQuestion = Integer.parseInt(getQuestion) + 1;
                response.sendRedirect("PlayQuiz?q=" + nextQuestion);
            } catch (NumberFormatException e) {
                out.println("<div class=\"flex items-center justify-center h-screen\">");
                out.println("  <div class=\"bg-red-100 border-l-4 border-red-500 text-red-700 p-4 rounded shadow-md\" role=\"alert\">");
                out.println("    <p class=\"font-bold\">Error</p>");
                out.println("    <p>Invalid question number format.</p>");
                out.println("  </div>");
                out.println("</div>");
            }
        }



        out.println("</body>");
        out.println("</html>");
        Cookie[] cookie=request.getCookies();
        for (Cookie c:cookie) {
            if(c.getName().equals("name")||c.getName().equals("rollno")) {
                if(c.getValue()==null){
                    response.sendRedirect("index.html");
                }
            }
        }
    }
}