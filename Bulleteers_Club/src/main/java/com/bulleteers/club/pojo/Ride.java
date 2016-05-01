package com.bulleteers.club.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="rideTable")
public class Ride {
	
	@Id
	@GeneratedValue
	@Column(name = "rideId", unique=true)
	private long rideId;
	

	
	//many to one bidirectional
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="clubId")
	private Club clubId;
	
	// many to many members bi-directional mapping
	@ManyToMany(mappedBy = "ride")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Member> member;
	
	

	public Set<Member> getMember() {
		return member;
	}

	public void setMember(Set<Member> member) {
		this.member = member;
	}

	@Column(name="description")
	private String description;
	
	@Column(name="startdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startdate;
	
	@Column(name="enddate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enddate;
	
	@Column(name="days")
	private int days;
	
	@Column(name="roadcaptain")
	private String roadcaptain;
	
	@Column(name="rules")
	private String rules;
	
	@Transient
	private CommonsMultipartFile ridePic;
	
	@Column(name = "RidePicPath")
	private String ridePicPath;

	public CommonsMultipartFile getRidePic() {
		return ridePic;
	}

	public void setRidePic(CommonsMultipartFile ridePic) {
		this.ridePic = ridePic;
	}

	public String getRidePicPath() {
		return ridePicPath;
	}

	public void setRidePicPath(String ridePicPath) {
		this.ridePicPath = ridePicPath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartdate() {
		return startdate;
	}
	public String getStartDateString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(startdate);
		return date;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}
	public String getEndDateString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(enddate);
		return date;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getRoadcaptain() {
		return roadcaptain;
	}

	public void setRoadcaptain(String roadcaptain) {
		this.roadcaptain = roadcaptain;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public long getRideId() {
		return rideId;
	}

	public void setRideId(long rideId) {
		this.rideId = rideId;
	}

	public Club getClubId() {
		return clubId;
	}

	public void setClubId(Club clubId) {
		this.clubId = clubId;
	}

	
	
	
	
	

}
