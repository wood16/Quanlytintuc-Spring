package com.example.springboot.service.impl;

import com.example.springboot.dto.CategoryDTO;
import com.example.springboot.entity.CategoryEntity;
import com.example.springboot.repository.CategoryRepository;
import com.example.springboot.service.ICategoryService;
import com.example.springboot.util.CategoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryEntity> list = categoryRepository.findAll();
        List<CategoryDTO> listDTO = new ArrayList<>();
        for(CategoryEntity item : list){
            listDTO.add(categoryConverter.toDTO(item));
        }
        return listDTO;
    }

    @Override
    public CategoryDTO findById(Long id) {
        Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);
        if(categoryEntity.isPresent()){
            return categoryConverter.toDTO(categoryEntity.get());
        }
        return null;
    }

    @Override
    public CategoryDTO findByCode(String code) {
        CategoryEntity categoryEntity = categoryRepository.findCategoryEntityByCode(code);
        return categoryConverter.toDTO(categoryEntity);
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryConverter.toEntity(categoryDTO);
        return categoryConverter.toDTO(categoryRepository.save(categoryEntity));
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
