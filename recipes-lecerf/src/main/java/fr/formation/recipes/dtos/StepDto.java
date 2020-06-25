package fr.formation.recipes.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StepDto {

    @Min(value = 1)
    @Max(value = 20)
    private int order;

    @NotBlank
    @Size(max = 255)
    private String wording;

    public StepDto() {
    }

    public int getOrder() {
	return order;
    }

    public void setOrder(int order) {
	this.order = order;
    }

    public String getWording() {
	return wording;
    }

    public void setWording(String wording) {
	this.wording = wording;
    }
}
