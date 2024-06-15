package com.main.backend.Controller;


import com.main.backend.Domain.APIRepository;
import com.main.backend.Domain.Dto.Categories.CategoryDto;
import com.main.backend.Domain.Dto.Categories.CreateUpdateCategoryDto;
import com.main.backend.Service.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
