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
    private String quizName;
    private int chosenQuiz;

    public QuizChoice() {
    }

    public QuizChoice(int quizId, String quizName, int chosenQuiz) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.chosenQuiz = chosenQuiz;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
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
                ", quizName='" + quizName + '\'' +
                ", chosenQuiz=" + chosenQuiz +
                '}';
    }
}
