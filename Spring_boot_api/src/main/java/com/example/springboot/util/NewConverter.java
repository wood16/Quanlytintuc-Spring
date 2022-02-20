package com.example.springboot.util;

import com.example.springboot.dto.CommentDTO;
import com.example.springboot.dto.NewsDTO;
import com.example.springboot.entity.CategoryEntity;
import com.example.springboot.entity.CommentEntity;
import com.example.springboot.entity.NewsEntity;
import com.example.springboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewConverter {

    @Autowired
    private CommentConverter commentConverter;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private CategoryConverter categoryConverter;

    public NewsDTO toDto(NewsEntity newsEntity){
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(newsEntity.getId());
        newsDTO.setCategoryCode(newsEntity.getCategory().getCode());
        newsDTO.setContent(newsEntity.getContent());
        List<CommentDTO> listCommentDTO = new ArrayList<>();
        if(newsEntity.getComments() != null){
            for(CommentEntity item : newsEntity.getComments()){
                listCommentDTO.add(commentConverter.toDTO(item));
            }
        }
        newsDTO.setComments(listCommentDTO);
        newsDTO.setThumbnail(newsEntity.getThumbnail());
        newsDTO.setTitle(newsEntity.getTitle());
        newsDTO.setShortDescription(newsEntity.getShortDescription());

        newsDTO.setCreatedBy(newsEntity.getCreateBy());
        newsDTO.setCreatedDate(newsEntity.getCreateDate());
        newsDTO.setModifiedBy(newsEntity.getModifiedBy());
        newsDTO.setModifiedDate(newsEntity.getModifiedDate());
        return newsDTO;
    }

    public NewsEntity toEntity(NewsDTO newsDTO){
        NewsEntity newsEntity = new NewsEntity();
        if(newsDTO.getId() != null){
            newsEntity.setId(newsDTO.getId());
        }
        newsEntity.setContent(newsDTO.getContent());
        if(newsDTO.getThumbnail() != null){
            newsEntity.setThumbnail(newsDTO.getThumbnail());
        }
        newsEntity.setTitle(newsDTO.getTitle());
        newsEntity.setShortDescription(newsDTO.getShortDescription());
        CategoryEntity categoryEntity =  categoryConverter.toEntity(categoryService.findByCode(newsDTO.getCategoryCode()));
        newsEntity.setCategory(categoryEntity);
        return newsEntity;
    }
}
