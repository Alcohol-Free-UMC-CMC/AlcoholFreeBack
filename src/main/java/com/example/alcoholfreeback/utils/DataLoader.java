package com.example.alcoholfreeback.utils;

import com.example.alcoholfreeback.src.cocktail.entity.*;
import com.example.alcoholfreeback.src.cocktail.repository.*;
import com.example.alcoholfreeback.src.guide.BaseIngredientRepository;
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
    private final BaseIngredientRepository baseIngredientRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Tool 코블러쉐이커 = new Tool("코블러 쉐이커", "캡+스트레이너(여과기)+바디의 3등분으로 구성되어 있습니다. 뚜껑이 있어 쉐이킹 후, 얼음이 스트레이너에서" +
                "걸러져나오는 형태의 쉐이커입니다. 거품을 많이 내는 칵테일에 주로 쓰입니다. 쉐이커 바디에 얼음을 1/2~1/3 정도 채우고 재료를 넣습니다. 바디, 스트레이너, 캡 순서대로 닫아줍니다." +
                " 캡을 마지막에 넣는 이유는 냉각으로 캡이 잘 열리지 않는 것을 최대한 방지할 수 있기 때문입니다. 한 쪽 엄지를 캡에 올리고, 다른 한 쪽의 검지와 중지는 바디 아래쪽을 댄 상태로 쉐이커를 고정합니다. " +
                "10~15초 간 쉐이킹을 합니다. 다만, 코블러 쉐이커는 얼음이 빨리 녹아 희석이 다른 쉐이커에 더 된다는 단점이 있습니다.",
                "thttps://i.imgur.com/o4B9HPe.png");

        Tool 보스턴쉐이커 = new Tool("보스턴 쉐이커", "코블러 쉐이커로도 대부분의 칵테일을 만들 수 있긴 하지만, 보스턴 쉐이커도 하나쯤은 구비하고 있는 것이 좋습니다. " +
                "용량이 큰 보온병이나 텀블러로 대체 가능하긴 하지만, 종종 크림이나 우유, 계란이 들어가는 칵테일을 만들 때는 꼭 필요한 도구입니다. " +
                "특히 계란을 사용하는 칵테일은 보온병으로 만들다가 터질 수 있는 가능성이 매우 큽니다. 안에 공기가 더욱 많이 들어가기 때문에 조금 더 부드로운 칵테일을 만들 수 있습니다.",
                "https://i.imgur.com/pDaJsz0.png");
        Tool 지거 = new Tool("지거", "정확한 계량을 위해 반드시 필요한 도구입니다. 산이 포함된 라임이나 레몬주스, 그리고 설탕시럽은 미세한 용량의 차이로도 맛을 크게 변화시키기에 홈텐딩에 빠질 수 없는 필수품입니다. " +
                "효율성을 중시한다면 내부 안쪽에 계량선이 있는 것을 추천합니다. 다만, 이 또한 소주잔으로 대체할 수 있습니다.",
                "https://i.imgur.com/IdYEw1F.png");

        Tool 바스푼 = new Tool("바 스푼", "바 스푼은 중간에 꼬여있는 부분의 견고함과 길이를 보고 고르는 것이 좋습니다. 스터 기법의 " +
                "마티니 스타일의 칵테일을 제조할 시에 손가락의 기술에 이용하여 칵테일을 만들기 때문에 가운데 꼬여있는 트위스트 부분이 얼마나 견고한지가 중요하기 때문입니다. " +
                "길이는 30~40cm 정도가 가장 적당합니다.",
                "https://i.imgur.com/B7R9KVA.png");

        Tool 믹싱글라스 = new Tool("믹싱 글라스", "쉽게 잘 섞이는 재료를 만들거나, 잔으로 직접 만들 수 없는 모양의 칵테일 잔을 쓸 때 사용합니다. 또한 얼음이 없는 시원한 칵테일을 만들 때도 유용합니다. 냉각이나 희석되는 정도를 " +
                "쉐이커보다 섬세하게 조절할 수 있습니다.",
                "https://i.imgur.com/0eCcQjn.png");
        toolRepository.save(코블러쉐이커);
        toolRepository.save(보스턴쉐이커);
        toolRepository.save(지거);
        toolRepository.save(바스푼);
        toolRepository.save(믹싱글라스);

        BaseIngredient lime = new BaseIngredient("라임 주스", "모히또에 빼놓을 수 없는 재료입니다. 2020년경 부터는 수입사들이 많아져서 남미, 베트남산 라임이 들어오기 때문에 웬만한 바에서 평균 1만~2만원 사이 라임베이스 칵테일에는 라임을 씁니다. 물론 냉동라임, 생라임 이렇게 들어오기 때문에 주문전에 한번 바텐더에게 물어보는 것도 좋습니다.", "https://i.imgur.com/ySaEpbi.jpg");
        BaseIngredient coconut_milk = new BaseIngredient("코코넛밀크", "코코넛 밀크는 무알콜 칵테일에 기분 좋은 열대성 트위스트를 더할 수 있는 크리미하고 풍부한 재료입니다. 무알코올 칵테일에 크리미한 질감과 열대 지방의 감촉을 선사하며, 그 맛을 풍부하게 하고 벨벳 같은 음주 경험을 만들어냅니다. 모든 한 모금에서 이국적인 맛을 제공하면서 광범위한 무알코올 칵테일 창작을 가능하게 합니다.", "https://i.imgur.com/T1s5MS9.jpg");
        BaseIngredient club_sodar = new BaseIngredient("클럽소다", "탄산수 또는 소다수로도 알려진 클럽 소다는 칵테일 분야에서 흔히 사용되는 성분입니다. 다양한 음료에 상쾌함과 거품의 요소를 더해주는 탄산이 맑은 음료입니다. 전반적으로 클럽 소다는 거품, 희석 및 기분 좋은 질감을 제공하여 칵테일에 활기차고 상쾌한 요소를 더합니다. 다양한 음료에 사용할 수 있는 다용도 믹서로 가볍고 발포성 있는 터치를 제공하여 전반적인 맛과 경험을 향상시킵니다.", "https://i.imgur.com/WaSHcII.jpg");
        BaseIngredient mint = new BaseIngredient("민트", "전반적으로 민트 잎은 칵테일에 밝고 상쾌한 요소를 추가하는 능력으로 높이 평가됩니다. 그들은 다양한 재료를 보완하는 시원한 허브 풍미와 향을 제공하여 믹솔로지스트와 칵테일 애호가 모두에게 인기 있는 선택이 됩니다.", "https://i.imgur.com/DemcfoJ.jpg");
        BaseIngredient pannel = new BaseIngredient("펜넬", "무알코올 칵테일에 초본 향과 약간 달콤한 향을 더해 전체적인 맛 경험에 깊이와 복합성을 부여합니다. 창의적인 조합을 탐색하고 시각적으로 매력적이고 맛있는 무알콜 목테일을 만들 수 있습니다.", "https://i.imgur.com/DemcfoJ.jpg");

        baseIngredientRepository.save(lime);
        baseIngredientRepository.save(coconut_milk);
        baseIngredientRepository.save(club_sodar);
        baseIngredientRepository.save(mint);
        baseIngredientRepository.save(pannel);


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

        Cocktail 스파이시_워터멜론_민트_아구아_프레스카 = new Cocktail("스파이시 워터멜론 민트 아구아 프레스카", "스파이시 워터멜론 민트 아구아 프레스카는 수박의 자연스러운 단맛과 민트의 시원함, 약간의 향신료가 어우러진 상쾌하고 상쾌한 음료입니다. 과즙이 풍부한 수박이 상쾌한 베이스를 제공하고 민트가 상쾌하고 향긋한 향을 더하는 완벽한 균형의 맛입니다. 카이엔 고추 또는 칠리 파우더의 미묘한 향신료가 음료에 유쾌한 열 요소를 추가합니다. 수분을 공급하고 풍미가 가득한 생동감 있고 갈증을 해소하는 음료입니다. 더운 날 또는 클래식한 아구아 프레스카에 독특한 트위스트로 즐겨보세요.", "1. 믹서기에 수박 큐브, 라임 주스, 신선한 민트 잎, 아가베 시럽 또는 꿀, 카이엔 고추 또는 칠리 파우더를 섞습니다.\n" +
                "2. 부드럽고 잘 섞일 때까지 사용합니다.\n" +
                "3. 혼합물을 맛보고 아가베 시럽/꿀 또는 고춧가루/칠리 파우더를 더 추가하여 기호에 따라 단맛 또는 매운맛을 조절하십시오.\n" +
                "4. 혼합물을 고운 체에 거르고 과육이나 씨를 제거합니다.\n" +
                "5. 거른 액체를 투수에 옮깁니다.\n" +
                "6. 서빙 잔에 얼음을 채웁니다.\n" +
                "7. 스파이시 워터멜론 민트 아구아 프레스카를 각 잔의 얼음 위에 붓습니다.\n" +
                "8. 신선한 민트 잎과 웨지 수박으로 장식합니다.\n" +
                "9. 부드럽게 저은 후 바로 서빙합니다.\n" +
                "10. 스파이시 수박 민트 아구아 프레스카의 상큼하고 매콤한 맛을 즐겨보세요!", "https://i.imgur.com/hiu6WH3.jpg");
        cocktailRepository.save(스파이시_워터멜론_민트_아구아_프레스카);
        Tag 매운 = new Tag("매운");
        Ingredient 수박 = new Ingredient("수박");
        Ingredient 라임_주스 = new Ingredient("라임 주스");
        Ingredient 민트_잎 = new Ingredient("민트 잎");
        Ingredient 할라피뇨 = new Ingredient("할라피뇨");
        tagRepository.save(매운);
        tagRepository.save(상큼한);
        ingredientRepository.save(수박);
        ingredientRepository.save(라임_주스);
        ingredientRepository.save(민트_잎);
        ingredientRepository.save(할라피뇨);
        cocktailTagRepository.save(new CocktailTag(스파이시_워터멜론_민트_아구아_프레스카, 매운));
        cocktailTagRepository.save(new CocktailTag(스파이시_워터멜론_민트_아구아_프레스카, 상큼한));
        ingredientCocktailRepository.save(new IngredientCocktail(수박, 스파이시_워터멜론_민트_아구아_프레스카, "4컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(라임_주스, 스파이시_워터멜론_민트_아구아_프레스카, "1/4컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(꿀, 스파이시_워터멜론_민트_아구아_프레스카, "꿀2큰술"));
        ingredientCocktailRepository.save(new IngredientCocktail(얼음, 스파이시_워터멜론_민트_아구아_프레스카, "적당량"));
        ingredientCocktailRepository.save(new IngredientCocktail(할라피뇨, 스파이시_워터멜론_민트_아구아_프레스카, "기호에 맞게"));

        Cocktail 망고뮬 = new Cocktail("망고뮬", "Mango Mule은 고전적인 Moscow Mule 칵테일의 유쾌하고 열대적인 변종입니다. 망고의 달콤함과 진저 비어의 스파이시함, 라임의 톡 쏘는 맛이 균형을 이룬 생동감 넘치는 트로피컬 칵테일입니다. 칵테일에서 과일 향과 약간 매운 맛을 즐기는 사람들을 위한 상쾌한 선택입니다. Mango Mule의 열대 지방의 장점을 음미하십시오!", "1. 칵테일 셰이커 또는 믹싱 글라스에 망고 퓨레 또는 주스, 보드카, 라임 주스를 섞습니다.\n" +
                "2. 재료가 잘 섞이도록 잘 흔들어 주세요.\n" +
                "3. 구리 머그나 하이볼 잔에 얼음을 채웁니다.\n" +
                "4. 망고 혼합물을 얼음 위에 걸러 유리잔에 따릅니다.\n" +
                "5. 진저비어를 위에 올려 장식할 공간을 남겨둡니다.\n" +
                "6. 맛이 잘 섞이도록 칵테일을 부드럽게 저어줍니다.\n" +
                "7. 선택적으로 시각적 매력을 더하기 위해 신선한 망고 슬라이스, 라임 휠 또는 민트 잔가지로 장식합니다.", "https://i.imgur.com/Ez9ziEc.jpg");
        cocktailRepository.save(망고뮬);
        tagRepository.save(달콤한);
        Ingredient 오이_슬라이스 = new Ingredient("오이 슬라이스");
        Ingredient 망고_주스 = new Ingredient("망고 주스");
        Ingredient 진저비어 = new Ingredient("진저비어");
        Ingredient 장식용_망고_슬라이스 = new Ingredient("장식용 망고 슬라이스");
        ingredientRepository.save(오이_슬라이스);
        ingredientRepository.save(망고_주스);
        ingredientRepository.save(진저비어);
        ingredientRepository.save(장식용_망고_슬라이스);

        cocktailTagRepository.save(new CocktailTag(망고뮬, 달콤한));
        ingredientCocktailRepository.save(new IngredientCocktail(오이_슬라이스, 망고뮬, "4개"));
        ingredientCocktailRepository.save(new IngredientCocktail(꿀, 망고뮬, "1온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(라임_주스, 망고뮬, "1온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(망고_주스, 망고뮬, "2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(얼음, 망고뮬, "적당량"));
        ingredientCocktailRepository.save(new IngredientCocktail(장식용_망고_슬라이스, 망고뮬, "1개"));

        Cocktail 시트러스_피즈 = new Cocktail("시트러스 피즈", "감귤류 과일의 생동감 있는 향과 탄산수 또는 클럽 소다의 기포가 결합된 상쾌하고 거품이 많은 칵테일입니다. 감귤류의 생동감 넘치는 풍미를 보여주는 상쾌하고 톡 쏘는 듯한 칵테일입니다. 거품이 일고 단맛과 신맛의 균형 잡힌 조합은 활력을 주고 풍미가 풍부한 음료를 찾는 사람들에게 탁월한 선택입니다. Citrus Fizz를 따뜻한 날 상쾌한 간식으로 즐기거나 칵테일 행사를 위한 활기 넘치는 옵션으로 즐겨보세요.", "1. 칵테일 셰이커에 얼음을 채웁니다.\n" +
                "2. 셰이커에 진저비어, 신선한 레몬 주스, 신선한 오렌지 주스, 슈가시럽을 넣습니다.\n" +
                "3. 혼합물을 힘차게 흔들어 풍미를 결합하고 재료를 식힙니다.\n" +
                "4. 얼음을 채운 하이볼 글라스에 혼합물을 걸러냅니다.\n" +
                "5. 클럽 소다 또는 탄산수로 잔을 채웁니다.\n" +
                "6. 칵테일을 부드럽게 저어 재료를 섞습니다.\n" +
                "7. 레몬 또는 오렌지 슬라이스로 장식합니다.\n" +
                "8. Citrus Fizz의 상쾌하고 시트러스 향을 서빙하고 즐기십시오!", "https://i.imgur.com/ILvcDh2.png");
        cocktailRepository.save(시트러스_피즈);
        Ingredient 레몬_주스 = new Ingredient("레몬 주스");
        Ingredient 시럽 = new Ingredient("시럽");
        Ingredient 클럽_소다 = new Ingredient("클럽 소다");
        Ingredient 탄산수 = new Ingredient("탄산수");
        Ingredient 장식용_레몬 = new Ingredient("장식용 레몬");
        ingredientRepository.save(레몬_주스);
        ingredientRepository.save(시럽);
        ingredientRepository.save(클럽_소다);
        ingredientRepository.save(탄산수);
        ingredientRepository.save(장식용_레몬);
        cocktailTagRepository.save(new CocktailTag(시트러스_피즈, 달콤한));
        cocktailTagRepository.save(new CocktailTag(시트러스_피즈, 상큼한));
        ingredientCocktailRepository.save(new IngredientCocktail(진저비어, 시트러스_피즈, "3/2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(레몬_주스, 시트러스_피즈, "1온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(오렌지주스, 시트러스_피즈, "1온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(시럽, 시트러스_피즈, "1/2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(클럽_소다, 시트러스_피즈, "기호에 맞게"));
        ingredientCocktailRepository.save(new IngredientCocktail(장식용_레몬, 시트러스_피즈, "1개"));

        Cocktail 매직_애플 = new Cocktail("매직 애플", "Magic Apple 무알코올 칵테일은 사과의 에센스를 마술적이고 매혹적인 방식으로 포착한 유쾌하고 상쾌한 음료입니다. 이 매혹적인 칵테일은 상큼한 시트러스 향과 사과의 달콤하고 아삭아삭한 맛이 어우러져 있습니다. 스파클링 워터를 얹어 은은한 거품을 선사합니다. 얼음과 함께 제공되는 이 마법의 영약은 생동감 있고 균형 잡힌 프로필로 입맛을 자극합니다. 즐겁고 매혹적인 음료를 찾는 사람들에게 완벽한 Magic Apple Cocktail은 한 모금 마실 때마다 풍미 가득한 마법을 선사합니다.", "1. 잔에 얼음을 채웁니다.\n" +
                "2. 유리잔에 사과 주스를 붓고 4분의 3 정도 채웁니다.\n" +
                "3. 유리잔에 신선한 라임 주스를 짜 넣습니다. 선호하는 산도에 따라 양을 조절하세요.\n" +
                "4. 원하는 경우 칵테일을 달게 하기 위해 간단한 시럽을 약간 추가합니다. 취향에 따라 양을 조절하세요.\n" +
                "5. 유리잔에 탄산수나 소다를 붓고 섞을 수 있도록 약간의 공간을 남겨둡니다.\n" +
                "모든 맛이 섞이도록 부드럽게 저어줍니다.\n" +
                "6. 선택적으로 시각적인 매력을 위해 라임 조각이나 사과 조각으로 장식합니다.", "https://i.imgur.com/RIBr6jn.jpg");
        cocktailRepository.save(매직_애플);
        Ingredient 사과_주스 = new Ingredient("사과 주스");
        Ingredient 레몬즙 = new Ingredient("레몬즙");
        Ingredient 장식용_사과_슬라이스 = new Ingredient("장식용 사과 슬라이스");
        ingredientRepository.save(사과_주스);
        ingredientRepository.save(레몬즙);
        ingredientRepository.save(장식용_사과_슬라이스);

        cocktailTagRepository.save(new CocktailTag(매직_애플, 청량한));
        ingredientCocktailRepository.save(new IngredientCocktail(사과_주스, 매직_애플, "4온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(레몬즙, 매직_애플, "1/2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(시럽, 매직_애플, "1/2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(탄산수, 매직_애플, "기호에 맞게"));
        ingredientCocktailRepository.save(new IngredientCocktail(얼음, 매직_애플, "적당량"));
        ingredientCocktailRepository.save(new IngredientCocktail(장식용_사과_슬라이스, 매직_애플, "1개"));

        Cocktail 베리_블레스크 = new Cocktail("베리 블레스크", "Berry Burlesque 칵테일은 다양한 베리들이 어우러진 새콤달콤한 맛으로 경쾌한 무드를 느끼게 해주는 칵테일입니다.", "1. 블랙베리 리큐어, 아몬드 시럽, 라즈베리 주스, 레몬 주스를 넣고 섞습니다.\n" +
                "2. 해당 혼합물을 탄산의 얼음이 담긴 글래스에 부어 줍니다.\n" +
                "3. 소다수를 천천히 부어 줍니다.\n" +
                "4. 글래스를 조심하며 섞어준 다음, 블랙베리와 라즈베리를 장식하여 완성합니다.", "https://i.imgur.com/1Fpzh9u.jpg");
        cocktailRepository.save(베리_블레스크);
        Tag 새콤달콤한 = new Tag("새콤달콤한");
        tagRepository.save(새콤달콤한);
        Ingredient 블랙베리_리큐어 = new Ingredient("블랙베리 리큐어");
        Ingredient 아몬드_시럽 = new Ingredient("아몬드 시럽");
        Ingredient 라즈베리_주스 = new Ingredient("라즈베리 주스");
        Ingredient 블랙_베리 = new Ingredient("블랙 베리");
        ingredientRepository.save(블랙베리_리큐어);
        ingredientRepository.save(아몬드_시럽);
        ingredientRepository.save(라즈베리_주스);
        ingredientRepository.save(블랙_베리);

        cocktailTagRepository.save(new CocktailTag(베리_블레스크, 새콤달콤한));
        cocktailTagRepository.save(new CocktailTag(베리_블레스크, 상쾌한));
        ingredientCocktailRepository.save(new IngredientCocktail(블랙베리_리큐어, 베리_블레스크, "1온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(아몬드_시럽, 베리_블레스크, "1/2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(라즈베리_주스, 베리_블레스크, "1/2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(레몬_주스, 베리_블레스크, "1/4온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(소다수, 베리_블레스크, "1/2컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(얼음, 베리_블레스크, "적당량"));
        ingredientCocktailRepository.save(new IngredientCocktail(블랙_베리, 베리_블레스크, "4개"));

        Cocktail 실리진저 = new Cocktail("실리 진저", "Shirley Ginger 칵테일은 진저 에일의 풍미와 약간의 석류즙 및 감귤류가 결합된 유쾌하고 상쾌한 무알코올 음료입니다.", "1. 잔에 얼음을 채웁니다.\n" +
                "2. 진저에일을 유리잔에 붓고 상단에 3. 약간의 공간을 남겨둡니다.\n" +
                "4. 진저에일에 그레나딘 시럽을 조금 넣습니다. 금액은 개인 취향에 따라 조정될 수 있습니다.\n" +
                "5. 신선한 레몬 또는 라임 주스를 짜서 맛보십시오. 소량으로 시작하여 선호하는 산도에 따라 조절하십시오.\n" +
                "6. 맛이 잘 섞이도록 부드럽게 저어줍니다.\n" +
                "7. 선택적으로 마라스키노 체리나 레몬 또는 라임 슬라이스로 장식합니다.", "https://i.imgur.com/yehMVLY.jpg");
        cocktailRepository.save(실리진저);
        Tag 알싸한 = new Tag("알싸한");
        tagRepository.save(알싸한);
        Ingredient 진저에일 = new Ingredient("진저에일");
        Ingredient 그레나딘_시럽 = new Ingredient("그레나딘 시럽");
        Ingredient  마라스키노_체리= new Ingredient("마라스키노 체리");
        ingredientRepository.save(진저에일);
        ingredientRepository.save(그레나딘_시럽);
        ingredientRepository.save(마라스키노_체리);
        cocktailTagRepository.save(new CocktailTag(실리진저, 알싸한));
        ingredientCocktailRepository.save(new IngredientCocktail(진저에일, 실리진저, "4온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(그레나딘_시럽, 실리진저, "1/2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(마라스키노_체리, 실리진저, "장식용"));
        ingredientCocktailRepository.save(new IngredientCocktail(라임_주스, 실리진저, "1/2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(얼음, 실리진저, "적당량"));

        Cocktail 와일드캣_쿨러 = new Cocktail("와일드캣 출러", "Wildcat Cooler 칵테일은 상큼하고 시원한 과일향이 돋보이는 칵테일로 더운 여름철에 즐겨 마시는 음료입니다. 시트러스, 베리, 진저에일의 풍미가 어우러진 유쾌하고 상쾌한 무알코올 칵테일입니다.", "1. 잔에 얼음을 채웁니다.\n" +
                "2. 잔에 크랜베리 \u200B\u200B주스를 붓고 4분의 3 정도 채웁니다.\n" +
                "3. 유리잔에 오렌지 주스를 조금 넣습니다. 시트러스 향에 대한 선호도에 따라 양을 조절하세요.\n" +
                "4. 원하는 경우 소량의 단순 시럽을 추가하여 칵테일을 달게 합니다. 티스푼으로 시작하여 취향에 따라 조절하세요.\n" +
                "5. 진저에일로 잔을 채우고 섞을 수 있도록 상단에 약간의 공간을 남겨 둡니다.\n" +
                "6. 모든 맛이 섞이도록 부드럽게 저어줍니다.\n" +
                "7. 필요에 따라 레몬 또는 라임 웨지로 칵테일을 장식합니다.", "https://i.imgur.com/MBX52KA.jpg");
        cocktailRepository.save(와일드캣_쿨러);

        cocktailTagRepository.save(new CocktailTag(와일드캣_쿨러, 상큼한));
        cocktailTagRepository.save(new CocktailTag(와일드캣_쿨러, 청량한));
        cocktailTagRepository.save(new CocktailTag(와일드캣_쿨러, 시원한));
        ingredientCocktailRepository.save(new IngredientCocktail(크랜베리주스, 와일드캣_쿨러, "2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(오렌지주스, 와일드캣_쿨러, "1온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(진저에일, 와일드캣_쿨러, "4온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(시럽, 와일드캣_쿨러, "1/2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(장식용_레몬, 와일드캣_쿨러, "1개"));

        Cocktail 시드립_스파이스_앤_토닉 = new Cocktail("시드립 스파이스 앤 토닉", "Seedlip Spice 94는 향긋한 향신료와 식물 성분을 혼합하여 만든 무알코올 증류주로, 클래식 진을 연상시키는 복합적인 풍미를 제공합니다. 토닉워터의 상큼함과 어우러져 상큼하고 세련된 음료로 언제든 즐길 수 있습니다. 유쾌하고 무알코올 칵테일 경험을 응원합니다!", "1. 잔에 얼음을 채웁니다.\n" +
                "2. 얼음 위에 Seedlip Spice 94를 붓습니다.\n" +
                "3. 잔에 프리미엄 토닉워터를 채웁니다. 음료의 강도에 대한 선호도에 따라 양을 조정하십시오.\n" +
                "4. 재료가 잘 섞이도록 부드럽게 저어줍니다.\n" +
                "5. 향과 풍미를 더하기 위해 약간의 오렌지 껍질이나 시나몬 스틱으로 장식합니다.\n" +
                "6. 세련되고 향긋한 Seedlip Spice & Tonic 칵테일을 서빙하고 즐기십시오!", "https://i.imgur.com/H2LDW5Z.png");
        cocktailRepository.save(시드립_스파이스_앤_토닉);
        Ingredient 시드립_스파이스_94 = new Ingredient("시드립 스파이스 94");
        Ingredient 토닉_워터 = new Ingredient("토닉워터");
        Ingredient 장식용_오렌지_껍질 = new Ingredient("장식용 오렌지 껍질");
        ingredientRepository.save(시드립_스파이스_94);
        ingredientRepository.save(토닉_워터);
        ingredientRepository.save(장식용_오렌지_껍질);
        ingredientRepository.save(얼음);
        cocktailTagRepository.save(new CocktailTag(시드립_스파이스_앤_토닉, 상큼한 ));
        ingredientCocktailRepository.save(new IngredientCocktail(시드립_스파이스_94, 시드립_스파이스_앤_토닉, "2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(토닉_워터, 시드립_스파이스_앤_토닉, "4~6온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(장식용_오렌지_껍질, 시드립_스파이스_앤_토닉, "적당량"));
        ingredientCocktailRepository.save(new IngredientCocktail(얼음, 시드립_스파이스_앤_토닉, "적당량"));


        Cocktail 버진_팔로마 = new Cocktail("버진 팔로마", "Virgin Paloma 칵테일은 전통적인 Paloma 칵테일에서 무알콜 버전으로 만들어진 음료로, 상큼한 자몽과 탄산이 어우러진 시원한 맛이 특징입니다.", "1. 칵테일 글래스 가장자리에 소금을 입혀둡니다.\n" +
                "2. 글래스에 얼음을 채워줍니다.\n" +
                "3. 자몽 주스, 라임 주스, 설탕 시럽을 글래스에 부어줍니다.\n" +
                "4. 소다수를 천천히 부어줍니다.\n" +
                "5. 음료를 부드럽게 젓어 섞어줍니다.\n" +
                "6. 라임 조각을 장식하여 완성합니다.", "https://i.imgur.com/QsZ1nJm.jpg");
        cocktailRepository.save(버진_팔로마);
        Ingredient 자몽_주스 = new Ingredient("자몽 주스");
        Ingredient 소금 = new Ingredient("소금");
        Ingredient 라임_조각 = new Ingredient("라임 조각");
        ingredientRepository.save(자몽_주스);
        ingredientRepository.save(소금);
        ingredientRepository.save(라임_조각);
        cocktailTagRepository.save(new CocktailTag(버진_팔로마, 상큼한));
        cocktailTagRepository.save(new CocktailTag(버진_팔로마, 시원한));
        cocktailTagRepository.save(new CocktailTag(버진_팔로마, 청량한));
        ingredientCocktailRepository.save(new IngredientCocktail(자몽_주스, 버진_팔로마, "3온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(라임_주스, 버진_팔로마, "1/2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(시럽, 버진_팔로마, "1/2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(소금, 버진_팔로마, "소량"));
        ingredientCocktailRepository.save(new IngredientCocktail(소다수, 버진_팔로마, "2온스"));
        ingredientCocktailRepository.save(new IngredientCocktail(얼음, 버진_팔로마, "적당량"));
        ingredientCocktailRepository.save(new IngredientCocktail(라임_조각, 버진_팔로마, "1개"));

        Cocktail 레몬그라스_자스민_아이스티 = new Cocktail("레몬그라스 자스민 아이스티", "Lemongrass Jasmine Iced Tea는 레몬그라스의 상큼함과 자스민 향이 어우러진 시원한 아이스 티 칵테일입니다. 이 음료는 여름철 갈증 해소와 에너지 회복에 도움이 되는 리프레싱한 음료로 인기가 있습니다.", "1. 끓인 물에 자스민 티 티백과 레몬그라스를 넣어, 녹차가 약 3분이 지나 진한 녹색티 색이 될 때까지 우려냅니다.\n" +
                "2. 티백과 레몬그라스를 건져 내고, 꿀 또는 설탕 시럽을 혼합액에 첨가하여 차 상태가 됩니다.\n" +
                "3. 음료가 실온까지 식도록 기다립니다.\n" +
                "4. 얼음이 잡힌 글래스에 음료를 부어주고, 레몬 처짐으로 완성합니다.", "https://i.imgur.com/bsPxgUq.jpg");
        cocktailRepository.save(레몬그라스_자스민_아이스티);
        Tag 향긋한 = new Tag("향긋한");
        tagRepository.save(향긋한);
        Ingredient 자스민_티 = new Ingredient("자스민 티");
        Ingredient 레몬그라스 = new Ingredient("레몬그라스");
        Ingredient 물 = new Ingredient("물");
        ingredientRepository.save(자스민_티);
        ingredientRepository.save(레몬그라스);
        ingredientRepository.save(물);
        cocktailTagRepository.save(new CocktailTag(레몬그라스_자스민_아이스티, 향긋한));
        cocktailTagRepository.save(new CocktailTag(레몬그라스_자스민_아이스티, 시원한));
        cocktailTagRepository.save(new CocktailTag(레몬그라스_자스민_아이스티, 상큼한));
        ingredientCocktailRepository.save(new IngredientCocktail(자스민_티, 레몬그라스_자스민_아이스티, "2티백"));
        ingredientCocktailRepository.save(new IngredientCocktail(레몬그라스, 레몬그라스_자스민_아이스티, "2조각"));
        ingredientCocktailRepository.save(new IngredientCocktail(물, 레몬그라스_자스민_아이스티, "1컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(얼음, 레몬그라스_자스민_아이스티, "1컵"));
        ingredientCocktailRepository.save(new IngredientCocktail(시럽, 레몬그라스_자스민_아이스티, "기호에 맞게"));
//
//        new Cocktail("", "", "", "");
//        cocktailRepository.save();
//        new Tag("");
//        new Tag("");
//        tagRepository.save();
//        tagRepository.save();
//        new Ingredient("");
//        ingredientRepository.save();
//        cocktailTagRepository.save(new CocktailTag(, ));
//        cocktailTagRepository.save(new CocktailTag(, ));
//        ingredientCocktailRepository.save(new IngredientCocktail(, , ""));
//        ingredientCocktailRepository.save(new IngredientCocktail(, , ""));
//        ingredientCocktailRepository.save(new IngredientCocktail(, , ""));
//        ingredientCocktailRepository.save(new IngredientCocktail(, , ""));
//        ingredientCocktailRepository.save(new IngredientCocktail(, , ""));
//
//        new Cocktail("", "", "", "");
//        cocktailRepository.save();
//        new Tag("");
//        new Tag("");
//        tagRepository.save();
//        tagRepository.save();
//        new Ingredient("");
//        ingredientRepository.save();
//        cocktailTagRepository.save(new CocktailTag(, ));
//        cocktailTagRepository.save(new CocktailTag(, ));
//        ingredientCocktailRepository.save(new IngredientCocktail(, , ""));
//        ingredientCocktailRepository.save(new IngredientCocktail(, , ""));
//        ingredientCocktailRepository.save(new IngredientCocktail(, , ""));
//        ingredientCocktailRepository.save(new IngredientCocktail(, , ""));
//        ingredientCocktailRepository.save(new IngredientCocktail(, , ""));


    }
}