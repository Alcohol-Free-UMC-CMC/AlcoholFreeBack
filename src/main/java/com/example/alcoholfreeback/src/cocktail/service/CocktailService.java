package com.example.alcoholfreeback.src.cocktail.service;

import com.example.alcoholfreeback.common.exceptions.BaseException;
import com.example.alcoholfreeback.common.response.BaseResponseStatus;
import com.example.alcoholfreeback.src.cocktail.entity.Cocktail;
import com.example.alcoholfreeback.src.cocktail.model.CocktailDetailDto;
import com.example.alcoholfreeback.src.cocktail.model.CocktailDto;
import com.example.alcoholfreeback.src.cocktail.model.CocktailSearchCond;
import com.example.alcoholfreeback.src.cocktail.model.IngredientDto;
import com.example.alcoholfreeback.src.cocktail.repository.CocktailRepository;
import com.example.alcoholfreeback.src.cocktail.repository.CocktailSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class CocktailService {

    private final CocktailRepository cocktailRepository;
    private final CocktailSearchRepository cocktailSearchRepository;

    public CocktailDetailDto getCocktailDetail(Long id) {
        Cocktail cocktail = cocktailRepository.findByIdFetch(id).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NOT_FOUND_COCKTAIL));

        return new CocktailDetailDto(cocktail.getName(), cocktail.getImageUrl(), cocktail.getDescription(),
                cocktail.getTags().stream().map(t -> t.getTag().getName()).collect(Collectors.toList()),
                cocktail.getIngredients().stream().map(i -> new IngredientDto(i.getIngredient().getName(), i.getAmount())).collect(Collectors.toList()),
                cocktail.getRecipe());
    }

    public List<CocktailDto> getPopularCocktails() {
        List<Cocktail> cocktails = cocktailRepository.findAllByOrderByViewsDesc();
        if (cocktails == null || cocktails.isEmpty()) {
            return Collections.emptyList();
        }
        return cocktails.stream().map(c -> new CocktailDto(c)).collect(Collectors.toList());
    }

    public List<CocktailDto> getCocktailByCond(CocktailSearchCond cond) {
        List<CocktailDto> cocktails = cocktailSearchRepository.searchCocktailByAllCond(cond);
        if (cocktails == null || cocktails.isEmpty()) {
            return Collections.emptyList();
        }
        return cocktails;
    }
}
