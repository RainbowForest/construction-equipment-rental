package com.rainbowforest.Application.service.order;

import com.rainbowforest.Application.model.order.OrderDetails;

public interface OrderDetailsService {
		
	public OrderDetails findOneOrderDetailsById(Integer id);
	public void saveOrder(OrderDetails order);
}
