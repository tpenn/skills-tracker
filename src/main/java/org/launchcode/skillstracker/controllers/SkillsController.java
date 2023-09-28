package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class SkillsController {
    private ArrayList<String> languages = new ArrayList<>() {{
        add("Java");
        add("JavaScript");
        add("C#");
        add("Python");
        add("Mojo");
    }};

    @GetMapping
    public String homePage() {
        return "index";
    }

    @GetMapping("form")
    public String skillsForm() {
        return "form";
    }

    @RequestMapping(method = {RequestMethod.POST}, value = "form")
    public String formComplete(@RequestParam String name, String favorite, String second, String third, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("favorite", favorite);
        model.addAttribute("second", second);
        model.addAttribute("third", third);

        return "display";
    }

    @ModelAttribute("languages")
    public ArrayList<String> getLanguages() {
        return languages;
    }
}
