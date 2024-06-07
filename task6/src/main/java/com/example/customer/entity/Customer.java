package com.example.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="customer_name")
	private String name;
	
	@Column(name="customer_address")
	private String address;
	
	@Column(name="customer_email")
	private String email;
	
	@Column(name="customer_mobilenumber")
	private String mobilenumber;
	
	@ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String name, String address, String email, String mobilenumber, String plan) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobilenumber = mobilenumber;

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	

	public Plan getPlan() {
		return plan;
	}


	public void setPlan(Plan plan) {
		this.plan = plan;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", mobilenumber="
				+ mobilenumber + "]";
	}
	
}