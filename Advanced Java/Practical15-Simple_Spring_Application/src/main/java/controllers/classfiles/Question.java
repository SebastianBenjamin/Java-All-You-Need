package controllers.classfiles;

public class Question {
    int id;
    String question;
    String[] options;
    int answer;

    public Question(int id, String question, int answer, String[] options) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
