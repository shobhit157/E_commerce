package com.example.E_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.E_commerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
