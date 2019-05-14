package com.rainbowforest.Application.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.rainbowforest.Application.model.order.Order;
import com.rainbowforest.Application.repository.OrderRepository;
import com.rainbowforest.Application.service.order.OrderServiceImpl;

@RunWith (MockitoJUnitRunner.class)
@SpringBootTest
public class OrderServiceTests {

	@Mock
	private OrderRepository orderRepository;
	
	@InjectMocks
	private OrderServiceImpl orderServiceImpl;
	
	@Before
	public void createOrderList() {
		List<Order> orderList = new ArrayList<Order>(); 
		Order order01 = new Order();
		Order order02 = new Order();
		order01.setId(3);
		order02.setId(5);
		
		orderList.add(order01);
		orderList.add(order02);
		
		Mockito.when(orderRepository.findAll()).thenReturn(orderList);
		
	}
	
	@Test
	public void find_All_Orders() {
		int productId01 = 3;
		int productId02 = 5;
		List<Order> orders = orderServiceImpl.findAllOrders();
		
		assertThat(orders.get(0).getId()).isEqualTo(productId01);
		assertThat(orders.get(1).getId()).isEqualTo(productId02);
	}
	
}
