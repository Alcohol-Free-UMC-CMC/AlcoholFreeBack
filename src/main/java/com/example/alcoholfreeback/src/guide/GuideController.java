package com.example.alcoholfreeback.src.guide;

import com.example.alcoholfreeback.common.exceptions.BaseException;
import com.example.alcoholfreeback.common.response.BaseResponse;
import com.example.alcoholfreeback.src.guide.dto.IngredientResponseDto;
import com.example.alcoholfreeback.src.guide.dto.ToolResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = {"가이드 조회 API"})
@RequestMapping("/app/guide")
public class GuideController {
    private final GuideService guideService;

    @ApiOperation(
            value = "도구 리스트 조회",
            notes = "모든 도구 리스트 조회"
    )
    @GetMapping("/tool")
    public BaseResponse<List<ToolResponseDto>> getToolList() {
        List<ToolResponseDto> responseDtos = guideService.allTools();
        return new BaseResponse(responseDtos);
    }

    @ApiOperation(
            value = "특정 도구 상세 조회",
            notes = "특정 도구를 클릭 시 상세 조회"
    )
    @ApiResponses({
            @ApiResponse(code = 204, message = "해당 도구가 존재하지 않습니다.")
    })
    @GetMapping("/tool/{tool_id}")
    public BaseResponse<ToolResponseDto> getOneTool(@PathVariable Long tool_id) {
        try {
            ToolResponseDto responseDto = guideService.oneTool(tool_id);
            return new BaseResponse(responseDto);
        } catch (BaseException baseException) {
            return new BaseResponse<>(baseException.getStatus());
        }
    }

    @ApiOperation(
            value = "재료 리스트 조회",
            notes = "모든 재료 리스트 조회"
    )
    @GetMapping("/ingredient")
    public BaseResponse<List<IngredientResponseDto>> getIngredientlList() {
        List<IngredientResponseDto> responseDtos = guideService.allIngredients();
        return new BaseResponse(responseDtos);
    }

    @ApiOperation(
            value = "특정 재료 상세 조회",
            notes = "특정 재료을 클릭 시 상세 조회"
    )
    @ApiResponses({
            @ApiResponse(code = 204, message = "해당 재료가 존재하지 않습니다.")
    })
    @GetMapping("/ingredient/{ingredient_id}")
    public BaseResponse<IngredientResponseDto> getOneIngredient(@PathVariable Long ingredient_id) {
        try {
            IngredientResponseDto responseDto = guideService.oneIngredient(ingredient_id);
            return new BaseResponse(responseDto);
        } catch (BaseException baseException) {
            return new BaseResponse<>(baseException.getStatus());
        }
    }


}
