package com.rainbowforest.Application.model.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.rainbowforest.Application.model.constructionSite.ConstructionSite;

@Entity
@Table(name = "users_details")
public class UserAccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	@Column(name = "first_name")
	@NotNull
	private String firstName;
	@Column(name = "last_name")
	@NotNull
	private String lastName;
	@Column(name = "position")
	@NotNull
	private String position;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;

	@ManyToOne (cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name = "construction_site_id", nullable = true)
	private ConstructionSite constructionSites;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserAccount userAccount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ConstructionSite getConstructionSites() {
		return constructionSites;
	}

	public void setConstructionSites(ConstructionSite constructionSites) {
		this.constructionSites = constructionSites;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
}
