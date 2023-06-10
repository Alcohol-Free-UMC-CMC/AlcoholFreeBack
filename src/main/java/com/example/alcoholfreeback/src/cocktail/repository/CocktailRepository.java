package com.example.alcoholfreeback.src.cocktail.repository;

import com.example.alcoholfreeback.src.cocktail.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

    @Query("SELECT c FROM Cocktail c JOIN FETCH c.ingredients ci JOIN FETCH ci.ingredient " +
            "JOIN FETCH ci.cocktail WHERE c.id = :id")
    Optional<Cocktail> findByIdFetch(@Param("id") Long id);

    List<Cocktail> findAllByOrderByViewsDesc();
}
