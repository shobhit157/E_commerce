package com.example.E_commerce.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E_commerce.DTO.CartItemRequest;
import com.example.E_commerce.DTO.OrderRequestDTO;
import com.example.E_commerce.DTO.OrderResponse;
import com.example.E_commerce.entity.Cart;
import com.example.E_commerce.entity.CartItem;
import com.example.E_commerce.entity.Order;
import com.example.E_commerce.entity.OrderItem;
import com.example.E_commerce.entity.User;
import com.example.E_commerce.repository.OrderRepository;
import com.example.E_commerce.repository.UserRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CartService cartService;

	public OrderResponse getOrderById(Long id) {
		// TODO Auto-generated method stub
		Order order=orderRepository.findById(id).get();
		OrderResponse orderResponse=new OrderResponse();
		orderResponse.setAddress(order.getCustomer().getAddress());
		orderResponse.setCreatedDate(order.getCreatedDate());
		orderResponse.setPayment("Paid");
		orderResponse.setTotalPrice(order.getTotalPrice());
		return orderResponse;
	}

	public void placeOrder(OrderRequestDTO orderItemRequest) {
		// TODO Auto-generated method stub
		User user=userRepository.findById(orderItemRequest.getUserId()).get();
		List<CartItem> cartItems=cartService.getCartItems(user);
		
		Order order=new Order();
		order.setOrderItems(new ArrayList<>());
		order.setCreatedDate(new Date());
		for(CartItem ci:cartItems)
		{
			OrderItem oi=new OrderItem();
			oi.setOrder(order);
			oi.setProduct(ci.getProduct());
			oi.setPrice(ci.getPrice());
			oi.setQuantity(ci.getQuantity());
			
			order.getOrderItems().add(oi);
			CartItemRequest cartItemRequest=new CartItemRequest();
			cartItemRequest.setCartId(null);
			cartItemRequest.setProductId(null);
			cartItemRequest.setQuantity(0);
			
			cartService.deleteCartItem(cartItemRequest);
			
			
		}
		order.setTotalPrice(user.getCart().getTotalPrice());
		
		
		order = orderRepository.save(order);

		
		
	}

}
