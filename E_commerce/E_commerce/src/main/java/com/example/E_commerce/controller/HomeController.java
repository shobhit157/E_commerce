package com.example.E_commerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.entity.Category;
import com.example.E_commerce.entity.Product;
import com.example.E_commerce.service.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	
	@Autowired
	HomeService homeService;
	
//	 GET /home: Get all the products sorted by their categories in a
//	 Hashmap.
//	 b. GET /home/search: (String “Pattern” as a QueryParam): To Search
//	 products by their name and return them sorted by their categories in a
//	 Hashmap

	@GetMapping("/all")
	public Map<String,List<Product>> getAllProducts()
	{
		
		return homeService.getAllProductsByCategory();
		
	}
	
	@GetMapping("/search")
	public Map<String,List<Product>> searchProduct(@RequestParam String pattern)
	{
		return homeService.searchProduct(pattern);
	}
}
