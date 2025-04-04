package org.java.lessons.spring_games_collection.controllers;

import java.util.List;
import java.util.Optional;

import org.java.lessons.spring_games_collection.models.Game;
import org.java.lessons.spring_games_collection.services.GameService;
import org.java.lessons.spring_games_collection.services.GenreService;
import org.java.lessons.spring_games_collection.services.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private PlatformService platformService;

    @GetMapping
    public String index(@RequestParam(name = "search", required = false) String search, Model model) {
        List<Game> games;
        if (search == null || search.isEmpty()) {
            games = gameService.getAll();
        } else {
            games = gameService.getByName(search);
        }

        model.addAttribute("games", games);
        return "games/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") Integer id) {
        Optional<Game> gameAttempt = gameService.getById(id);
        if (gameAttempt.isEmpty()) {
            throw new RuntimeException("Game not found.");
        }
        model.addAttribute("game", gameAttempt.get());
        return "games/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("platforms", platformService.getAll());
        model.addAttribute("edit", false);
        return "games/create-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("game") Game newGame, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("genres", genreService.getAll());
            model.addAttribute("platforms", platformService.getAll());
            model.addAttribute("edit", false);
            return "games/create-edit";
        }

        gameService.create(newGame);

        return "redirect:/games";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("game", gameService.getById(id).get());
        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("platforms", platformService.getAll());
        model.addAttribute("edit", true);
        return "games/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("game") Game updatedGame, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("genres", genreService.getAll());
            model.addAttribute("platforms", platformService.getAll());
            model.addAttribute("edit", true);
            return "games/create-edit";
        }

        gameService.update(updatedGame);

        return "redirect:/games/" + updatedGame.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        gameService.deleteById(id);
        return "redirect:/games";
    }

}
