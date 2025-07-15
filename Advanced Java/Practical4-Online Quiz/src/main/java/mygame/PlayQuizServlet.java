package mygame;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PlayQuiz")
public class PlayQuizServlet extends HttpServlet {
    final String[] aptitudeQuestions = {
            "\"What is the square root of 144?\",\"10\",\"11\",\"14\",\"12\"",
            "\"If a box contains 15 apples and you take away 5, how many do you have?\",\"10\",\"5\",\"15\",\"5\"",
            "\"A shopkeeper sells an item for $80, making a 25% profit. What was the cost price?\",\"$55\",\"$60\",\"$65\",\"$64\"",
            "\"What is the missing number in the sequence: 3, 6, 9, 12, ?\",\"14\",\"16\",\"18\",\"15\"",
            "\"A train covers 360 km in 6 hours. What is its speed?\",\"30 km/h\",\"65 km/h\",\"50 km/h\",\"60 km/h\"",
            "\"A bag contains 4 red balls, 5 green balls, and 6 blue balls. What is the probability of picking a red ball?\",\"1/2\",\"2/5\",\"3/15\",\"4/15\"",
            "\"If the sum of two numbers is 90 and one number is 35, what is the other number?\",\"45\",\"35\",\"60\",\"55\"",
            "\"What is 20% of 250?\",\"40\",\"45\",\"60\",\"50\"",
            "\"A shopkeeper gives a discount of 20% on a $500 product. What is the final price?\",\"$350\",\"$450\",\"$300\",\"$400\"",
            "\"If a car travels 90 km in 1.5 hours, what is its average speed?\",\"50 km/h\",\"55 km/h\",\"40 km/h\",\"60 km/h\""
    };

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        String userName = req.getParameter("name");
        String userRollNo = req.getParameter("rollno");

        if (userName == null && session.getAttribute("UserName") != null) {
            userName = session.getAttribute("UserName").toString();
        } else if (userName != null) {
            session.setAttribute("UserName", userName);
        }

        if (userRollNo == null && session.getAttribute("UserRollNo") != null) {
            userRollNo = session.getAttribute("UserRollNo").toString();
        } else if (userRollNo != null) {
            session.setAttribute("UserRollNo", userRollNo);
        }

