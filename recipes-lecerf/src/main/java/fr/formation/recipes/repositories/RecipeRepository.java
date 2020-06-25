package fr.formation.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.recipes.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe findByRecipeName(String name);
}
