package com.poecat.MarshmallowQuiz.model;

import org.springframework.stereotype.Component;
import javax.persistence.*;

@Component
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quesId;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private int ans;
    private int chose;

    public Question() {
        //empty?
    }




}
