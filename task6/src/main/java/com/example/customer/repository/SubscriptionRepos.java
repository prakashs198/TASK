package com.example.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer.entity.Subscription;

public interface SubscriptionRepos extends JpaRepository<Subscription, Integer> {

}
