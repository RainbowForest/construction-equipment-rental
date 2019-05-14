package com.rainbowforest.Application.controller.admin;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rainbowforest.Application.model.order.Order;
import com.rainbowforest.Application.model.order.OrderDetails;
import com.rainbowforest.Application.service.order.OrderDetailsService;
import com.rainbowforest.Application.service.order.OrderService;

@Controller
@Secured(value = {"ROLE_ADMIN"})
public class AdminOrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@GET
	@RequestMapping("admin/orders") 
	public String orders(Model model) {
		List<Order> orders = orderService.findAllOrders();
		model.addAttribute("orders", orders);
		return "admin/order/orders";
	}
	
	@GET
	@RequestMapping("admin/orders/details")
	public String orderDetails(@RequestParam("orderDetailsId") int orderDetailsId, Model model) {
		OrderDetails orderDetails = orderDetailsService.findOneOrderDetailsById(orderDetailsId);
		model.addAttribute("orderDetails", orderDetails);
		return "admin/order/orderdetails";
	}
	
	@POST
	@RequestMapping("admin/orders/update-status")
	public String updateStatus(@RequestParam("orderId") int orderId, @RequestParam("status") int status) {
		orderService.updateOrderStatus(status, orderId);
		return "admin/order/orders";
	}
	
	@GET
	@RequestMapping("admin/orders/history") 
	public String ordersHistory(Model model) {
		List<Order> orders = orderService.findAllOrders();
		model.addAttribute("orders", orders);
		return "admin/order/ordershistory";
	}
}
