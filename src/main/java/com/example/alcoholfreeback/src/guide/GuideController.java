package com.example.alcoholfreeback.src.guide;

import com.example.alcoholfreeback.common.exceptions.BaseException;
import com.example.alcoholfreeback.common.response.BaseResponse;
import com.example.alcoholfreeback.src.guide.dto.IngredientResponseDto;
import com.example.alcoholfreeback.src.guide.dto.ToolResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/guide")
public class GuideController {
    private final GuideService guideService;

    @GetMapping("/tool")
    public BaseResponse<List<ToolResponseDto>> getToolList() {
        try {
            List<ToolResponseDto> responseDtos = guideService.allTools();
            return new BaseResponse(responseDtos);
        } catch (BaseException baseException) {
            return new BaseResponse<>(baseException.getStatus());
        }
    }

    @GetMapping("/tool/{tool_id}")
    public BaseResponse<ToolResponseDto> getOneTool(@PathVariable Long tool_id) {
        try {
            ToolResponseDto responseDto = guideService.oneTool(tool_id);
            return new BaseResponse(responseDto);
        } catch (BaseException baseException) {
            return new BaseResponse<>(baseException.getStatus());
        }
    }

    @GetMapping("/ingredient")
    public BaseResponse<List<IngredientResponseDto>> getIngredientlList() {
        try {
            List<IngredientResponseDto> responseDtos = guideService.allIngredients();
            return new BaseResponse(responseDtos);
        } catch (BaseException baseException) {
            return new BaseResponse<>(baseException.getStatus());
        }
    }

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
