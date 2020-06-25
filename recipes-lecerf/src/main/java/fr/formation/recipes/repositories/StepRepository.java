package fr.formation.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.recipes.entities.Step;

public interface StepRepository extends JpaRepository<Step, Long> {
}
