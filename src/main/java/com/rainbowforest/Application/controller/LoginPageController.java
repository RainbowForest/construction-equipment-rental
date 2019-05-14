package com.rainbowforest.Application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginPageController {

	@RequestMapping ("/login")
	public String homePage(Model model) {
		return "login"; 
	}
}
