package com.bulleteers.club.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="UserRole")
public class Role {
	
	@Id	
	@GeneratedValue
	@Column(name = "role_id")
	private Integer userRoleId;
	
	@Column(name="role")
	private String role;

	
	
	
	
	public Role(){
		
	}
	public Role(String role){
		this.role = role;
		
	}
	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
	

}
