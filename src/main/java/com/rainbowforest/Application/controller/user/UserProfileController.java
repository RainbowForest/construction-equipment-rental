package com.rainbowforest.Application.controller.user;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rainbowforest.Application.model.user.UserAccountDetails;
import com.rainbowforest.Application.service.user.UserService;
import com.rainbowforest.Application.utilities.UserUtilities;

@Controller
@Secured (value = {"ROLE_ADMIN", "ROLE_USER"})
public class UserProfileController {

	@Autowired
	private UserService userService;
	
	@GET
	@RequestMapping("my-profile")
	public String userProfile(Model model) {
		String userName = UserUtilities.getLoggedUser();
		UserAccountDetails userAccountDetails = userService.getLoggedUser(userName); 
		model.addAttribute("userAccountDetails", userAccountDetails);
		return "user/userprofile/userprofile";
	}
	
	@POST
	@RequestMapping("my-profile/update")
	public String updatePassword(
			UserAccountDetails user,
			@RequestParam("oldPassword") String oldPassword, 
			@RequestParam("newPassword") String newPassword,
			@RequestParam("newPassword") String repeatPassword, 
			@RequestParam("usId") int usId) {
			
		if(newPassword.equals(repeatPassword)) {
			userService.updatePassword(newPassword, usId);	
		}
		return "user/userprofile/userprofile";
	}
}
