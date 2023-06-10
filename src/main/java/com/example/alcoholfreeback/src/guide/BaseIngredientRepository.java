package com.example.alcoholfreeback.src.guide;

import com.example.alcoholfreeback.src.guide.entity.BaseIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseIngredientRepository extends JpaRepository<BaseIngredient, Long> {
}
