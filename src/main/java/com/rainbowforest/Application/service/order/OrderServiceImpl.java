package com.rainbowforest.Application.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainbowforest.Application.model.order.Order;
import com.rainbowforest.Application.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> findAllOrders() {
		List<Order> orders = orderRepository.findAll();
		return orders;
	}

	@Override
	public void updateOrderStatus(int newStatus, int id) {
		orderRepository.updateOrderStatus(newStatus, id);
		
	}

	@Override
	public List<Order> findAllOrderByConstructionSiteId(int csId) {
		List<Order> orders = orderRepository.findAllOrderByConstructionSiteId(csId);
		return orders;
	}

	@Override
	public List<Order> getAllOrdersByUserName(String userName) {
		List<Order> orders = orderRepository.getAllOrdersByUserName(userName);
		return orders;
	}

}
