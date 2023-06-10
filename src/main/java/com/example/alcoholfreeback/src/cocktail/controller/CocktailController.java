package com.example.alcoholfreeback.src.cocktail.controller;

import com.example.alcoholfreeback.common.response.BaseResponse;
import com.example.alcoholfreeback.src.cocktail.model.CocktailDetailDto;
import com.example.alcoholfreeback.src.cocktail.model.CocktailDto;
import com.example.alcoholfreeback.src.cocktail.model.CocktailIdDto;
import com.example.alcoholfreeback.src.cocktail.model.CocktailSearchCond;
import com.example.alcoholfreeback.src.cocktail.service.CocktailService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = {"칵테일 API"})
@RequestMapping("/app/cocktail")
public class CocktailController {

    private final CocktailService cocktailService;

    @ApiOperation(
            value = "칵테일 전체 조회(인기순)",
            notes = "조회수가 높은 칵테일 순으로 전체 칵테일을 반환"
    )
    @GetMapping("/")
    public BaseResponse<List<CocktailDto>> getAllCocktails() {
        return new BaseResponse<>(cocktailService.getPopularCocktails());
    }

    @ApiOperation(
            value = "태그와 재료를 기반으로 칵테일 조회",
            notes = "선택한 태그와 재료의 이름을 포함하는 칵테일 조회"
    )
    @PostMapping("/search")
    public BaseResponse<List<CocktailDto>> getCocktailsByCond(@RequestBody CocktailSearchCond cond) {
        return new BaseResponse<>(cocktailService.getCocktailByCond(cond));
    }

    @ApiOperation(
            value = "특정 칵테일 상세 조회",
            notes = "특정 칵테일을 클릭 시 상세 조회"
    )
    @ApiResponses({
            @ApiResponse(code = 404, message = "해당 프로젝트가 존재하지 않습니다.")
    })
    @GetMapping("/{cocktail_id}")
    public BaseResponse<CocktailDetailDto> getCocktail(@PathVariable("cocktail_id") Long id) {
        return new BaseResponse<>(cocktailService.getCocktailDetail(id));
    }

    @ApiOperation(
            value = "찜목록 칵테일 조회",
            notes = "찜목록(나의 레시피)에 있는 칵테일 조회"
    )
    @GetMapping("/{cocktail_id}")
    public BaseResponse<List<CocktailDto>> getMyCocktails(@RequestBody CocktailIdDto cocktailIdDto) {
        return new BaseResponse<>(cocktailService.getMyCocktails(cocktailIdDto.getCocktailIds()));
    }
}
