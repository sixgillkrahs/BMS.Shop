package com.main.backend.Service.IService;

import com.main.backend.Domain.Dto.Categories.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ICategoryService {

    public List<CategoryDto> getAllCategory();
    public CategoryDto saveCategory(CategoryDto input);
    public CategoryDto getCategoryById(UUID id);
    public CategoryDto updateCategory(UUID id, CategoryDto input);
    public void deleteCategory(UUID id);

}
