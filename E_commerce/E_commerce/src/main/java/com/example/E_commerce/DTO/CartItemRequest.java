package com.example.E_commerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemRequest {

	private Long cartId;
	private Long userId;
	private Long productId;
	private int quantity;
	private Long update_productId;
	private int update_quantity;
}
