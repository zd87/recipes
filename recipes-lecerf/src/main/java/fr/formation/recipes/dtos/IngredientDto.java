package fr.formation.recipes.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class IngredientDto {

    @NotBlank
    @Size(max = 255)
    private String wording;

    public IngredientDto() {
    }

    public String getWording() {
	return wording;
    }

    public void setWording(String wording) {
	this.wording = wording;
    }
}
