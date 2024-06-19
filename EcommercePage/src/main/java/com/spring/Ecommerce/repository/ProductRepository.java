package com.spring.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Ecommerce.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//	Product getById(Long productId);
}