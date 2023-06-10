package com.example.alcoholfreeback.src.cocktail.repository;

import com.example.alcoholfreeback.src.cocktail.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
}
