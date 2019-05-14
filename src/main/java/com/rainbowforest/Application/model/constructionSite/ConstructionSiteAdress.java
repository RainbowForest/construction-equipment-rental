package com.rainbowforest.Application.model.constructionSite;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "construction_side_adress")
public class ConstructionSiteAdress {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	@Column (name = "street")
	private String street;
	@Column (name = "street_number")
	private String streetNumber;
	@Column (name = "locality")
	private String locality;
	@Column (name = "zip_code")
	private String zipCode;
	@Column (name = "country")
	private String country;
	
	@OneToOne (mappedBy = "constructionSiteAdress", cascade = CascadeType.ALL) 
	private ConstructionSite constructionSite;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ConstructionSite getConstructionSite() {
		return constructionSite;
	}

	public void setConstructionSite(ConstructionSite constructionSite) {
		this.constructionSite = constructionSite;
	}	
}
