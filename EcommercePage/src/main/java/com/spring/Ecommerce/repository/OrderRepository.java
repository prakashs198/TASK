package com.spring.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Ecommerce.model.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {
}