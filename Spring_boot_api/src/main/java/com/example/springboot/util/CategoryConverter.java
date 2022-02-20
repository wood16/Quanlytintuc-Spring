package com.example.springboot.util;

import com.example.springboot.dto.CategoryDTO;
import com.example.springboot.entity.CategoryEntity;
import org.springframework.stereotype.Component;


@Component
public class CategoryConverter {

    public CategoryDTO toDTO(CategoryEntity categoryEntity){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setNameCategory(categoryEntity.getNameCategory());
        categoryDTO.setCode(categoryEntity.getCode());
        categoryDTO.setDescription(categoryEntity.getDescription());
        return categoryDTO;
    }

    public CategoryEntity toEntity(CategoryDTO categoryDTO){
        CategoryEntity categoryEntity = new CategoryEntity();
        if(categoryDTO.getId() != null){
            categoryEntity.setId(categoryDTO.getId());
        }
        categoryEntity.setNameCategory(categoryDTO.getNameCategory());
        categoryEntity.setCode(categoryDTO.getCode());
        categoryEntity.setDescription(categoryDTO.getDescription());
        return categoryEntity;
    }

}
