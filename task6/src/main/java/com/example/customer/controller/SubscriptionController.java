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
public class SubscriptionController {

	
	@Autowired
	private com.example.customer.services.SubscriptionService subscriptionService;
		
		@PostMapping("/addsubscription")
		public com.example.customer.entity.Subscription postDetails(@RequestBody com.example.customer.entity.Subscription subscription)
		{
			return subscriptionService.saveDetails(subscription);
		}
		
		@GetMapping("/getsubscriptionId/{id}")
		public com.example.customer.entity.Subscription fetchDetailsById(@PathVariable int id)
		{
			return subscriptionService.getSubscriptionDetailsById(id);
		}
		
		@GetMapping("/getsubscription")
		public List<com.example.customer.entity.Subscription> getDetails()
		{
			return subscriptionService.getAllDetails();
		}
		
		@DeleteMapping("/deleteSubscriptionId/{id}")
		public String deleteDetails(@PathVariable int id)
		{
			return subscriptionService.getDeleteById(id);
		}
}