package com.rainbowforest.Application.controller.admin;

import javax.ws.rs.GET;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {

	@GET
	@RequestMapping("admin")
	@Secured(value = {"ROLE_ADMIN"})
	public String adminPage() {
		return "admin/admindashboard";
	}
}