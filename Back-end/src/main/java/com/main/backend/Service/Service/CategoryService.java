package com.main.backend.Service.Service;

import com.main.backend.Domain.Dto.Categories.CategoryDto;
import com.main.backend.Domain.Dto.Categories.CreateUpdateCategoryDto;
import com.main.backend.Domain.Model.Categories.Category;
import com.main.backend.Repository.CategoryRepository;
import com.main.backend.Service.IService.ICategoryService;
import com.main.backend.Utils.Exception.ErrorCode;
import com.main.backend.Utils.Exception.HandleRuntimeException;
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
        return CategoryMapper.toCategoryDto(categoryRepository.findById(id).orElseThrow(()->new HandleRuntimeException(ErrorCode.CATEGORY_NOT_FOUND)));
    }

    @Override
    public CategoryDto updateCategory(UUID id, CreateUpdateCategoryDto input) {
        Category category = categoryRepository.findById(id).orElseThrow(()->new HandleRuntimeException(ErrorCode.CATEGORY_NOT_FOUND));
        category.setName(input.getName());
        category.setParentId(input.getParentId());
        category.setIsActive(input.getIsActive());
        categoryRepository.save(category);
        return CategoryMapper.toCategoryDto(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new HandleRuntimeException(ErrorCode.CATEGORY_NOT_FOUND));
        if (category.getParentId() == null) {
            categoryRepository.delete(category);
        } else {
            deleteChildCategory(id);
        }
    }

    public void deleteChildCategory(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new HandleRuntimeException(ErrorCode.CATEGORY_NOT_FOUND));
        if (category.getParentId() == null) {
            categoryRepository.delete(category);
        } else {
            List<Category> categories = categoryRepository.findAllByParentId(id);
            for (Category category1 : categories) {
                categoryRepository.delete(category1);
            }
            categoryRepository.delete(category);
        }
    }
}
