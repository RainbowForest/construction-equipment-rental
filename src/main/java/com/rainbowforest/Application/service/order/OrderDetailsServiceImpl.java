package com.rainbowforest.Application.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rainbowforest.Application.model.order.OrderDetails;
import com.rainbowforest.Application.repository.OrderDetailsRepository;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Override
	public void saveOrder(OrderDetails order) {
		orderDetailsRepository.save(order);	
	}

	@Override
	public OrderDetails findOneOrderDetailsById(Integer id) {
		OrderDetails orderDetails = orderDetailsRepository.getOne(id);
		return orderDetails;
	}
}
