package com.example.E_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.entity.Product;
import com.example.E_commerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;
//	a. GET /api/products: Retrieve all the products
//	b. GET /api/products/{id}: Retrieve a specific product. Provide the
//	product ID as a path variable.
//	c. GET /api/products/{categoryId}: Retrieve all the specific products
//	belonging to a particular category by categoryId.
//	d. GET /api/products/{categoryName}: Retrieve all the specific
//	products belonging to a particular category by category name.
//	e. POST /api/products: Create a new product
//	f. PUT /api/products/{id}: Update an existing product.
//	g. DELETE /api/products/{id}: Delete a product. Provide the product ID as a
//	path variable.
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
	   Product savedProduct = productService.saveProduct(product);
	   return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) 
	{
	  Product updatedProduct = productService.updateProduct(id, product);
	   if (updatedProduct != null) {
	         return ResponseEntity.ok(updatedProduct);
	      }
	   return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
	    productService.deleteProduct(id);
	   return ResponseEntity.noContent().build();
	}


}
