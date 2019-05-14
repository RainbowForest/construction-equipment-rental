package com.rainbowforest.Application.model.order;

import java.time.LocalDate;
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
import com.rainbowforest.Application.model.constructionSite.ConstructionSite;

@Entity
@Table (name = "orders")
public class Order {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name = "total_price")
	private double totalPrice;
	@Column (name = "date")
	private LocalDate date;
	@Column (name = "status")
	private int status;
	@Column (name = "ordering_party")
	private String orderingParty;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "construction_site_id")
	private ConstructionSite constructionSite;

	@OneToOne (mappedBy = "order")
	private OrderDetails orderDetails;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOrderingParty() {
		return orderingParty;
	}

	public void setOrderingParty(String orderingParty) {
		this.orderingParty = orderingParty;
	}

	public ConstructionSite getConstructionSite() {
		return constructionSite;
	}

	public void setConstructionSite(ConstructionSite constructionSite) {
		this.constructionSite = constructionSite;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
}
