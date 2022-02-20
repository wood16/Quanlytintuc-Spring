package com.example.springboot.service;

import com.example.springboot.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> findAll();
    CategoryDTO findById(Long id);
    CategoryDTO findByCode(String code);
    CategoryDTO save(CategoryDTO categoryDTO);
    void deleteById(Long id);
}
