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
@Table(name = "steps", uniqueConstraints = {
	@UniqueConstraint(name = "uk_recipe_order", columnNames = { "id_recipe",
		"step_order" }) }, indexes = {
			@Index(name = "fk_steps_recipes_idx", columnList = "id_recipe") })
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_step")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_recipe", nullable = false, foreignKey = @ForeignKey(name = "fk_steps_recipes"))
    private Recipe recipe;

    @Column(length = 255, nullable = false, name = "step_wording")
    private String stepWording;

    @Column(nullable = false, name = "step_order")
    private int stepOrder;

    public Step() {
    }

    public Step(Recipe recipe, String stepWording, int stepOrder) {
	this.recipe = recipe;
	this.stepWording = stepWording;
	this.stepOrder = stepOrder;
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

    public String getStepWording() {
	return stepWording;
    }

    public void setStepWording(String stepWording) {
	this.stepWording = stepWording;
    }

    public int getStepOrder() {
	return stepOrder;
    }

    public void setStepOrder(int stepOrder) {
	this.stepOrder = stepOrder;
    }
}
