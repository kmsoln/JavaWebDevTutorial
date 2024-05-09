package edu.labs.thymeleaf.controllers;

import edu.labs.thymeleaf.models.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PracticeController {

    private final List<StudentModel> students = new ArrayList<>();

    public PracticeController(){
        // Populate the list with users
        this.students.add(new StudentModel(1,"First", "User", true, 4));
        this.students.add(new StudentModel(2, "Second", "User", false, 2));
        this.students.add(new StudentModel(3, "Third", "User", true, 5));
        this.students.add(new StudentModel(3, "Fourth", "User", false, 3));
    }

    @GetMapping("/second")
    public String secondPracticeView(Model model){
        model.addAttribute("title", "second task");
        model.addAttribute("students", this.students);
        return "practice/second";
    }

    @GetMapping("/third")
    public String thirdPracticeView(Model model){
        model.addAttribute("title", "third task");
        model.addAttribute("students", this.students);
        model.addAttribute("model", new StudentModel());
        return "practice/third";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("model") StudentModel model) {
        // Additional validation: Check if the mark is more than 5.
        if (model.getMark() > 5) {
            // If the mark is more than 5, redirect with an error message.
            return "redirect:/third?error=Mark should not be more than 5";
        } else {
            students.add(model);

            return "redirect:/third?addedStudent=true";
        }
    }

    @PostMapping("/removeStudent")
    public String removeStudent(){

        return "redirect:/third?removedStudent";
    }

    @GetMapping("/fourth")
    public String fourthPracticeView(Model model){
        model.addAttribute("title", "fourth task");
        model.addAttribute("students", this.students);
        model.addAttribute("model", new StudentModel());

        return "practice/fourth";
    }
}
