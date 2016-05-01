package com.bulleteers.club.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="productTable")
public class Product {
	
	
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private long Id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private int price;
	
	
	@Column(name="quantity")
	private int quantity;

	public Product(){
		
		
	}
	public Product(String name, int price, int quantity){
		
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}

	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
