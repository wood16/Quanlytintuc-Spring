package com.example.springboot.api;

import com.example.springboot.dto.CategoryDTO;
import com.example.springboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping(path = "/api/category", produces = "application/json")
public class CategoryAPI {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategoryDTO(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public  CategoryDTO getCategoryDTOById(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO putCategoryDTO(
            @RequestBody CategoryDTO categoryDTO){
        return categoryService.save(categoryDTO);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO postCategoryDTO(@RequestBody CategoryDTO categoryDTO){
        return categoryService.save(categoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryDTOById(@PathVariable("id") Long id){
        categoryService.deleteById(id);
    }

}
