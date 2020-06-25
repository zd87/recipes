package fr.formation.recipes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "recipes", uniqueConstraints = {
	@UniqueConstraint(name = "uk_recipe_name", columnNames = {
		"recipe_name" }) })
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe")
    private Long id;

    @Column(length = 100, nullable = false, name = "recipe_name")
    private String recipeName;

    @Column(nullable = false)
    private int preparingTimeMinutes;

    private int cookingTimeMinutes;

    @Column(nullable = false)
    private int servings;

    @Column(length = 2500, nullable = false)
    private String dishImageUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // without it threw exception "Data truncated
				 // for column 'difficulty'"
    private Difficulty difficulty;

    public Recipe() {
    }

    public Recipe(String recipeName, int preparingTimeMinutes,
	    int cookingTimeMinutes, int servings, String dishImageUrl,
	    Difficulty difficulty) {
	this.recipeName = recipeName;
	this.preparingTimeMinutes = preparingTimeMinutes;
	this.cookingTimeMinutes = cookingTimeMinutes;
	this.servings = servings;
	this.dishImageUrl = dishImageUrl;
	this.difficulty = difficulty;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getRecipeName() {
	return recipeName;
    }

    public void setRecipeName(String recipeName) {
	this.recipeName = recipeName;
    }

    public int getPreparingTimeMinutes() {
	return preparingTimeMinutes;
    }

    public void setPreparingTimeMinutes(int preparingTimeMinutes) {
	this.preparingTimeMinutes = preparingTimeMinutes;
    }

    public int getCookingTimeMinutes() {
	return cookingTimeMinutes;
    }

    public void setCookingTimeMinutes(int cookingTimeMinutes) {
	this.cookingTimeMinutes = cookingTimeMinutes;
    }

    public int getServings() {
	return servings;
    }

    public void setServings(int servings) {
	this.servings = servings;
    }

    public String getDishImageUrl() {
	return dishImageUrl;
    }

    public void setDishImageUrl(String dishImageUrl) {
	this.dishImageUrl = dishImageUrl;
    }

    public Difficulty getDifficulty() {
	return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
	this.difficulty = difficulty;
    }
}
