package com.example.alcoholfreeback.src.cocktail.repository;

import com.example.alcoholfreeback.src.cocktail.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
