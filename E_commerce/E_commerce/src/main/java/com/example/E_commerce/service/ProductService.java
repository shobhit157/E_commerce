package com.example.E_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E_commerce.entity.Product;
import com.example.E_commerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product updateProduct(Long id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		
	}

}
