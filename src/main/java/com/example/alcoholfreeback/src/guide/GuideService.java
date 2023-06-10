package com.example.alcoholfreeback.src.guide;

import com.example.alcoholfreeback.common.exceptions.BaseException;
import com.example.alcoholfreeback.common.response.BaseResponseStatus;
import com.example.alcoholfreeback.src.cocktail.entity.Ingredient;
import com.example.alcoholfreeback.src.cocktail.repository.IngredientRepository;
import com.example.alcoholfreeback.src.guide.dto.IngredientResponseDto;
import com.example.alcoholfreeback.src.guide.dto.ToolResponseDto;
import com.example.alcoholfreeback.src.guide.entity.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class GuideService {
    private final ToolRepository toolRepository;
    private final IngredientRepository ingredientRepository;

    public List<ToolResponseDto> allTools() {
        List<Tool> tools = toolRepository.findAll();
        if (tools == null || tools.isEmpty())
            return Collections.emptyList();
        return tools.stream().map(ToolResponseDto::from).collect(Collectors.toList());
    }

    public ToolResponseDto oneTool(Long id) {
        Tool tool = toolRepository.findById(id).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NOT_FIND_VALUE)
        );

        return ToolResponseDto.from(tool);
    }

    public List<IngredientResponseDto> allIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        if (ingredients == null || ingredients.isEmpty())
            return Collections.emptyList();
        return ingredients.stream().map(IngredientResponseDto::from).collect(Collectors.toList());
    }

    public IngredientResponseDto oneIngredient(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NOT_FIND_VALUE)
        );

        return IngredientResponseDto.from(ingredient);
    }
}
