package com.example.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

	@Autowired
	private com.example.customer.repository.CustomerRepos customerRepos;
	
	public com.example.customer.entity.Customer saveDetails(com.example.customer.entity.Customer customer)
	{
		return customerRepos.save(customer);
	}
	
	public com.example.customer.entity.Customer getCustomerDetailsById(int id) 
	{
		return  customerRepos.findById(id).orElse(null);
	}
	
	public String getDeleteById(int id) 
	{
	 customerRepos.deleteById(id);
	 return "deleted Sucessfully=" + id;
	}
	
	public List<com.example.customer.entity.Customer> getAllDetails() 
	{
		return customerRepos.findAll();
	}
}