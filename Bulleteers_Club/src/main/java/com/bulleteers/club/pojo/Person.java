package com.bulleteers.club.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Person")
@Inheritance(strategy = InheritanceType.JOINED)   //Table per subclass is required and good methodology
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personID", unique=true, nullable = false)
	private long personID;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name ="lastName")
	private String lastName;
	
	
	@Column(name = "dateOfBirth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "email")
	private String email;
	
	
	//bidirectional one to one mapping
	@OneToOne(fetch=FetchType.EAGER, mappedBy="person", cascade=CascadeType.ALL)
	private UserAccount userAccount;


	public long getPersonID() {
		return personID;
	}


	public void setPersonID(long personID) {
		this.personID = personID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getDob() {
		return dob;
	}
	
	public String getDobString() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String date = df.format(dob);
		return date;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public UserAccount getUserAccount() {
		return userAccount;
	}


	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}


	
	
	

	
		
		
	
	
	
	

}
