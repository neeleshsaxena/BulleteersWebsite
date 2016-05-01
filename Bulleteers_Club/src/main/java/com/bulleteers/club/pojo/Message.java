package com.bulleteers.club.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private long Id;
	
	
	
	@Column(name="isseen")
	private boolean isseen;
	
	@Column(name="text")
	private String text;
	
	@OneToOne
	@JoinColumn(name="fromPerson")
	private Person fromPerson;
	
	@OneToOne
	@JoinColumn(name="toPerson")
	private Person toPerson;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public boolean isIsseen() {
		return isseen;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setIsseen(boolean isseen) {
		this.isseen = isseen;
	}

	public Person getFromPerson() {
		return fromPerson;
	}

	public void setFromPerson(Person fromPerson) {
		this.fromPerson = fromPerson;
	}

	public Person getToPerson() {
		return toPerson;
	}

	public void setToPerson(Person toPerson) {
		this.toPerson = toPerson;
	}
	

}
