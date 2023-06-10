package com.example.alcoholfreeback.src.cocktail.repository;

import com.example.alcoholfreeback.common.entity.BaseEntity;
import com.example.alcoholfreeback.src.cocktail.entity.Cocktail;
import com.example.alcoholfreeback.src.cocktail.entity.QCocktail;
import com.example.alcoholfreeback.src.cocktail.entity.QCocktailTag;
import com.example.alcoholfreeback.src.cocktail.entity.QIngredient;
import com.example.alcoholfreeback.src.cocktail.model.CocktailDto;
import com.example.alcoholfreeback.src.cocktail.model.CocktailSearchCond;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.alcoholfreeback.src.cocktail.entity.QCocktail.*;
import static com.example.alcoholfreeback.src.cocktail.entity.QCocktailTag.*;
import static com.example.alcoholfreeback.src.cocktail.entity.QIngredient.*;
import static com.example.alcoholfreeback.src.cocktail.entity.QTag.tag;

@Repository
public class CocktailSearchRepository {

    private final JPAQueryFactory queryFactory;

    public CocktailSearchRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    private BooleanExpression keywordLike(String keyword) {
        return (keyword == null || keyword.length() == 0) ? null : cocktail.name.like("%" + keyword + "%");
    }

    private BooleanExpression tagEq(String tagName) {
        return tagName.isEmpty() ? null : tag.name.eq(tagName);
    }

    private BooleanExpression ingredientEq(String ingredientName) {
        return ingredientName.isEmpty() ? null : ingredient.name.eq(ingredientName);
    }

    public List<CocktailDto> searchCocktailByAllCond(CocktailSearchCond cond) {
        List<Cocktail> cocktails = queryFactory.select(cocktail)
                .from(cocktail)
                .innerJoin(cocktail.tags, cocktailTag).on()
                .innerJoin(cocktailTag.tag, tag)
                .where(keywordLike(cond.getKeyword()),
                        tagEq(cond.getTag()),
                        ingredientEq(cond.getIngredient()),
                        cocktail.state.eq(BaseEntity.State.ACTIVE))
                .fetch();
        return cocktails.stream().map(CocktailDto::new).collect(Collectors.toList());
    }
}
