package org.java.lessons.spring_games_collection.controllers;

import java.util.List;

import org.java.lessons.spring_games_collection.models.Genre;
import org.java.lessons.spring_games_collection.models.Genre.GameTargetAudience;
import org.java.lessons.spring_games_collection.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public String index(@RequestParam(name = "search", required = false) String search, Model model) {
        List<Genre> genres;
        if (search == null || search.isEmpty()) {
            genres = genreService.getAll();
        } else {
            genres = genreService.getByName(search);
        }

        model.addAttribute("genres", genres);
        return "genres/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("genre", new Genre());
        model.addAttribute("edit", false);
        model.addAttribute("gameTargetAudiences", GameTargetAudience.values());

        return "genres/create-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("genre") Genre newGenre, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("edit", false);
            model.addAttribute("gameTargetAudiences", GameTargetAudience.values());
            return "genres/create-edit";
        }
        genreService.create(newGenre);
        return "redirect:/genres";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("genre", genreService.getById(id).get());
        model.addAttribute("gameTargetAudiences", GameTargetAudience.values());
        model.addAttribute("edit", true);
        return "genres/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("genre") Genre updatedGenre, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("gameTargetAudiences", GameTargetAudience.values());
            model.addAttribute("edit", true);
            return "genres/create-edit";
        }
        genreService.update(updatedGenre);
        return "redirect:/genres";
    }

    @PostMapping("/delete/{id}")
    public String postMethodName(@PathVariable Integer id) {
        genreService.delete(genreService.getById(id).get());
        return "redirect:/genres";
    }

}
