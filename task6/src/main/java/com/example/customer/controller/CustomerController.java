package com.example.customer.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

@Autowired
private com.example.customer.services.CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public com.example.customer.entity.Customer postDetails(@RequestBody com.example.customer.entity.Customer customer)
	{
		return customerService.saveDetails(customer);
	}
	
	@GetMapping("/getById/{id}")
	public com.example.customer.entity.Customer fetchDetailsById(@PathVariable int id)
	{
		return customerService.getCustomerDetailsById(id);
	}
	
	@GetMapping("/getCustomer")
	public List<com.example.customer.entity.Customer> getDetails()
	{
		return customerService.getAllDetails();
	}
	
	@DeleteMapping("/deletecustomerId/{id}")
	public String deleteDetails(@PathVariable int id)
	{
		return customerService.getDeleteById(id);
	}
}