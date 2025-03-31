package com.example.E_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.E_commerce.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>{

}
