package com.competitiveexam.android.vci.Model;

public class AptiQues {

    public String quetion,option1,option2,option3,option4,answer ;

    public AptiQues(String quetion, String option1, String option2, String option3, String option4, String answer ) {
        this.quetion = quetion;
        this.option1 = option1 ;
        this.option2 = option2 ;
        this.option3 = option3 ;
        this.option4 = option4 ;
        this.answer = answer ;
    }
   public AptiQues(){};

    public String getQuetion() {
        return quetion;
    }

    public void setQuetion(String quetion) {
        this.quetion = quetion;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
