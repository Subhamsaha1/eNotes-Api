package com.eNotes.service;

import java.util.List;

import com.eNotes.entity.Category;

public interface CategoryService {

	public Boolean saveCategory(Category category);

	public List<Category> getAllCategory();

}
