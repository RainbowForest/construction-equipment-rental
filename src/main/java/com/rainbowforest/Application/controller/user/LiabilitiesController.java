package com.rainbowforest.Application.controller.user;

import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rainbowforest.Application.model.constructionSite.ConstructionSite;
import com.rainbowforest.Application.model.order.Order;
import com.rainbowforest.Application.service.constructionsite.ConstructionSiteService;
import com.rainbowforest.Application.service.order.OrderService;
import com.rainbowforest.Application.utilities.LiabilitiesUtilities;
import com.rainbowforest.Application.utilities.UserUtilities;

@Controller
@Secured (value = {"ROLE_ADMIN", "ROLE_USER"})
public class LiabilitiesController {

	@Autowired
	private ConstructionSiteService constructionSiteService;
	
	@Autowired
	private OrderService orderService;
	
	@GET
	@RequestMapping("liabilities")
	public String liabilities(Model model) {
		String userName = UserUtilities.getLoggedUser();
		List<ConstructionSite> constructionSiteList = constructionSiteService.getAllConstructionSiteByUserName(userName);
		List<Order> orders = orderService.findAllOrders();
		Map<String, Double> liabilitiesMap = LiabilitiesUtilities.getLiabilities(constructionSiteList, orders);
		model.addAttribute("orders", orders);
		model.addAttribute("constructionSiteList", constructionSiteList);
		model.addAttribute("liabilitiesMap", liabilitiesMap);
		return "user/liabilities/liabilities";
	}
	
	@GET
	@RequestMapping("liabilities/details")
	public String liabilitiesDetails(@RequestParam("csId") int csId, Model model) {
		List<Order> orders = orderService.findAllOrderByConstructionSiteId(csId);
		model.addAttribute("orders", orders);
		return "user/liabilities/liabilitiesdetails";
	}
}
