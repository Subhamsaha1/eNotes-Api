package com.eNotes.service;

import java.util.List;

import com.eNotes.DTO.CategoryDto;
import com.eNotes.DTO.CategoryResponse;
import com.eNotes.entity.Category;

public interface CategoryService {

	public Boolean saveCategory(CategoryDto categoryDto);

	public List<CategoryDto> getAllCategory();

	public List<CategoryResponse> getActiveCategory();

}
