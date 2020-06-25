package fr.formation.recipes.dtos;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.formation.recipes.entities.Difficulty;

public class RecipeDto {

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @Min(value = 3)
    @Max(value = 100)
    private int preparingTime;

    @Min(value = 1)
    @Max(value = 120)
    private int cookingTime;

    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    private int servings;

    @NotNull
    private Difficulty difficultyLevel;

    @NotBlank
    @Size(min = 7, max = 2500)
    private String imageUrl;

    @NotEmpty
    List<String> ingredients;

    @NotEmpty
    List<String> steps;

    public RecipeDto() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getPreparingTime() {
	return preparingTime;
    }

    public void setPreparingTime(int preparingTime) {
	this.preparingTime = preparingTime;
    }

    public int getCookingTime() {
	return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
	this.cookingTime = cookingTime;
    }

    public int getServings() {
	return servings;
    }

    public void setServings(int servings) {
	this.servings = servings;
    }

    public Difficulty getDifficultyLevel() {
	return difficultyLevel;
    }

    public void setDifficultyLevel(Difficulty difficultyLevel) {
	this.difficultyLevel = difficultyLevel;
    }

    public String getImageUrl() {
	return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
    }

    public List<String> getIngredients() {
	return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
	this.ingredients = ingredients;
    }

    public List<String> getSteps() {
	return steps;
    }

    public void setSteps(List<String> steps) {
	this.steps = steps;
    }
}