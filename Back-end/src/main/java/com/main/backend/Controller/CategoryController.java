package com.main.backend.Controller;


import com.main.backend.Domain.APIRepository;
import com.main.backend.Domain.Dto.Categories.CategoryDto;
import com.main.backend.Domain.Dto.Categories.CreateUpdateCategoryDto;
import com.main.backend.Service.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping("/all")
    public APIRepository<List<CategoryDto>> getAllCategory(){
        APIRepository<List<CategoryDto>> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(categoryService.getAllCategory());
        return repository;
    }

    @PostMapping("/save")
    public APIRepository<CategoryDto> saveCategory(@RequestBody CreateUpdateCategoryDto input){
        APIRepository<CategoryDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(categoryService.saveCategory(input));
        return repository;
    }

    @GetMapping("/get/{id}")
    public APIRepository<CategoryDto> getCategoryById(@PathVariable UUID id){
        APIRepository<CategoryDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(categoryService.getCategoryById(id));
        return repository;
    }

    @PutMapping("/update/{id}")
    public APIRepository<CategoryDto> updateCategory(@PathVariable UUID id, @RequestBody CreateUpdateCategoryDto input){
        APIRepository<CategoryDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(categoryService.updateCategory(id, input));
        return repository;
    }

    @DeleteMapping("/delete/{id}")
    public APIRepository<String> deleteCategory(@PathVariable UUID id){
        APIRepository<String> repository = new APIRepository<>();
        repository.setCode(1000);
        categoryService.deleteCategory(id);
        repository.setMessage("delete category successfully");
        return repository;
    }



}
