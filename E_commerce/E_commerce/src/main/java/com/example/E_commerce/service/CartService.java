package com.example.E_commerce.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E_commerce.DTO.CartItemRequest;
import com.example.E_commerce.DTO.CartItemResponseDTO;
import com.example.E_commerce.DTO.CartResponseDTO;
import com.example.E_commerce.DTO.ProductDTO;
import com.example.E_commerce.DTO.UserDTO;
import com.example.E_commerce.UserServiceClient.UserServiceClient;
import com.example.E_commerce.entity.Cart;
import com.example.E_commerce.entity.CartItem;
import com.example.E_commerce.entity.Product;
import com.example.E_commerce.entity.User;
import com.example.E_commerce.repository.CartRepository;
import com.example.E_commerce.repository.ProductRepository;
import com.example.E_commerce.repository.UserRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	UserServiceClient userServiceClient;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;

	public Long addCart(Integer userid,String jwtToken) {
		// TODO Auto-generated method stub
		Long userId=Long.valueOf(userid);
		UserDTO userDto=userServiceClient.getUserDetails(userId, jwtToken.substring(7));
		
		Cart cart=new Cart();
		User user=new User();
		
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setUsername(userDto.getUsername());
		
		cart.setUser(user);
		user.setCart(cart);
		
		cartRepository.save(cart);
		userRepository.save(user);
	
		return user.getId();
		
	}

	public CartResponseDTO getCartById(Integer userid) {
		// TODO Auto-generated method stub
		Long userId=Long.valueOf(userid);
		User user=userRepository.findById(userId).get();
		Cart cart=user.getCart();
		CartResponseDTO cartResponseDto =new CartResponseDTO();
		cartResponseDto.setTotalPrice(cart.getTotalPrice());
		cartResponseDto.setUser(cart.getUser());
		cartResponseDto.setItems(cart.getItems());
		
		
		return cartResponseDto;
		
	}

	public void updateCart(CartItemRequest cartItemRequest, Integer userid) {
		// TODO Auto-generated method stub
		Cart cart=cartRepository.findById(cartItemRequest.getCartId()).get();
		for(CartItem ci:cart.getItems())
		{
			if(ci.getProduct().getId().equals(cartItemRequest.getProductId()))
			{
				ci.setQuantity(cartItemRequest.getQuantity());
				
			}
			
		}
		cartRepository.save(cart);
	}

	public void deleteCartItem(CartItemRequest cartItemRequest) {
		// TODO Auto-generated method stub
//		Long userId=Long.valueOf(userid);
//		User user=userRepository.findById(userId).get();
//	    Cart cart=user.getCart();
//	    cartRepository.deleteById(cart.getId());
		Cart cart=cartRepository.findById(cartItemRequest.getCartId()).get();
		for(CartItem ci: cart.getItems())
		{
			if(ci.getProduct().getId().equals(cartItemRequest.getProductId()))
			{
				cart.getItems().remove(ci);
			}
		}
		cartRepository.save(cart);
	    
		
	}

	public CartItemResponseDTO addItemsToCart(CartItemRequest cartItemRequest) {
		// TODO Auto-generated method stub
		
		Cart cart=cartRepository.findById(cartItemRequest.getCartId()).get();
		Product product=productRepository.findById(cartItemRequest.getProductId()).get();
		
		
		CartItem cartItem=new CartItem(); 
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setQuantity(cartItemRequest.getQuantity());
		Double total_p_price=product.getPrice()*cartItemRequest.getQuantity();
		BigDecimal p_price=BigDecimal.valueOf(total_p_price);
		cartItem.setPrice(p_price);
		
		cart.getItems().add(cartItem);
		
		BigDecimal total_p=cart.getTotalPrice().add(p_price);
		
		cart.setTotalPrice(total_p);
		
		ProductDTO productDto=new ProductDTO();
		productDto.setDescription(product.getDescription());
		productDto.setName(product.getName());
		productDto.setCategory(product.getCategory());
		productDto.setPrice(product.getPrice());
		CartItemResponseDTO cartItemDto=new CartItemResponseDTO();
		cartItemDto.setPrice(p_price);
		cartItemDto.setProductId(cartItemRequest.getProductId());
		cartItemDto.setCartId(cartItemRequest.getCartId());
		cartItemDto.setQuantity(cartItemRequest.getQuantity());
		cartItemDto.setUserId(cartItemRequest.getUserId());
		cartItemDto.setProduct(productDto);
		
		cartRepository.save(cart);
		return cartItemDto;
		
	}
	
	public List<CartItem> getCartItems(User user)
	{
		Cart cart=user.getCart();
		return cart.getItems();
	}

	public CartResponseDTO updateItemsInCart(CartItemRequest cartItemRequest) {
		// TODO Auto-generated method stub
		Cart cart=cartRepository.findById(cartItemRequest.getCartId()).get();
		List<CartItem> items=cart.getItems();
		int i=0;
		for(CartItem ci:items)
		{
			if(ci.getProduct().getId().equals(cartItemRequest.getProductId()))
			{
				Product updateProduct=productRepository.findById(cartItemRequest.getUpdate_productId()).get();
				
				ci.setQuantity(cartItemRequest.getUpdate_quantity());
				Double ci_price=updateProduct.getPrice()*cartItemRequest.getUpdate_quantity();
				BigDecimal update_ci_price=BigDecimal.valueOf(ci_price);
				ci.setPrice(update_ci_price);
				ci.setProduct(updateProduct);
				break;
			}
			i++;
		}
		
		cartRepository.save(cart);
		CartResponseDTO cartResponseDto=new CartResponseDTO();
		
	    cartResponseDto.setItems(cart.getItems());
	    cartResponseDto.setTotalPrice(cart.getTotalPrice());
	    cartResponseDto.setUser(cart.getUser());
	    
		
		return cartResponseDto;
	}

	

}
