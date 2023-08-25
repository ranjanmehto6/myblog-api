package com.blog.api.services;

import com.blog.api.entities.Category;
import com.blog.api.exception.ResourceNotFoundException;
import com.blog.api.payload.CategoryDto;
import com.blog.api.repositries.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;




    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.mapToCategory(categoryDto);
        Category save = this.categoryRepo.save(category);
        CategoryDto categoryDto1 = this.mapToDto(save);
        return categoryDto1;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "category Id", categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        CategoryDto categoryDto1 = this.mapToDto(category);
        return categoryDto1;
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {

    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return null;
    }

    public Category mapToCategory(CategoryDto categoryDto){
        return modelMapper.map(categoryDto, Category.class);
    }

    public CategoryDto mapToDto(Category category){
        return modelMapper.map(category,CategoryDto.class);
    }
}
