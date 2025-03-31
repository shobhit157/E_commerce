package com.example.E_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.DTO.CategoryDTO;
import com.example.E_commerce.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
//	POST /categories: Create a new category.
//	b. GET /categories/{id}: Retrieve a category by ID.
//	c. GET /categories: Retrieve all categories.
//	d. PUT /categories/{id}: Update a category.
//	e. DELETE /categories/{id}: Delete a category
	
	@PostMapping
	public void createCategory(@RequestBody CategoryDTO categoryDto)
	{
		categoryService.createCategory(categoryDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id)
	{
		CategoryDTO categoryDto=categoryService.getCategoryById(id);
		return ResponseEntity.ok(categoryDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity updateCategoryById(@PathVariable Long id)
	{
		categoryService.updateCategoryById(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteCategoryById(@PathVariable Long id)
	{
		categoryService.deleteCategoryById(id);
		return ResponseEntity.ok().build();
	}

}
