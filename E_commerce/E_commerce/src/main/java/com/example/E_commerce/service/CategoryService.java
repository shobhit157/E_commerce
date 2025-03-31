package com.example.E_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E_commerce.DTO.CategoryDTO;
import com.example.E_commerce.entity.Category;
import com.example.E_commerce.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	public void createCategory(CategoryDTO categoryDto) {
		// TODO Auto-generated method stub
		Category category=new Category();
		category.setType(categoryDto.getType());
		categoryRepository.save(category);
	}

	public CategoryDTO getCategoryById(Long id) {
		// TODO Auto-generated method stub
		CategoryDTO categoryDto=new CategoryDTO();
		Category category=categoryRepository.findById(id).get();
		categoryDto.setType(category.getType());
		return categoryDto;
	}

	public void updateCategoryById(Long id) {
		// TODO Auto-generated method stub
		Category category=categoryRepository.findById(id).get();
		// make changes to category
		categoryRepository.save(category);
		
	}

	public void deleteCategoryById(Long id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
		
	}
	
	

}
