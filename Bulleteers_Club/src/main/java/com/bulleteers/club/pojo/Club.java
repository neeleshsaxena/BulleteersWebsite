package com.bulleteers.club.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="clubTable")
public class Club {
	
	@Id
	@GeneratedValue
	@Column(name="clubId")
	private long clubId;
	
	@Column(name="clubName")
	private String clubName;
	
	@Column(name="president")
	private String president;
	
	@Column(name="tresurer")
	private String treasurer;
	
	//one to many members bi-directional mapping 
	@OneToMany( mappedBy="clubId", cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Member> member;
	
	//one to many members bi-directional mapping 
	@OneToMany( mappedBy="clubId", cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Ride> ride;
	
	@Column(name="rules",length=255)
	private String rules;
	
	@Column(name="tradition",length=255)
	private String tradition;
	
	
	
	

	public long getClubId() {
		return clubId;
	}

	public void setClubId(long clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

	public String getTreasurer() {
		return treasurer;
	}

	public void setTreasurer(String treasurer) {
		this.treasurer = treasurer;
	}

	public Set<Member> getMember() {
		return member;
	}

	public void setMember(Set<Member> member) {
		this.member = member;
	}

	public Set<Ride> getRide() {
		return ride;
	}

	public void setRide(Set<Ride> ride) {
		this.ride = ride;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public String getTradition() {
		return tradition;
	}

	public void setTradition(String tradition) {
		this.tradition = tradition;
	}

	

	

	
	
	
}
