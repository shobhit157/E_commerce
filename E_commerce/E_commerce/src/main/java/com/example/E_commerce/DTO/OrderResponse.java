package com.example.E_commerce.DTO;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
	
	private Long id;
	private Date createdDate;
	private String address;
	private String payment;
	private BigDecimal totalPrice;

}
