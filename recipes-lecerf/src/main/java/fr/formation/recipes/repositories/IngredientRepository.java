package fr.formation.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.recipes.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
