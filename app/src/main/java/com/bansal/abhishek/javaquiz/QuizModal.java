package com.bansal.abhishek.javaquiz;

public class QuizModal {
    final private String question1;
    final private String option;
    final  private String option2;
    final  private String option3;
    final private String option4;
    final private String answer;
    public QuizModal(String question1, String option, String option2, String option3, String option4, String answer) {
        this.question1 = question1;
        this.option = option;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }
    public String getQuestion1() {
        return question1;
    }
    public String getOption() {
        return option;
    }
    public String getOption2() {
        return option2;
    }
    public String getOption3() {
        return option3;
    }
    public String getOption4() {
        return option4;
    }
    public String getAnswer() {
        return answer;
    }
}
