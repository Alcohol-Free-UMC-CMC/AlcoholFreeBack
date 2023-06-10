package com.example.alcoholfreeback.src.cocktail.repository;

import com.example.alcoholfreeback.src.cocktail.entity.IngredientCocktail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientCocktailRepository extends JpaRepository<IngredientCocktail, Long> {
}
