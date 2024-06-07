package com.example.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer.entity.Plan;

public interface PlanRepos extends JpaRepository<Plan, Integer> {

}
