package com.rainbowforest.Application.service.order;

import java.util.List;
import com.rainbowforest.Application.model.order.Order;

public interface OrderService {
	
	/**
	 * Returns the current list of all orders
	 * 
	 * @return list of objects of type Order
	 */
	public List<Order> findAllOrders();
	
	/**
	 * Finds and returns all orders for construction site with a given identifier
	 * 
	 * @param csId, construction site id
	 * @return list of objects of type Order for a single construction site
	 */
	public List<Order> findAllOrderByConstructionSiteId(int csId);
	
	/**
	 * Finds and returns all orders for user with a given user name
	 * 
	 * @param userName
	 * @return list of objects of type Order for a single user
	 */
	public List<Order> getAllOrdersByUserName(String userName);
	
	/**
	 * Updates the order status for order with a given identifier
	 * 
	 * @param newStatus
	 * @param id, order id
	 */
	public void updateOrderStatus(int newStatus, int id);
}
