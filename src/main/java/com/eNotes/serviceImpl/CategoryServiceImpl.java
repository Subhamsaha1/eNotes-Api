package com.eNotes.serviceImpl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.eNotes.DTO.CategoryDto;
import com.eNotes.DTO.CategoryResponse;
import com.eNotes.entity.Category;
import com.eNotes.repository.CategoryRepository;
import com.eNotes.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Boolean saveCategory(CategoryDto categoryDto) {

//		Category category = new Category();
//		category.setName(categoryDto.getName());
//		category.setDescription(categoryDto.getDescription());
//		category.setIsActive(categoryDto.getIsActive());
		 Category category = mapper.map(categoryDto, Category.class);
		    category.setIsDeleted(false);

		    // Ensure the 'created_by' field is set in the Category entity.
		    category.setCreatedBy(1);  // Assuming '1' is the logged-in user or relevant user ID.
		    category.setCreatedOn(new Date());  // Set the current timestamp for 'created_on'.
		    
		    // Now save the category entity
		    Category savedCategory = categoryRepo.save(category);
		    
		    if (ObjectUtils.isEmpty(savedCategory)) {
		        return false;
		    }
		    return true;
		}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = categoryRepo.findAll();
		
		List<CategoryDto> categoryDtoList = categories.stream().map(cat->mapper.map(cat, CategoryDto.class)).toList();
		
		return categoryDtoList;
	}

	@Override
	public List<CategoryResponse> getActiveCategory() {

		List<Category> categories = categoryRepo.findByIsActiveTrue();
		List<CategoryResponse> categoryList = categories.stream().map(cat->mapper.map(cat, CategoryResponse.class))
		.toList();
		return categoryList;
	}

}
