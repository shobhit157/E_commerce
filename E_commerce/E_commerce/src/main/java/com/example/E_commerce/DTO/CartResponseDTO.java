package com.example.E_commerce.DTO;

import java.math.BigDecimal;


import java.util.List;

import com.example.E_commerce.entity.CartItem;
import com.example.E_commerce.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDTO {
	
	@OneToOne
	private User user;
	
	private BigDecimal totalPrice;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItem> items;

}
