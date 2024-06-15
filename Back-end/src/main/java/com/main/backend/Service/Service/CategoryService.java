package com.main.backend.Service.Service;

import com.main.backend.Domain.Dto.Categories.CategoryDto;
import com.main.backend.Domain.Dto.Categories.CreateUpdateCategoryDto;
import com.main.backend.Domain.Model.Categories.Category;
import com.main.backend.Repository.CategoryRepository;
import com.main.backend.Service.IService.ICategoryService;
import com.main.backend.Utils.Mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CategoryService implements ICategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategory() {
        List<CategoryDto> categoriesDto = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            categoriesDto.add(CategoryMapper.toCategoryDto(category));
        }
        return categoriesDto;
    }

    @Override
    public CategoryDto saveCategory(CreateUpdateCategoryDto input) {
        categoryRepository.existsByName(input.getName());
        Category category = new Category(input.getName(),input.getParentId(),input.getIsActive());
        categoryRepository.save(category);
        return CategoryMapper.toCategoryDto(category);
    }

    @Override
    public CategoryDto getCategoryById(UUID id) {
        return null;
    }

    @Override
    public CategoryDto updateCategory(UUID id, CreateUpdateCategoryDto input) {
        return null;
    }

    @Override
    public void deleteCategory(UUID id) {

    }
}
