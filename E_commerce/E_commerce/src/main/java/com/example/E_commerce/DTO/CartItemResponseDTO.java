package com.example.E_commerce.DTO;

import java.math.BigDecimal;
import java.util.List;

import org.apache.catalina.User;

import com.example.E_commerce.entity.CartItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemResponseDTO {
	
	private Long cartId;
	private Long userId;
	private Long productId;
	private int quantity;
	private BigDecimal price;
	private ProductDTO product;

}
