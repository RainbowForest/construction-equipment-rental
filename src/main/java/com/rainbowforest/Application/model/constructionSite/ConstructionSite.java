package com.rainbowforest.Application.model.constructionSite;

import com.rainbowforest.Application.model.order.Order;
import com.rainbowforest.Application.model.user.UserAccountDetails;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "construction_site")
public class ConstructionSite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;

	@Column(name = "building_name")
	private String buildingName;
	@Column(name = "building_code")
	private String buildingCode;
	@Column (name = "status")
	private int status;

	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "ConstructionSiteAdress_id", referencedColumnName = "id")
	private ConstructionSiteAdress constructionSiteAdress;

	@OneToMany(mappedBy = "constructionSites")
	private List<UserAccountDetails> userAccountDetails;
	
	@OneToMany(mappedBy = "constructionSite")
	private List<Order> orders;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingCode() {
		return buildingCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ConstructionSiteAdress getConstructionSiteAdress() {
		return constructionSiteAdress;
	}

	public void setConstructionSiteAdress(ConstructionSiteAdress constructionSiteAdress) {
		this.constructionSiteAdress = constructionSiteAdress;
	}

	public List<UserAccountDetails> getUserAccountDetails() {
		return userAccountDetails;
	}

	public void setUserAccountDetails(List<UserAccountDetails> userAccountDetails) {
		this.userAccountDetails = userAccountDetails;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
