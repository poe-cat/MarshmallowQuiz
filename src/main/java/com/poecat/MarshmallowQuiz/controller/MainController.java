package com.poecat.MarshmallowQuiz.controller;

import com.poecat.MarshmallowQuiz.model.Result;
import com.poecat.MarshmallowQuiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @Autowired
    Result result;
    @Autowired
    QuizService qService;




}
