package com.poecat.quiz.controller;

import com.poecat.quiz.model.QuestionForm;
import com.poecat.quiz.model.Result;
import com.poecat.quiz.model.User;
import com.poecat.quiz.repo.UserRepo;
import com.poecat.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    Result result;
    @Autowired
    QuizService qService;
    @Autowired
    UserRepo userRepo;

    Boolean submitted = false;

    @ModelAttribute("result")
    public Result getResult() {
        return result;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }


    @PostMapping("/login_failure_handler")
    public String loginFailureHandler() {
        System.out.println("Login failure handler...");

        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/user")
    public String user(@CurrentSecurityContext(expression="authentication?.name")
                                   String username) {
        return "indexU.html";
    }

    @GetMapping("/admin")
    public String admin() {
        return "indexA.html";
    }

    @PostMapping("/quiz")
    public String quiz(@RequestParam String username, Model m, RedirectAttributes ra) {
        if(username.equals("")) {
            ra.addFlashAttribute("warning", "You must enter your name first!");
            return "redirect:/";
        }

        submitted = false;
        result.setUsername(username);

        QuestionForm qForm = qService.getQuestions();
        m.addAttribute("qForm", qForm);

        return "quiz.html";
    }

    @PostMapping("/quizLoggedIn")
    public String quizLoggedIn(@CurrentSecurityContext(expression="authentication?.name")
                                           String username, Model m, RedirectAttributes ra) {
        submitted = false;
        result.setUsername(username);

        QuestionForm qForm = qService.getQuestions();
        m.addAttribute("qForm", qForm);

        return "quiz.html";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute QuestionForm qForm, Model m) {
        if(!submitted) {
            result.setTotalCorrect(qService.getResult(qForm));
            qService.saveScore(result);
            submitted = true;
        }

        return "result.html";
    }

    @GetMapping("/score")
    public String score(Model m) {
        List<Result> sList = qService.getTopScore();
        m.addAttribute("sList", sList);

        return "scoreboard.html";
    }

    @GetMapping("/learn")
    public String learn() {
        //throw new ResourceUnavailableException("Sorry! There's nothing here... for now.");

        return "learn.html";
    }
}