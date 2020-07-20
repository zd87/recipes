package fr.formation.recipes.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.recipes.dtos.RecipeDto;
import fr.formation.recipes.services.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
	this.recipeService = recipeService;
    }

    @PostMapping
    public void create(@Valid @RequestBody RecipeDto recipeDto) {
	recipeService.create(recipeDto);
    }
}
