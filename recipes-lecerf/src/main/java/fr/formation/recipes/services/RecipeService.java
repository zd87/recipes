package fr.formation.recipes.services;

import org.springframework.stereotype.Service;

import fr.formation.recipes.dtos.RecipeDto;
import fr.formation.recipes.entities.Ingredient;
import fr.formation.recipes.entities.Recipe;
import fr.formation.recipes.entities.Step;
import fr.formation.recipes.repositories.IngredientRepository;
import fr.formation.recipes.repositories.RecipeRepository;
import fr.formation.recipes.repositories.StepRepository;

@Service
public class RecipeService implements IRecipeService {

    private RecipeRepository recipes;

    private IngredientRepository ingredients;

    private StepRepository steps;

    public RecipeService(RecipeRepository recipes,
	    IngredientRepository ingredients, StepRepository steps) {
	this.recipes = recipes;
	this.ingredients = ingredients;
	this.steps = steps;
    }

    @Override
    public void create(RecipeDto recipeDto) {
	// exctracting recipe from recipeDto
	Recipe newRecipe = new Recipe(recipeDto.getName(),
		recipeDto.getPreparingTime(), recipeDto.getCookingTime(),
		recipeDto.getServings(), recipeDto.getImageUrl(),
		recipeDto.getDifficultyLevel());
	// persisting recipe
	recipes.save(newRecipe);
	// retrieveing the new recipe by its name
	Recipe savedRecipe = recipes.findByRecipeName(recipeDto.getName());
	// persisting ingredients
	for (String wording : recipeDto.getIngredients()) {
	    ingredients.save(new Ingredient(savedRecipe, wording));
	}
	// persisting steps, order is index+1
	for (String wording : recipeDto.getSteps()) {
	    steps.save(new Step(savedRecipe, wording,
		    recipeDto.getSteps().indexOf(wording) + 1));
	}
    }
}