package com.example.alcoholfreeback.utils;

import com.example.alcoholfreeback.src.cocktail.entity.*;
import com.example.alcoholfreeback.src.cocktail.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final CocktailRepository cocktailRepository;
    private final CocktailTagRepository cocktailTagRepository;
    private final TagRepository tagRepository;
    private final IngredientRepository ingredientRepository;
    private final IngredientCocktailRepository ingredientCocktailRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Cocktail 스파이시_워터멜론_민트_아쿠아_프레스카_칵테일 = new Cocktail("스파이킹 워터멜론 민트 아쿠아 프레스카 칵테일", "Spicy Watermelon Mint Agua Fresca는 상큼한 수박, 시원한 민트, 그리고 매콤한 감칠맛의 조화로 만들어진 청량한 칵테일입니다. 여름에 특히 즐기기 좋으며, 알코올 버전과 무알코올 버전으로 다양한 취향에 맞출 수 있습니다.", "수박, 설탕, 라임 주스를 블렌더에 넣고 부드럽게 갈아줍니다.\n" +
                "갈아진 수박 주스를 걸러 빼낸 후, 얇게 썬 매운 고추와 찢은 민트잎을 추가합니다.\n" +
                "10-15분 동안 냉장고에서 양념이 잘 베이도록 하세요.\n" +
                "얼음이 든 글라스에 음료를 부어 주고, 알코올을 원하는 경우, 테킬라나 화이트 럼을 나눠서 섞어 줍니다.\n" +
                "음료 위에 민트 잎이나 수박 조각으로 장식을 완성합니다.", "");
        Ingredient 재료 = new Ingredient("가", "나", "다");
        Tag 상큼한 = new Tag("상큼한");
        cocktailRepository.save(스파이시_워터멜론_민트_아쿠아_프레스카_칵테일);
        ingredientRepository.save(재료);
        tagRepository.save(상큼한);
        cocktailTagRepository.save(new CocktailTag(스파이시_워터멜론_민트_아쿠아_프레스카_칵테일, 상큼한));
        ingredientCocktailRepository.save(new IngredientCocktail(재료, 스파이시_워터멜론_민트_아쿠아_프레스카_칵테일, "양"));
    }
}

