package com.example.E_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.DTO.OrderRequestDTO;
import com.example.E_commerce.DTO.OrderResponse;
import com.example.E_commerce.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	
	@Autowired
	OrderService orderService;
	
//	POST /api/orders: Place an order.
//	b. GET /api/orders/get: It returns the list of all orders.
//	c. GET /api/orders/get/{id}: It returns an order for the given id.
//	d. GET /api/orders/{id}/summary: Generate order summary. (This is an
//	optional API which the learner can create)

	@PostMapping("/place_order")
	public ResponseEntity placeOrder(@RequestBody OrderRequestDTO orderItemRequest )
	{
		orderService.placeOrder(orderItemRequest);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id)
	{
		OrderResponse orderResponse=orderService.getOrderById(id);
		return ResponseEntity.ok(orderResponse);
	}
	
	
}
