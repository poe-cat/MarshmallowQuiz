package com.poecat.quiz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public class SessionController {

    @GetMapping("/session/invalid")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String sessionInvalid(){
        return  "session has expired, please re-authenticate";
    }
}
