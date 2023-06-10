package com.example.alcoholfreeback.src.cocktail.repository;

import com.example.alcoholfreeback.src.cocktail.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
