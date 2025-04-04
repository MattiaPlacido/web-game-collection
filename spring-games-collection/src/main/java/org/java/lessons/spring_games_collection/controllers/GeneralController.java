package org.java.lessons.spring_games_collection.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("")
public class GeneralController {

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception exception, Model model) {
        model.addAttribute("error", "An unexpected error occurred in HomepageController: " + exception.getMessage());
        return "error";
    }

    @GetMapping("")
    public String loginRedirect() {
        return "homepage";
    }

}
