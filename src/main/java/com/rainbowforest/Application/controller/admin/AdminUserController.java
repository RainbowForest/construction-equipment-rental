package com.rainbowforest.Application.controller.admin;

import java.util.List;
import java.util.Locale;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rainbowforest.Application.model.constructionSite.ConstructionSite;
import com.rainbowforest.Application.model.user.UserAccount;
import com.rainbowforest.Application.model.user.UserAccountDetails;
import com.rainbowforest.Application.service.constructionsite.ConstructionSiteService;
import com.rainbowforest.Application.service.user.UserService;
import com.rainbowforest.Application.validators.UserAccountDetailsValidator;

@Controller
@Secured(value = {"ROLE_ADMIN"})
public class AdminUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ConstructionSiteService constructionSiteService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GET
	@RequestMapping ("admin/user-form")
	public String userForm(Model model) {
		UserAccountDetails user = new UserAccountDetails();
		List<ConstructionSite> constructionSiteList = constructionSiteService.findAllConstructionSite();
		model.addAttribute("constructionSiteList", constructionSiteList);
		model.addAttribute("user", user);
		return "admin/user/userform";
	}
	
	@POST
	@RequestMapping ("admin/save-user")
	public String saveUser(@ModelAttribute("user") UserAccountDetails user, Model model, BindingResult result, Locale locale) {
		String returnPage = null;
		UserAccountDetailsValidator validator = new UserAccountDetailsValidator();
		UserAccount userExist = userService.findOneByUserName(user.getUserAccount().getUserName()); 
		validator.isUserNameExist(userExist, result);
		validator.validate(user, result);
		model.addAttribute("result", result);

		if(result.hasErrors()) {
			model.addAttribute("user", user);
			List<ConstructionSite> constructionSiteList = constructionSiteService.findAllConstructionSite();
			model.addAttribute("constructionSiteList", constructionSiteList);
			returnPage = "admin/user/userform";
		}
		else {
			userService.addUserDetails(user);
			model.addAttribute("message", messageSource.getMessage("user.save.success", null, locale));
			model.addAttribute("user", new UserAccountDetails());
			returnPage = "admin/user/userform";
		}
		return returnPage;
	}
	
	@GET
	@RequestMapping ("admin/users")
	public String getAllUsers(Model model) {
		List<UserAccountDetails> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "admin/user/users";
	}
		
	@POST
	@RequestMapping("admin/users/delete-user")
	public String deleteUser(@RequestParam ("usid") int userId) {
		userService.deleteUser(userId);
		return "redirect:../users";
	}
		
	@GET
	@RequestMapping("admin/users/edit-user")
	public String editUser(@RequestParam ("usid") int userId, Model model) {
		UserAccountDetails user = userService.findOneById(userId);
		List<ConstructionSite> constructionSiteList = constructionSiteService.findAllConstructionSite();
		model.addAttribute("constructionSiteList", constructionSiteList);
		model.addAttribute("user", user);
		return "admin/user/edituser";
	}

	@POST
	@RequestMapping("admin/users/update-user")
	public String updateDetails(
			UserAccountDetails user, 
			@RequestParam ("usid") int usid,
			@RequestParam ("constructionSites") int csid) {
		userService.updateUserDetails(
				user.getFirstName(), 
				user.getLastName(), 
				user.getEmail(), 
				user.getPhoneNumber(), 
				user.getPosition(), 
				csid, 
				usid);
		return "admin/user/users";
	}
		
	@GET
	@RequestMapping("admin/users/user-details")
	public String userDetails(@RequestParam ("usid") int userId, Model model) {
		UserAccountDetails user = userService.findOneById(userId);
		model.addAttribute("user", user);
		return "admin/user/userdetails";
	}
		
	@GET
	@RequestMapping("admin/users/user")
	public String user(@RequestParam("userName") String userName, Model model) {
		UserAccount user = userService.findOneByUserName(userName);
		model.addAttribute("user", user);
		return "admin/user/user";
	}
		
	@GET
	@RequestMapping ("admin/security")
	public String security(Model model) {
		List<UserAccount> users = userService.findAllAccount();
		model.addAttribute("users", users);
		return "admin/user/security";
	}
		
	@GET
	@RequestMapping("admin/security/edit")
	public String editSecurity(@RequestParam("usid") int usid, Model model) {
		UserAccount user = userService.findOneAccountById(usid);
		model.addAttribute("user", user);
		return "admin/user/editsecurity";
	}
		
	@POST
	@RequestMapping("admin/security/update")
	public String updateSecurity(
			UserAccount user, 
			@RequestParam("usid") int usid, 
			@RequestParam("role") int roleId) {
		userService.securityUpdate(
			new BCryptPasswordEncoder().encode(user.getUserPassword()), 
			user.getUserEnabled(),
			roleId, 
			usid);
		return "admin/user/security";
	}
}
