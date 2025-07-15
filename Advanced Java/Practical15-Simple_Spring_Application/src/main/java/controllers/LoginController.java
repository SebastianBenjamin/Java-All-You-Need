package controllers;

import controllers.classfiles.Question;
import controllers.classfiles.Quiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String sayhello(Model model){
        model.addAttribute("message","This is a page loaded using Spring MVC");
        return "login";
    }
    @RequestMapping("/quiz")
    public String quizHome(Model model){

        return "quiz-landing";
    }
    @RequestMapping("/quiz-playground")
    public String quizPlayground(Model model){
        List<Question> questions = new ArrayList<>();

        String[] q1Options = {"2 bytes", "4 bytes", "8 bytes", "Depends on OS"};
        String[] q2Options = {"this", "import", "extends", "instanceof"};
        String[] q3Options = {"To define a constant", "To inherit a class", "To start a loop", "To throw an exception"};
        String[] q4Options = {"true", "false", "0", "null"};
        String[] q5Options = {"To call parent class constructor", "To define a subclass", "To stop execution", "To catch exceptions"};
        String[] q6Options = {"Overriding methods", "Using variables", "Method overloading", "Both A and C"};
        String[] q7Options = {"HashSet", "ArrayList", "TreeSet", "None of the above"};
        String[] q8Options = {"They are the same", "== compares references, .equals() compares values", ".equals() compares references", "== compares object content"};
        String[] q9Options = {"Using try-catch blocks", "Only by using throws", "With main method only", "Using finally block only"};
        String[] q10Options = {"ArrayList is thread-safe", "LinkedList is faster for random access", "ArrayList uses array internally, LinkedList uses nodes", "Both are same"};
        int[] correctAnswers = {1, 2, 0, 1, 0, 3, 1, 1, 0, 2};
        questions.add(new Question(1,"What is the size of int in Java?",correctAnswers[0],q1Options));
        questions.add(new Question(2," Which keyword is used to inherit a class in Java?",correctAnswers[1],q2Options));
        questions.add(new Question(3," What is the purpose of the final keyword in Java?",correctAnswers[2],q3Options));
        questions.add(new Question(4,"What is the default value of a boolean variable in Java?",correctAnswers[3],q4Options));
        questions.add(new Question(5," What is the use of the super keyword?",correctAnswers[4],q5Options));
        questions.add(new Question(6," What is polymorphism in OOP?",correctAnswers[5],q6Options));
        questions.add(new Question(7,"Which collection class allows duplicate elements?",correctAnswers[6],q7Options));
        questions.add(new Question(8,"What is the difference between == and .equals()?",correctAnswers[7],q8Options));
        questions.add(new Question(9,"How does exception handling work in Java?",correctAnswers[8],q9Options));
        questions.add(new Question(10,"What is the difference between ArrayList and LinkedList?",correctAnswers[9],q10Options));

        List<Quiz> quizes = new ArrayList<>();
        quizes.add(new Quiz("Java",questions));

        model.addAttribute("quiz",quizes);

        return "quiz-playground";
    }

@PostMapping("/quizresult")
public String submitQuiz(@RequestParam Map<String, String> params, Model model) {
    List<Quiz> quizzes = generateQuiz();  // ✅ Reuse your method
    List<Question> allQuestions = quizzes.get(0).getQuestions();

    List<Integer> selectedAnswers = new ArrayList<>();
    List<Integer> correctAnswers = new ArrayList<>();

    for (Question q : allQuestions) {
        String param = params.get("q" + q.getId());
        if (param != null) {
            try {
                selectedAnswers.add(Integer.parseInt(param));
                correctAnswers.add(q.getAnswer());
            } catch (NumberFormatException ignored) {}
        }
    }

    model.addAttribute("answers", selectedAnswers);
    model.addAttribute("correctAnswers", correctAnswers);
    model.addAttribute("quiz", quizzes); // ✅ Send the quiz back to JSP
    return "quiz-result";
}
    private List<Quiz> generateQuiz() {
        List<Question> questions = new ArrayList<>();

        String[] q1Options = {"2 bytes", "4 bytes", "8 bytes", "Depends on OS"};
        String[] q2Options = {"this", "import", "extends", "instanceof"};
        String[] q3Options = {"To define a constant", "To inherit a class", "To start a loop", "To throw an exception"};
        String[] q4Options = {"true", "false", "0", "null"};
        String[] q5Options = {"To call parent class constructor", "To define a subclass", "To stop execution", "To catch exceptions"};
        String[] q6Options = {"Overriding methods", "Using variables", "Method overloading", "Both A and C"};
        String[] q7Options = {"HashSet", "ArrayList", "TreeSet", "None of the above"};
        String[] q8Options = {"They are the same", "== compares references, .equals() compares values", ".equals() compares references", "== compares object content"};
        String[] q9Options = {"Using try-catch blocks", "Only by using throws", "With main method only", "Using finally block only"};
        String[] q10Options = {"ArrayList is thread-safe", "LinkedList is faster for random access", "ArrayList uses array internally, LinkedList uses nodes", "Both are same"};

        int[] correctAnswers = {1, 2, 0, 1, 0, 3, 1, 1, 0, 2};

        questions.add(new Question(1, "What is the size of int in Java?", correctAnswers[0], q1Options));
        questions.add(new Question(2, "Which keyword is used to inherit a class in Java?", correctAnswers[1], q2Options));
        questions.add(new Question(3, "What is the purpose of the final keyword in Java?", correctAnswers[2], q3Options));
        questions.add(new Question(4, "What is the default value of a boolean variable in Java?", correctAnswers[3], q4Options));
        questions.add(new Question(5, "What is the use of the super keyword?", correctAnswers[4], q5Options));
        questions.add(new Question(6, "What is polymorphism in OOP?", correctAnswers[5], q6Options));
        questions.add(new Question(7, "Which collection class allows duplicate elements?", correctAnswers[6], q7Options));
        questions.add(new Question(8, "What is the difference between == and .equals()?", correctAnswers[7], q8Options));
        questions.add(new Question(9, "How does exception handling work in Java?", correctAnswers[8], q9Options));
        questions.add(new Question(10, "What is the difference between ArrayList and LinkedList?", correctAnswers[9], q10Options));

        List<Quiz> quizzes = new ArrayList<>();
        quizzes.add(new Quiz("Java", questions));

        return quizzes;
    }

}