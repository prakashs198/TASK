package com.example.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlanService {

@Autowired
private com.example.customer.repository.PlanRepos planRepos;
	
	public com.example.customer.entity.Plan saveDetails(com.example.customer.entity.Plan plan)
	{
		return planRepos.save(plan);
	}
	
	public com.example.customer.entity.Plan getPlanDetailsById(int id) 
	{
		return  planRepos.findById(id).orElse(null);
	}
	
	public String getDeleteById(int id) 
	{
	 planRepos.deleteById(id);
	 return "deleted Sucessfully=" + id;
	}
	
	public List<com.example.customer.entity.Plan> getAllDetails() 
	{
		return planRepos.findAll();
	}
}