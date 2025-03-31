package com.example.E_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.E_commerce.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
