package com.poecat.quiz.service;

import com.poecat.quiz.model.QuizChoice;
import org.springframework.beans.factory.annotation.Autowired;


public class QuizChoiceService {

    @Autowired
    QuizChoice quizChoice;

    public QuizChoice getQuiz() {

        return quizChoice;
    }
}
