package com.rainbowforest.Application.controller.admin;

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

@Controller
@Secured (value = {"ROLE_ADMIN"})
public class AdminLiabilitiesController {

	@Autowired
	private ConstructionSiteService constructionSiteService;
	
	@Autowired
	private OrderService orderService;
	
	@GET
	@RequestMapping("admin/liabilities")
	public String liabilities(Model model) {
		List<ConstructionSite> constructionSiteList = constructionSiteService.findAllConstructionSite();
		List<Order> orders = orderService.findAllOrders();
		Map<String, Double> liabilitiesMap = LiabilitiesUtilities.getLiabilities(constructionSiteList, orders);
		model.addAttribute("constructionSiteList", constructionSiteList);
		model.addAttribute("liabilitiesMap", liabilitiesMap);
		return "admin/liabilities/liabilities";
	}
	
	@GET
	@RequestMapping("admin/liabilities/details")
	public String liabilitiesDetails(@RequestParam("csId") int csId, Model model) {
		List<Order> orders = orderService.findAllOrderByConstructionSiteId(csId);
		model.addAttribute("orders", orders);
		return "admin/liabilities/liabilitiesdetails";
	}
}
