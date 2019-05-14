package com.rainbowforest.Application.controller.user;

import java.util.List;
import javax.ws.rs.GET;
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
import com.rainbowforest.Application.utilities.UserUtilities;

@Controller
@Secured (value = {"ROLE_ADMIN", "ROLE_USER"})
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@GET
	@RequestMapping("orders")
	public String orders(Model model) {
		String userName = UserUtilities.getLoggedUser();
		List<Order> orders = orderService.getAllOrdersByUserName(userName);
		model.addAttribute("orders", orders);
		return "user/order/orders";
	}
	
	@GET
	@RequestMapping("orders/details")
	public String orderDetails(@RequestParam("orderDetailsId") int orderDetailsId, Model model) {
		OrderDetails orderDetails = orderDetailsService.findOneOrderDetailsById(orderDetailsId);
		model.addAttribute("orderDetails", orderDetails);
		return "user/order/orderdetails";
	}
}
