package com.example.E_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.E_commerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
