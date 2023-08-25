package com.blog.api.services;

import com.blog.api.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    public CategoryDto createCategory(CategoryDto categoryDto);
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);
    public CategoryDto getCategoryById(Long categoryId);
    public void deleteCategory(Long categoryId);
    public List<CategoryDto> getAllCategory();



}
