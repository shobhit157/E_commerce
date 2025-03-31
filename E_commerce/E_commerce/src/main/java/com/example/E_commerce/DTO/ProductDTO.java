package com.example.E_commerce.DTO;

import com.example.E_commerce.entity.Category;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	private String name;
	private double price;
	private String description;
	
	@ManyToOne
	private Category category;

}
