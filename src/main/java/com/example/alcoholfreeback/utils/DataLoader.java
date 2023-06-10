package com.example.alcoholfreeback.utils;

import com.example.alcoholfreeback.src.cocktail.entity.*;
import com.example.alcoholfreeback.src.cocktail.repository.*;
import com.example.alcoholfreeback.src.guide.ToolRepository;
import com.example.alcoholfreeback.src.guide.entity.BaseIngredient;
import com.example.alcoholfreeback.src.guide.entity.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final CocktailRepository cocktailRepository;
    private final TagRepository tagRepository;
    private final CocktailTagRepository cocktailTagRepository;
    private final IngredientRepository ingredientRepository;
    private final IngredientCocktailRepository ingredientCocktailRepository;
    private final ToolRepository toolRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Tool 코블러쉐이커 = new Tool("코블러 쉐이커", "캡+스트레이너(여과기)+바디의 3등분으로 구성되어 있습니다. 뚜껑이 있어 쉐이킹 후, 얼음이 스트레이너에서" +
                "걸러져나오는 형태의 쉐이커입니다. 거품을 많이 내는 칵테일에 주로 쓰입니다. 쉐이커 바디에 얼음을 1/2~1/3 정도 채우고 재료를 넣습니다. 바디, 스트레이너, 캡 순서대로 닫아줍니다." +
                " 캡을 마지막에 넣는 이유는 냉각으로 캡이 잘 열리지 않는 것을 최대한 방지할 수 있기 때문입니다. 한 쪽 엄지를 캡에 올리고, 다른 한 쪽의 검지와 중지는 바디 아래쪽을 댄 상태로 쉐이커를 고정합니다. " +
                "10~15초 간 쉐이킹을 합니다. 다만, 코블러 쉐이커는 얼음이 빨리 녹아 희석이 다른 쉐이커에 더 된다는 단점이 있습니다.",
                "https://cdn.shopify.com/s/files/1/0211/7300/products/usagi-heavyweight-cobbler-shaker-998044_2048x.jpg?v=1642102535");

        Tool 보스턴쉐이커 = new Tool("보스턴 쉐이커", "코블러 쉐이커로도 대부분의 칵테일을 만들 수 있긴 하지만, 보스턴 쉐이커도 하나쯤은 구비하고 있는 것이 좋습니다. " +
                "용량이 큰 보온병이나 텀블러로 대체 가능하긴 하지만, 종종 크림이나 우유, 계란이 들어가는 칵테일을 만들 때는 꼭 필요한 도구입니다. " +
                "특히 계란을 사용하는 칵테일은 보온병으로 만들다가 터질 수 있는 가능성이 매우 큽니다. 안에 공기가 더욱 많이 들어가기 때문에 조금 더 부드로운 칵테일을 만들 수 있습니다.",
                "https://www.liquor.com/thmb/l9XU26RNguhM1no95eKibGPsF38=/fit-in/1500x1000/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/cocktail-kingdom-leopold-weighted-shaking-tin-set-c9dab0851ce945d7a144e4e37f745b12.jpg");

        Tool 지거 = new Tool("지거", "정확한 계량을 위해 반드시 필요한 도구입니다. 산이 포함된 라임이나 레몬주스, 그리고 설탕시럽은 미세한 용량의 차이로도 맛을 크게 변화시키기에 홈텐딩에 빠질 수 없는 필수품입니다. " +
                "효율성을 중시한다면 내부 안쪽에 계량선이 있는 것을 추천합니다. 다만, 이 또한 소주잔으로 대체할 수 있습니다.",
                "https://i.pinimg.com/originals/31/a8/5b/31a85b5a9ddc0e97ec8b8d62cfa2d70c.jpg");

        Tool 바스푼 = new Tool("바 스푼", "바 스푼은 중간에 꼬여있는 부분의 견고함과 길이를 보고 고르는 것이 좋습니다. 스터 기법의 " +
                "마티니 스타일의 칵테일을 제조할 시에 손가락의 기술에 이용하여 칵테일을 만들기 때문에 가운데 꼬여있는 트위스트 부분이 얼마나 견고한지가 중요하기 때문입니다. " +
                "길이는 30~40cm 정도가 가장 적당합니다.",
                "https://valleyvariety.com/products/stainless-steel-weighted-barspoon?variant=38028075630759&epik=dj0yJnU9dlFUYU1JTkNpZlN0M3Qzc0czVGM2M1hTZXpmVWtmY04mcD0wJm49dmxiLW9UV2lKcVFPSXVKd1owQVEwUSZ0PUFBQUFBR1NFcTZz");

        Tool 믹싱글라스 = new Tool("믹싱 글라스", "쉽게 잘 섞이는 재료를 만들거나, 잔으로 직접 만들 수 없는 모양의 칵테일 잔을 쓸 때 사용합니다. 또한 얼음이 없는 시원한 칵테일을 만들 때도 유용합니다. 냉각이나 희석되는 정도를 " +
                "쉐이커보다 섬세하게 조절할 수 있습니다.",
                "//i.namu.wiki/i/eVdwlRr1xaa6QgXjnwHVfkwFxI6mw3Vv5CdyVKjITweMoyR6V5mQNmJccxwGQnBi-Kuk6CxqfdkPVnZrGxw37FNJbOXM3yO2QpHbS9g1dzYjChIBLIb2dw9V3Q_hs-DscpVkt_hWmqbKIUEzbpnPvw.webp");

        BaseIngredient lime = new BaseIngredient("라임 주스", "모히또에 빼놓을 수 없는 재료입니다. 2020년경 부터는 수입사들이 많아져서 남미, 베트남산 라임이 들어오기 때문에 웬만한 바에서 평균 1만~2만원 사이 라임베이스 칵테일에는 라임을 씁니다. 물론 냉동라임, 생라임 이렇게 들어오기 때문에 주문전에 한번 바텐더에게 물어보는 것도 좋습니다.", "https://i.imgur.com/ySaEpbi.jpg");
        BaseIngredient coconut_milk = new BaseIngredient("코코넛밀크", "코코넛 밀크는 무알콜 칵테일에 기분 좋은 열대성 트위스트를 더할 수 있는 크리미하고 풍부한 재료입니다. 무알코올 칵테일에 크리미한 질감과 열대 지방의 감촉을 선사하며, 그 맛을 풍부하게 하고 벨벳 같은 음주 경험을 만들어냅니다. 모든 한 모금에서 이국적인 맛을 제공하면서 광범위한 무알코올 칵테일 창작을 가능하게 합니다.", "https://i.imgur.com/T1s5MS9.jpg");
        BaseIngredient club_sodar = new BaseIngredient("클럽소다", "탄산수 또는 소다수로도 알려진 클럽 소다는 칵테일 분야에서 흔히 사용되는 성분입니다. 다양한 음료에 상쾌함과 거품의 요소를 더해주는 탄산이 맑은 음료입니다. 전반적으로 클럽 소다는 거품, 희석 및 기분 좋은 질감을 제공하여 칵테일에 활기차고 상쾌한 요소를 더합니다. 다양한 음료에 사용할 수 있는 다용도 믹서로 가볍고 발포성 있는 터치를 제공하여 전반적인 맛과 경험을 향상시킵니다.", "https://i.imgur.com/WaSHcII.jpg");
        BaseIngredient mint = new BaseIngredient("민트", "전반적으로 민트 잎은 칵테일에 밝고 상쾌한 요소를 추가하는 능력으로 높이 평가됩니다. 그들은 다양한 재료를 보완하는 시원한 허브 풍미와 향을 제공하여 믹솔로지스트와 칵테일 애호가 모두에게 인기 있는 선택이 됩니다.", "https://i.imgur.com/DemcfoJ.jpg");
        BaseIngredient pannel = new BaseIngredient("펜넬", "무알코올 칵테일에 초본 향과 약간 달콤한 향을 더해 전체적인 맛 경험에 깊이와 복합성을 부여합니다. 창의적인 조합을 탐색하고 시각적으로 매력적이고 맛있는 무알콜 목테일을 만들 수 있습니다.", "https://i.imgur.com/DemcfoJ.jpg");

        Cocktail 애프터글로우 = new Cocktail("애프터 글로우", "애프터 글로우 칵테일은 매우 쉬운 만드는 방법과 밝은 오렌지색으로 빛나는 아름다운 외모로 유명합니다.", "1. 칵테일 샤케에 오렌지 주스, 크랜베리 주스, 코코넛 크림을 담습니다.\n" +
                "2. 얼음을 추가한 후, 쉐이크합니다.\n" +
                "3. 스트레이너를 사용하여, 마시기 좋은 형태로 옮겨줍니다.", "https://www.thecocktaildb.com/images/media/drink/vuquyv1468876052.jpg");
        Ingredient 오렌지주스 = new Ingredient("오렌지 주스");
        Ingredient 크랜베리주스 = new Ingredient("크랜베리 주스");
        Ingredient 코코넛크림 = new Ingredient("코코넛 크림");
        Ingredient 얼음 = new Ingredient("얼음");
        Tag 상쾌한 = new Tag("상쾌한");
        cocktailRepository.save(애프터글로우);
        ingredientRepository.save(오렌지주스);
        ingredientRepository.save(크랜베리주스);
        ingredientRepository.save(코코넛크림);
        ingredientRepository.save(얼음);
        tagRepository.save(상쾌한);
        cocktailTagRepository.save(new CocktailTag(애프터글로우, 상쾌한));
        ingredientCocktailRepository.save(new IngredientCocktail(오렌지주스, 애프터글로우, "2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(크랜베리주스, 애프터글로우, "2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(코코넛크림, 애프터글로우, "2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(얼음, 애프터글로우, "적당량"));


        Cocktail 애플베리스무디 = new Cocktail("애플 베리 스무디", "애플 베리 스무디 칵테일은 사과와 베리가 조화롭게 어우러져 상큼하면서도 달콤한 맛이 특징인 스무디입니다.", "1. 블루베리, 적포도주스, 다진 사과, 프로바이오틱 요거트, 아이스크림과 꿀을 믹서기에 넣고 갈아줍니다.\n" +
                "2. 완전히 섞인 상태가 되면 준비된 잔에 따라줍니다.\n" +
                "3. 상단을 장식으로 블루베리 몇 개와 사과 다질을 넣어줍니다.\n", "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg");
        Ingredient 적포도주스 = new Ingredient("적포도 주스");
        Ingredient 사과 = new Ingredient("사과");
        Ingredient 블루베리 = new Ingredient("블루베리");
        Ingredient 프로바이오틱요거트 = new Ingredient("프로바이오틱 요거트");
        Ingredient 아이스크림 = new Ingredient("아이스크림");
        Ingredient 꿀 = new Ingredient("꿀");
        Tag 상큼한 = new Tag("상큼한");
        Tag 달콤한 = new Tag("달콤한");
        cocktailRepository.save(애플베리스무디);
        ingredientRepository.save(적포도주스);
        ingredientRepository.save(사과);
        ingredientRepository.save(블루베리);
        ingredientRepository.save(프로바이오틱요거트);
        ingredientRepository.save(아이스크림);
        ingredientRepository.save(꿀);
        tagRepository.save(상큼한);
        tagRepository.save(달콤한);
        cocktailTagRepository.save(new CocktailTag(애플베리스무디, 상큼한));
        cocktailTagRepository.save(new CocktailTag(애플베리스무디, 달콤한));
        ingredientCocktailRepository.save(new IngredientCocktail(적포도주스, 애플베리스무디, "1/2컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(사과, 애플베리스무디, "1개"));
        ingredientCocktailRepository.save(new IngredientCocktail(블루베리, 애플베리스무디, "1/2컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(프로바이오틱요거트, 애플베리스무디, "1컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(아이스크림, 애플베리스무디, "1/4컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(꿀, 애플베리스무디, "1수저"));

        Cocktail 크랜베리펀치 = new Cocktail("크랜베리 펀치", "크랜베리 펀치 칵테일은 과일향이 풍부하고 상큼한 맛이 특징인 논알콜 칵테일입니다. 이 음료는 파티와 행사에서 사랑받는 음료로 알려져 있습니다.", "1. 큰 피처에 모든 주스를 섞습니다 (크랜베리 주스, 파인애플 주스, 오렌지 주스).\n" +
                "2. 아이스큐브를 추가합니다.\n" +
                "3. 소다수를 추가하여 탄산을 좋아하는 경우 다양한 레이어를 만들 수 있도록 섞어줍니다. (선택 사항)\n" +
                "4.접시에 주스를 붓기 전까지 서 있게 남겨두어 잘 섞이게 합니다.\n" +
                "5. 장식을 추가하려면, 칵테일을 장식할 수 있도록 크랜베리를 각 잔마다 넣어줍니다.", "https://www.thecocktaildb.com/images/media/drink/mzgaqu1504389248.jpg");
        Ingredient 파인애플주스 = new Ingredient("파인애플 주스");
        Ingredient 아이스큐브 = new Ingredient("아이스 큐브");
        Ingredient 소다수 = new Ingredient("소다수");
        Ingredient 크랜베리장식 = new Ingredient("크랜베리 장식");
        cocktailRepository.save(크랜베리펀치);
        ingredientRepository.save(파인애플주스);
        ingredientRepository.save(아이스큐브);
        ingredientRepository.save(소다수);
        ingredientRepository.save(크랜베리장식);
        cocktailTagRepository.save(new CocktailTag(크랜베리펀치, 상큼한));
        cocktailTagRepository.save(new CocktailTag(크랜베리펀치, 달콤한));
        ingredientCocktailRepository.save(new IngredientCocktail(오렌지주스, 크랜베리펀치, "1컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(크랜베리주스, 크랜베리펀치, "2컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(파인애플주스, 크랜베리펀치, "2컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(아이스큐브, 크랜베리펀치, "1컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(소다수, 크랜베리펀치, "1컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(크랜베리장식, 크랜베리펀치, "선택사항"));


        Cocktail 에그크림 = new Cocktail("에그 크림", "에그 크림 칵테일은 알갱이가 없는 크림처럼 풍부한 텍스처의 칵테일로, 달콤한 초콜릿 혹은 바닐라 맛이 돋보이는 전통적인 음료입니다. 알약이 들어있지 않음에도 그 이름에서 유래한 신비한 음료입니다.", "1. 맥주잔에 초콜릿 시럽을 페이지 올리듯이 끼워넣습니다.\n" +
                "2. 6 온스 우유를 천천히 섞으며 숟가락을 짚어 조금씩 넣어 줍니다.\n" +
                "3. 어긋り가 없게 되어있으면, 소다를 천천히 쏟으면서 폭발할 정도로 넣어줍니다. 그 후에 기포 상태를 섞지 않고 얼음살로 긴 숟가락을 사용해 계속 크게 섞어줍니다.", "https://www.thecocktaildb.com/images/media/drink/mvis731484430445.jpg");
        Ingredient 초콜릿시럽 = new Ingredient("초콜릿 시럽");
        Ingredient 우유 = new Ingredient("우유");
        Ingredient 클럽소다 = new Ingredient("클럽 소다");
        cocktailRepository.save(에그크림);
        ingredientRepository.save(우유);
        ingredientRepository.save(초콜릿시럽);
        ingredientRepository.save(클럽소다);
        Tag 부드러운 = new Tag("부드러운");
        tagRepository.save(부드러운);
        cocktailTagRepository.save(new CocktailTag(에그크림, 부드러운));
        cocktailTagRepository.save(new CocktailTag(에그크림, 달콤한));
        ingredientCocktailRepository.save(new IngredientCocktail(초콜릿시럽, 에그크림, "2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(우유, 에그크림, "6온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(클럽소다, 에그크림, "큰 거품까지 약 1/2컵"));


        Cocktail 프룻쿨러 = new Cocktail("프룻 쿨러", "프룻 쿨러 칵테일은 상큼한 과일맛이 가미된 청량한 칵테일로, 더운 날씨에 먹기 좋은 시원한 음료입니다.", "1. 해리게인트(Hurricane) 잔 또는 그에 준하는 소형 와인잔에 얼음을 채웁니다.\n" +
                "2. 오렌지 주스, 파인애플 주스, 크랜베리 주스를 순서대로 추가한 다음 섞어줍니다.\n" +
                "3. 소다수를 천천히 부어줍니다.\n" +
                "4. 잘 섞어준 후, 레몬, 라임, 오렌지 조각이나 체리같은 과일을 장식으로 넣어 완성합니다.", "https://www.thecocktaildb.com/images/media/drink/i3tfn31484430499.jpg");
        cocktailRepository.save(프룻쿨러);
        Tag 시원한 = new Tag("시원한");
        Tag 청량한 = new Tag("청량한");
        tagRepository.save(시원한);
        tagRepository.save(청량한);
        cocktailTagRepository.save(new CocktailTag(프룻쿨러, 시원한));
        cocktailTagRepository.save(new CocktailTag(프룻쿨러, 청량한));
        ingredientCocktailRepository.save(new IngredientCocktail(오렌지주스, 프룻쿨러, "1/2컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(파인애플주스, 프룻쿨러, "1/2컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(소다수, 프룻쿨러, "1/2컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(크랜베리주스, 프룻쿨러, "1/2컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(얼음, 프룻쿨러, "1컵"));
    }
}

