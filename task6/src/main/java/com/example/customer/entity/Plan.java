package com.example.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="plan")
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="plan_name")
	private String name;
	
	@Column(name="plan_description")
	private String description;
	
	@Column(name="plan_price")
	private Double price;
	
	@Column(name="plan_datalimit")
	private int datalimit;
	
	
    @Column(name = "plan_callminutes")
    private String callminutes;

    @Column(name = "plan_smslimit")
    private String smslimit;

	public Plan() {
		
	}

	public Plan(String name, String description, Double price, int datalimit, String callminutes, String smslimit) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.datalimit = datalimit;
		this.callminutes = callminutes;
		this.smslimit = smslimit;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getDatalimit() {
		return datalimit;
	}

	public void setDatalimit(int datalimit) {
		this.datalimit = datalimit;
	}

	public String getCallminutes() {
		return callminutes;
	}

	public void setCallminutes(String callminutes) {
		this.callminutes = callminutes;
	}

	public String getSmslimit() {
		return smslimit;
	}

	public void setSmslimit(String smslimit) {
		this.smslimit = smslimit;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", datalimit=" + datalimit + ", callminutes=" + callminutes + ", smslimit=" + smslimit + "]";
	}
    
    
}