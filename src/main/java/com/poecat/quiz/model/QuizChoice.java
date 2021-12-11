package com.poecat.quiz.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "quizzes")
public class QuizChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quizId;
    private String quiz1Name;
    private String quiz2Name;
    private int chosenQuiz;

    public QuizChoice() {
    }

    public QuizChoice(int quizId, String quiz1Name, String quiz2Name, int chosenQuiz) {
        this.quizId = quizId;
        this.quiz1Name = quiz1Name;
        this.quiz2Name = quiz2Name;
        this.chosenQuiz = chosenQuiz;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuiz1Name() {
        return quiz1Name;
    }

    public void setQuiz1Name(String quiz1Name) {
        this.quiz1Name = quiz1Name;
    }

    public String getQuiz2Name() {
        return quiz2Name;
    }

    public void setQuiz2Name(String quiz2Name) {
        this.quiz2Name = quiz2Name;
    }

    public int getChosenQuiz() {
        return chosenQuiz;
    }

    public void setChosenQuiz(int chosenQuiz) {
        this.chosenQuiz = chosenQuiz;
    }

    @Override
    public String toString() {
        return "QuizChoice{" +
                "quizId=" + quizId +
                ", quiz1Name='" + quiz1Name + '\'' +
                ", quiz2Name='" + quiz2Name + '\'' +
                ", chosenQuiz=" + chosenQuiz +
                '}';
    }
}
