package com.example.E_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.DTO.CartItemRequest;
import com.example.E_commerce.DTO.CartItemResponseDTO;
import com.example.E_commerce.DTO.CartResponseDTO;
import com.example.E_commerce.DTO.ProductDTO;
import com.example.E_commerce.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
//	a. POST /cart/add: Create a new cart.
//	b. GET /cart/get: Retrieve a cart by ID.
//	c. PUT /cart/update/{cartItemId}: Update a cart.
//	d. DELETE /cart/delete/{cartItemId}: Delete a cart

	@PostMapping("/add")
	public ResponseEntity<Long> addCart( @RequestHeader("userId") Integer userid,@RequestHeader("Authorization") String token)
	{
		Long e_id=cartService.addCart(userid,token);
		return ResponseEntity.ok(e_id);
	}
	
	@GetMapping("/get")
	public ResponseEntity<CartResponseDTO> getCartById(@RequestHeader("userId") Integer userid)
	{
		CartResponseDTO cartResponse=cartService.getCartById(userid);
		return ResponseEntity.ok(cartResponse);
	}
	
	@PutMapping("/update")
	public ResponseEntity updateCart(@RequestBody CartItemRequest cartItemRequest,@RequestHeader("userId") Integer userid)
	{
		cartService.updateCart(cartItemRequest,userid);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity deleteCartItem(@RequestBody CartItemRequest cartItemRequest )
	{
		cartService.deleteCartItem(cartItemRequest);
		return ResponseEntity.ok().build();
	}
	
    @PostMapping("/add/item")
    public ResponseEntity<CartItemResponseDTO> addItemsToCart(@RequestBody CartItemRequest cartItemRequest)
    {
    	CartItemResponseDTO cartItemResponse=cartService.addItemsToCart(cartItemRequest);
    	return ResponseEntity.ok(cartItemResponse);
    }
    
    @PutMapping("/update/cart_item/{userid}")
    public ResponseEntity<CartResponseDTO> updateItemInCart(@RequestBody CartItemRequest cartItemRequest )
    {
    	CartResponseDTO cartResponse=cartService.updateItemsInCart(cartItemRequest);
    	return ResponseEntity.ok(cartResponse);
    }
}