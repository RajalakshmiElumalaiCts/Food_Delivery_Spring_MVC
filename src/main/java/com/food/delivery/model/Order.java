package com.food.delivery.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private Timestamp timestamp;
	@Column
	private double price;
	@Column
	private String status;
	
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "id")
	 */
	@ManyToMany
	@JoinTable(
	  name = "food_item_has_order", 
	  joinColumns = @JoinColumn(name = "food_item_id"), 
	  inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<FoodItem> food;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
