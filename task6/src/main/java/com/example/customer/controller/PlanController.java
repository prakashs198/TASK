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
public class PlanController {
	
@Autowired
private com.example.customer.services.PlanService planService;
	
	@PostMapping("/addplan")
	public com.example.customer.entity.Plan postDetails(@RequestBody com.example.customer.entity.Plan plan)
	{
		return planService.saveDetails(plan);
	}
	
	@GetMapping("/getplanId/{id}")
	public com.example.customer.entity.Plan fetchDetailsById(@PathVariable int id)
	{
		return planService.getPlanDetailsById(id);
	}
	
	@GetMapping("/getPlan")
	public List<com.example.customer.entity.Plan> getDetails()
	{
		return planService.getAllDetails();
	}
	
	@DeleteMapping("/deletePlanId/{id}")
	public String deleteDetails(@PathVariable int id)
	{
		return planService.getDeleteById(id);
	}
}