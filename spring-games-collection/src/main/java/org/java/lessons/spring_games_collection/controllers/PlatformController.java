package org.java.lessons.spring_games_collection.controllers;

import java.util.List;

import org.java.lessons.spring_games_collection.models.Platform;
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
@RequestMapping("/platforms")
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @GetMapping
    public String index(@RequestParam(name = "search", required = false) String search, Model model) {
        List<Platform> platforms;
        if (search == null || search.isEmpty()) {
            platforms = platformService.getAll();
        } else {
            platforms = platformService.getByName(search);
        }

        model.addAttribute("platforms", platforms);
        return "platforms/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("platform", new Platform());
        model.addAttribute("edit", false);
        return "platforms/create-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("platform") Platform newPlatform, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("edit", false);
            return "platforms/create-edit";
        }
        platformService.create(newPlatform);
        return "redirect:/platforms";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("platform", platformService.getById(id).get());
        model.addAttribute("edit", true);
        return "platforms/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String postMethodName(@Valid @ModelAttribute("platform") Platform updatedPlatform, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("edit", true);
            return "platforms/create-edit";
        }
        platformService.update(updatedPlatform);
        return "redirect:/platforms";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        platformService.delete(platformService.getById(id).get());
        return "redirect:/platforms";
    }

}
