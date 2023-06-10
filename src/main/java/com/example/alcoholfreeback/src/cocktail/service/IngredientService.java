package com.example.alcoholfreeback.src.cocktail.service;

import com.example.alcoholfreeback.common.exceptions.BaseException;
import com.example.alcoholfreeback.common.response.BaseResponseStatus;
import com.example.alcoholfreeback.src.cocktail.dto.IngredientNameResponseDto;
import com.example.alcoholfreeback.src.cocktail.entity.Ingredient;
import com.example.alcoholfreeback.src.cocktail.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public List<IngredientNameResponseDto> allIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        if (ingredients.isEmpty())
            throw new BaseException(BaseResponseStatus.EMPTY_LIST);
        return ingredients.stream().map(IngredientNameResponseDto::from).collect(Collectors.toList());
    }
}
