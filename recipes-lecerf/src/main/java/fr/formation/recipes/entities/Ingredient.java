package fr.formation.recipes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ingredients", uniqueConstraints = {
	@UniqueConstraint(name = "uk_recipe_ingredient", columnNames = {
		"id_recipe", "ingredient_wording" }) }, indexes = {
			@Index(name = "fk_ingredients_recipes_idx", columnList = "id_recipe") })
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_recipe", nullable = false, foreignKey = @ForeignKey(name = "fk_ingredients_recipes"))
    private Recipe recipe;

    @Column(length = 255, nullable = false, name = "ingredient_wording")
    private String ingredientWording;

    public Ingredient() {
    }

    public Ingredient(Recipe recipe, String ingredientWording) {
	this.recipe = recipe;
	this.ingredientWording = ingredientWording;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Recipe getRecipe() {
	return recipe;
    }

    public void setRecipe(Recipe recipe) {
	this.recipe = recipe;
    }

    public String getIngredientWording() {
	return ingredientWording;
    }

    public void setIngredientWording(String ingredientWording) {
	this.ingredientWording = ingredientWording;
    }
}
