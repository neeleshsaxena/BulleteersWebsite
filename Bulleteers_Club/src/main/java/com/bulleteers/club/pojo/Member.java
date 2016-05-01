package com.bulleteers.club.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;




@Entity
@Table(name="memberTable")
@PrimaryKeyJoinColumn(name="personID")
public class Member extends Person{
	
	
	
	//many to one bidirectional
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="clubId")
	private Club clubId;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="member")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Order> order = new ArrayList<Order>();
	
	//Many to many bidirectional
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "member_ride", joinColumns = {
	@JoinColumn(name = "personID", nullable = false, updatable = false) }, inverseJoinColumns = {
	@JoinColumn(name = "rideId", nullable = false, updatable = false) })
	private Set<Ride> ride;
	
	

		
		
	public Set<Ride> getRide() {
		return ride;
	}



	public void setRide(Set<Ride> ride) {
		this.ride = ride;
	}






	@Column(name="bike")
	private String bike;
	
	@Transient
	private String username;
	
	@Transient
	private String password;
	
	@Transient
	private String club;
	
	
	
	
	
	public String getBike() {
		return bike;
	}

	

	public String getUsername() {
		return username;
	}



	public String getClub() {
		return club;
	}



	



	public void setClub(String club) {
		this.club = club;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setBike(String bike) {
		this.bike = bike;
	}



	public Member(){
	
	}



	public Club getClubId() {
		return clubId;
	}



	public void setClubId(Club clubId) {
		this.clubId = clubId;
	}



	public List<Order> getOrder() {
		return order;
	}



	public void setOrder(List<Order> order) {
		this.order = order;
	}






	


	
	
	

}
