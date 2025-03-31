package com.example.E_commerce.DTO;

import java.util.List;

import com.example.E_commerce.entity.Product;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

	String type;
	
	@OneToMany
	private List<Product> productList;
}
