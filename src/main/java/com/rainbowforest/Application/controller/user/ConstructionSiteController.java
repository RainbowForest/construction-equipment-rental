package com.rainbowforest.Application.controller.user;

import java.util.List;
import javax.ws.rs.GET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rainbowforest.Application.model.constructionSite.ConstructionSite;
import com.rainbowforest.Application.service.constructionsite.ConstructionSiteService;

@Controller
@Secured (value = {"ROLE_ADMIN", "ROLE_USER"})
public class ConstructionSiteController {

	@Autowired
	private ConstructionSiteService constructionSiteService;
	
	@GET
	@RequestMapping("construction-site")
	public String constructionSiteList(Model model) {
		List<ConstructionSite> cs = constructionSiteService.findAllConstructionSite();
		model.addAttribute("cs", cs);
		return "user/constructionsite/constructionsitelist";
	}
}
