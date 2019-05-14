package com.rainbowforest.Application.model.user;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "authorities")
public class UserRole {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name = "user_role")
	private String userRole;

	@OneToMany (mappedBy = "role")
	private List<UserAccount> userList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<UserAccount> getUserList() {
		return userList;
	}

	public void setUserList(List<UserAccount> userList) {
		this.userList = userList;
	}
}