        String questionNumberStr = req.getParameter("q");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("  <meta charset=\"UTF-8\">");
        out.println("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("  <title>Play Quiz</title> <link href='https://img.icons8.com/bubbles/50/brain.png' rel='icon'>");
        out.println("  <script src=\"https://cdn.tailwindcss.com\"></script>");
        out.println("</head>");
        out.println("<body class=\"bg-blue-50 min-h-screen\">");

        if (userName != null && userRollNo != null && questionNumberStr != null) {
            try {
                int questionNumber = Integer.parseInt(questionNumberStr);

                if (questionNumber < 1 || questionNumber > aptitudeQuestions.length) {
                    showError(out, "Invalid question number");
                    return;
                }

                Cookie nameCookie = new Cookie("UserName", userName);
                Cookie rollCookie = new Cookie("UserRollNo", userRollNo);
                nameCookie.setMaxAge(60*5);
                rollCookie.setMaxAge(60*5);
                resp.addCookie(nameCookie);
                resp.addCookie(rollCookie);

                out.println("<header class=\"border-b-8 border-blue-800 bg-blue-100 shadow-lg mb-6\">");
                out.println("  <div class=\"container mx-auto px-4 py-4\">");
                out.println("    <div class=\"flex flex-col md:flex-row justify-between items-center\">");
                out.println("      <h1 class=\"text-3xl font-bold text-blue-900\">Play Quiz</h1>");
                out.println("      <div class=\"flex flex-col sm:flex-row gap-4 mt-2 md:mt-0\">");
                out.println("        <div class=\"bg-white px-4 py-2 rounded-lg shadow-sm border border-gray-200\">");
                out.println("          <span class=\"text-gray-500 text-sm font-medium\">Name:</span>");
                out.println("          <span class=\"ml-2 font-semibold text-gray-800\">" + userName + "</span>");
                out.println("        </div>");
                out.println("        <div class=\"bg-white px-4 py-2 rounded-lg shadow-sm border border-gray-200\">");
                out.println("          <span class=\"text-gray-500 text-sm font-medium\">Roll Number:</span>");
                out.println("          <span class=\"ml-2 font-semibold text-gray-800\">" + userRollNo + "</span>");
                out.println("        </div>");
                out.println("      </div>");
                out.println("    </div>");
                out.println("  </div>");
                out.println("</header>");

                out.println("<div class=\"container mx-auto px-4 mb-6\">");
                out.println("  <div class=\"w-full bg-gray-200 rounded-full h-2.5 mb-2\">");
                double progressPercentage = ((double) questionNumber / aptitudeQuestions.length) * 100;
                out.println("    <div class=\"bg-blue-600 h-2.5 rounded-full\" style=\"width: " + progressPercentage + "%\"></div>");
                out.println("  </div>");
                out.println("  <div class=\"flex justify-between text-xs text-gray-600\">");
                out.println("    <span>Question " + questionNumber + " of " + aptitudeQuestions.length + "</span>");
                out.println("    <span>" + Math.round(progressPercentage) + "% complete</span>");
                out.println("  </div>");
                out.println("</div>");

                out.println("<main class=\"container mx-auto px-4 flex justify-center items-center mb-12\">");
                out.println("  <div class=\"bg-white rounded-xl shadow-lg p-6 w-full max-w-md border border-gray-200\">");

                String[] questionParts = aptitudeQuestions[questionNumber - 1].replaceAll("^\"|\"$", "").split("\",\"");

                out.println("    <div class=\"mb-6\">");
                out.println("      <h2 class=\"text-lg font-semibold text-gray-700 mb-4\">Question " + questionNumber + "</h2>");
                out.println("      <p class=\"text-xl font-medium text-gray-900 mb-6\">" + questionParts[0] + "</p>");
                out.println("    </div>");

                out.println("    <form action='StoreValues' method='GET' class=\"space-y-4\">");
                out.println("      <div class=\"space-y-3\">");

                for (int i = 1; i <= 4; i++) {
                    String optionValue = (i == 4) ? "1" : "0";
                    String optionId = "option" + i;

                    out.println("        <div class=\"flex items-center p-3 bg-gray-50 border border-gray-200 rounded-lg hover:bg-gray-100 cursor-pointer\">");
                    out.println("          <input type=\"radio\" id=\"" + optionId + "\" name=\"o\" value=\"" + optionValue + "\" class=\"w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500\" required>");
                    out.println("          <label for=\"" + optionId + "\" class=\"ms-2 w-full text-gray-700 cursor-pointer\">" + questionParts[i] + "</label>");
                    out.println("        </div>");
                }

                out.println("      </div>");

                out.println("      <input type=\"hidden\" name=\"q\" value=\"" + questionNumber + "\">");
                out.println("      <input type=\"hidden\" name=\"result\" value=\"" + (questionNumber == aptitudeQuestions.length ? "1" : "0") + "\">");
                out.println("      <div class=\"pt-4\">");
                out.println("        <button type=\"submit\" class=\"w-full px-6 py-3 bg-blue-600 text-white font-medium rounded-lg hover:bg-blue-700 transition-colors shadow-md focus:outline-none focus:ring-4 focus:ring-blue-300\">");
                out.println("          " + (questionNumber == aptitudeQuestions.length ? "Submit Quiz" : "Next Question") + "");
                out.println("        </button>");
                out.println("      </div>");
                out.println("    </form>");
                out.println("  </div>");
                out.println("</main>");

            } catch (NumberFormatException e) {
                showError(out, "Invalid question number format");
            }
        } else {
            showError(out, "Missing user information or question number!");
        }



        out.println("</body>");
        out.println("</html>");
    }

    private void showError(PrintWriter out, String errorMessage) {
        out.println("<div class=\"flex items-center justify-center h-screen\">");
        out.println("  <div class=\"max-w-md w-full bg-white rounded-lg shadow-lg p-8 text-center\">");
        out.println("    <svg class=\"w-16 h-16 text-red-500 mx-auto mb-4\" fill=\"none\" stroke=\"currentColor\" viewBox=\"0 0 24 24\" xmlns=\"http://www.w3.org/2000/svg\">");
        out.println("      <path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M12 8v4m0 4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z\"></path>");
        out.println("    </svg>");
        out.println("    <h2 class=\"text-2xl font-bold text-gray-800 mb-2\">Error</h2>");
        out.println("    <p class=\"text-gray-600 mb-6\">" + errorMessage + "</p>");
        out.println("    <a href=\"index.html\" class=\"px-6 py-3 bg-blue-600 text-white font-medium rounded-lg hover:bg-blue-700 transition-colors shadow-md inline-block\">Back to Home</a>");
        out.println("  </div>");
        out.println("</div>");
    }
}