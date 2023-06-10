package com.example.alcoholfreeback.src.cocktail.service;

import com.example.alcoholfreeback.common.exceptions.BaseException;
import com.example.alcoholfreeback.common.response.BaseResponseStatus;
import com.example.alcoholfreeback.src.cocktail.dto.TagNameResponseDto;
import com.example.alcoholfreeback.src.cocktail.entity.Tag;
import com.example.alcoholfreeback.src.cocktail.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class TagService {
    private final TagRepository tagRepository;

    public List<TagNameResponseDto> allTags() {
        List<Tag> tags = tagRepository.findAll();
        if (tags.isEmpty())
            throw new BaseException(BaseResponseStatus.EMPTY_LIST);
        return tags.stream().map(TagNameResponseDto::from).collect(Collectors.toList());
    }
}
