package com.example.customer.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubscriptionService {

	@Autowired
private com.example.customer.repository.SubscriptionRepos subscriptionRepos;
	
	public com.example.customer.entity.Subscription saveDetails(com.example.customer.entity.Subscription subscription)
	{
		return subscriptionRepos.save(subscription);
	}
	
	public com.example.customer.entity.Subscription getSubscriptionDetailsById(int id) 
	{
		return  subscriptionRepos.findById(id).orElse(null);
	}
	
	public String getDeleteById(int id) 
	{
	 subscriptionRepos.deleteById(id);
	 return "deleted Sucessfully=" + id;
	}
	
	public List<com.example.customer.entity.Subscription> getAllDetails() 
	{
		return subscriptionRepos.findAll();
	}
}