package com.rainbowforest.Application.model.catalog;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.rainbowforest.Application.model.order.OrderDetails;

@Entity
@Table (name = "cart_item")
public class Item  {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name ="quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn (name = "product_id")
	private Product product;
	
	@ManyToMany (mappedBy = "items")
	private List<OrderDetails> ordersDetails;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Item() {
		super();
	}
	public Item(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
}
