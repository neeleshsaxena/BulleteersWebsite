package com.bulleteers.club.pojo;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.bulleteers.club.pojo.Product;

@Entity
@Table(name="orderTable")
public class Order {
	
	
	@Id
	@GeneratedValue
	@Column(name="orderId")
	private long orderId;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Product product ;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fromMember")
	private Member member;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}



	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}



	
	
	
	

}
