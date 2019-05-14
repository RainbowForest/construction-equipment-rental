package com.rainbowforest.Application.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_password")
	private String userPassword;
	@Column(name = "user_enabled")
	private int userEnabled;

	@ManyToOne 
	@JoinColumn(name = "user_role_id")
	private UserRole role;

	@OneToOne (mappedBy = "userAccount")
	private UserAccountDetails userAccountDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(int userEnabled) {
		this.userEnabled = userEnabled;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public UserAccountDetails getUserAccountDetails() {
		return userAccountDetails;
	}

	public void setUserAccountDetails(UserAccountDetails userAccountDetails) {
		this.userAccountDetails = userAccountDetails;
	}	
}
