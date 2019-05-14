package com.rainbowforest.Application.controller.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rainbowforest.Application.model.catalog.Item;
import com.rainbowforest.Application.model.catalog.Product;
import com.rainbowforest.Application.model.constructionSite.ConstructionSite;
import com.rainbowforest.Application.model.order.OrderDetails;
import com.rainbowforest.Application.service.constructionsite.ConstructionSiteService;
import com.rainbowforest.Application.service.order.OrderDetailsService;
import com.rainbowforest.Application.service.product.ProductService;
import com.rainbowforest.Application.utilities.OrderUtilities;
import com.rainbowforest.Application.utilities.UserUtilities;

@Controller
@Secured (value = {"ROLE_ADMIN", "ROLE_USER"})
public class CartController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ConstructionSiteService constructionSiteService;
	
	@Autowired
	private  OrderDetailsService orderDetailsService;
	
	@GET
	@RequestMapping("cart")
	public String cart(HttpSession session, Model model) {
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		double totalPrice = OrderUtilities.getTotalPrice(cart);
		model.addAttribute("totalPrice", totalPrice);
		return "user/cart/cart";
	}
	
	@GET
	@RequestMapping("cart/add")
	public String order(@RequestParam("itemId") int itemId,@RequestParam("quantity") Integer quantity, Model model, HttpSession session) {
		if(quantity == null) {
			quantity = 1;
		}
		if(session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			Product product = productService.findOneProduct(itemId);
			cart.add(new Item(product, quantity));
			session.setAttribute("cart", cart);
		}
		else {
			@SuppressWarnings("unchecked")
			List<Item> cart = (List<Item>)session.getAttribute("cart");
			int index = OrderUtilities.isExist(itemId, cart);
			if(index == -1) {
				Product product = productService.findOneProduct(itemId);
				cart.add(new Item(product, quantity));
				session.setAttribute("cart", cart);
			}
		}
		return "redirect:../cart";
	}

	@POST
	@RequestMapping("cart/delete-item")
	public String deleteItemCart(@RequestParam("itemId") int itemId, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		int index = OrderUtilities.isExist(itemId, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:../cart";
	}
	
	@POST
	@RequestMapping("cart/update")
	public String updateItem(@RequestParam("itemId") int itemId,@RequestParam("quantity") Integer quantity, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		int index = OrderUtilities.isExist(itemId, cart);
		cart.get(index).setQuantity(quantity);
		session.setAttribute("cart", cart);
		return "redirect:../cart";
	}
	
	@GET
	@RequestMapping("cart/order")
	public String order(HttpSession session, Model model) {
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		double totalPrice = OrderUtilities.getTotalPrice(cart);
		OrderDetails orderDetails = new OrderDetails();
		List<ConstructionSite> constructionSiteList = constructionSiteService.findAllConstructionSite();
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("constructionSiteList", constructionSiteList);
		model.addAttribute("orderDetails", orderDetails);
		model.addAttribute("cart", cart);
		return "user/order/orderform";
	}
	
	@POST
	@RequestMapping("cart/order/save")
	public String saveOrder(HttpSession session, OrderDetails orderDetails) {
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		List<Item> items = new ArrayList<Item>();
		for(int i = 0; i < cart.size(); i++) {
			Item item = new Item();
			item.setProduct(productService.findOneProduct(cart.get(i).getProduct().getId()));
			item.setQuantity(cart.get(i).getQuantity());
			items.add(item);
		}
		orderDetails.getOrder().setTotalPrice(OrderUtilities.getTotalPrice(items));
		orderDetails.getOrder().setDate(LocalDate.now());
		orderDetails.getOrder().setOrderingParty(UserUtilities.getLoggedUser());
		orderDetails.setItems(items);
		orderDetailsService.saveOrder(orderDetails);
		return "user/catalog/catalog";
	}
}
