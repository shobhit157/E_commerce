package com.example.E_commerce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E_commerce.entity.Category;
import com.example.E_commerce.entity.Product;
import com.example.E_commerce.repository.CategoryRepository;

@Service
public class HomeService {

	
	@Autowired
	CategoryRepository categoryRepository;

	public Map<String, List<Product>> getAllProductsByCategory() {
		// TODO Auto-generated method stub
		List<Category> categoryList=categoryRepository.findAll();
		Map<String , List<Product>> productsByCategory=new HashMap<>();
		
		for(Category c: categoryList)
		{
			productsByCategory.put(c.getType(), c.getProductList());
			
		}
		return productsByCategory;
	}

	public Map<String, List<Product>> searchProduct(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
