package com.labs.thymeleaf.controllers;

import com.labs.thymeleaf.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PracticeController {
    private final List<User> users = new ArrayList<>();
    public PracticeController(){
        // Populate the list with users
        this.users.add(new User(1,"First", "User", true));
        this.users.add(new User(2, "Second", "User", false));
        this.users.add(new User(3, "Third", "User", true));
    }

    @GetMapping("/second")
    public String secondPracticeView(Model model){
        model.addAttribute("title", "second task");
        return "practice/second";
    }

    @GetMapping("/third")
    public String thirdPracticeView(Model model){
        model.addAttribute("users", this.users);
        return "practice/third";
    }

    @GetMapping("/fourth")
    public String fourthPracticeView(Model model){
        model.addAttribute("users", this.users);
        return "practice/fourth";
    }
}
