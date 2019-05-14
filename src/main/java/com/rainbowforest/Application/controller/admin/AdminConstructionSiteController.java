package com.rainbowforest.Application.controller.admin;

import java.util.List;
import java.util.Locale;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rainbowforest.Application.model.constructionSite.ConstructionSite;
import com.rainbowforest.Application.model.order.Order;
import com.rainbowforest.Application.service.constructionsite.ConstructionSiteService;
import com.rainbowforest.Application.service.order.OrderService;
import com.rainbowforest.Application.validators.ConstructionSiteValidator;

@Controller
@Secured (value = {"ROLE_ADMIN"})
public class AdminConstructionSiteController {

	@Autowired
	private ConstructionSiteService constructionSiteService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GET
	@RequestMapping ("admin/cs-form")
	public String csForm(Model model) {
		ConstructionSite cs = new ConstructionSite();
		model.addAttribute("cs", cs);
		return "admin/constructionsite/constructionsiteform";
	}
	
	@POST
	@RequestMapping ("admin/save-cs")
	public String saveCs(@ModelAttribute("cs") ConstructionSite cs, @RequestParam ("status") int status, Model model, BindingResult result, Locale locale) {
		String returnPage = null;
		ConstructionSiteValidator validator = new ConstructionSiteValidator();
		validator.validate(cs, result);
		model.addAttribute("result", result);
		if(result.hasErrors()) {
			model.addAttribute("cs", cs);
			returnPage = "admin/constructionsite/constructionsiteform";
		}
		else {
			cs.setStatus(status);
			constructionSiteService.addConstructionSite(cs);
			model.addAttribute("message", messageSource.getMessage("cs.save.success", null, locale));
			model.addAttribute("cs", new ConstructionSite());
			returnPage = "admin/constructionsite/constructionsiteform";
		}
		
		return returnPage;
	}
	
	@GET
	@RequestMapping("admin/construction-site/stock-list")
	public String stockList(Model model) {
		List<ConstructionSite> constructionSiteList = constructionSiteService.findAllConstructionSite();
		model.addAttribute("constructionSiteList", constructionSiteList);
		return "admin/constructionsite/stocklist";
	}
	
	@GET
	@RequestMapping("admin/construction-site/stock-list/details")
	public String stockListDetails(@RequestParam("csId") int csId,Model model) {
		List<Order> orders = orderService.findAllOrderByConstructionSiteId(csId);
		model.addAttribute("orders", orders);
		return "admin/constructionsite/stocklistdetails";
	}
	
	@GET
	@RequestMapping("/admin/construction-sites")
	public String constructionSites(Model model) {
		List<ConstructionSite> cs = constructionSiteService.findAllConstructionSite();
		model.addAttribute("cs", cs);
		return "admin/constructionsite/constructionsites";
	}
	
	@GET
	@RequestMapping("admin/construction-sites/edit")
	public String editCs(@RequestParam("csid") int csid, Model model) {
		ConstructionSite cs = constructionSiteService.findOneCsById(csid);
		model.addAttribute("cs", cs);
		return "admin/constructionsite/editconstructionsite";
	}
	
	@POST
	@RequestMapping("admin/construction-sites/update")
	public String updateCs(@RequestParam("csid") Integer id, ConstructionSite cs) {
		constructionSiteService.updateConstructionSiteAdress(
				cs.getConstructionSiteAdress().getStreet(), 
				cs.getConstructionSiteAdress().getStreetNumber(), 
				cs.getConstructionSiteAdress().getLocality(), 
				cs.getConstructionSiteAdress().getZipCode(), 
				cs.getConstructionSiteAdress().getCountry(), 
				id);
		constructionSiteService.updateConstructionSite(
				cs.getBuildingName(), 
				cs.getBuildingCode(), 
				cs.getStatus(), 
				id);
		return "admin/constructionsite/constructionsites";
	}
}
