package com.adminportal.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adminportal.domain.Book;
import com.adminportal.domain.User;
import com.adminportal.domain.security.Role;
import com.adminportal.domain.security.UserRole;
import com.adminportal.service.UserService;
import com.adminportal.utility.SecurityUtility;

@Controller
@RequestMapping("/book")
public class UserController {
	@Autowired UserService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "addUser";
	}
	
	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public String newUserPost( HttpServletRequest request,
			@ModelAttribute("email") String userEmail,
			@ModelAttribute("username") String username,
			@ModelAttribute("firstName") String firstName,
			@ModelAttribute("lastName") String lastName,
			@ModelAttribute("newPassword") String password,
			Model model) throws Exception{
		model.addAttribute("email", userEmail);
		model.addAttribute("username", username);
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("newPassword", password);
		
		if (userService.findByUsername(username) != null) {
			model.addAttribute("usernameExists", true);
			return "addUser";
		}
		
		
		if (userService.findByEmail(userEmail) != null) {
			model.addAttribute("emailExists", true);
			return "addUser";
		}
		 
		User user = new User();
		user.setUsername(username);
		user.setEmail(userEmail);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		password = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(password);
		
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, role));
		userService.createUser(user, userRoles);
		
		return "redirect:userList";
	}
	
	@RequestMapping("/updateUser")
	public String updateBook(@RequestParam("id") Long id, Model model) {
		User user = userService.findOne(id);
		model.addAttribute("user", user);
		
		return "updateUser";
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public String updateUserInfo(
			@ModelAttribute("user") User user,
			@ModelAttribute("newPassword") String newPassword,
			Model model
			) throws Exception {
		User currentUser = userService.findById(user.getId());
		
		if(currentUser == null) {
			throw new Exception ("User not found");
		}
		
		/*check email already exists*/
		if (userService.findByEmail(user.getEmail())!=null) {
			if(userService.findByEmail(user.getEmail()).getId() != currentUser.getId()) {
				model.addAttribute("emailExists", true);
				return "updateUser";
			}
		}
		
		/*check username already exists*/
		if (userService.findByUsername(user.getUsername())!=null) {
			if(userService.findByUsername(user.getUsername()).getId() != currentUser.getId()) {
				model.addAttribute("usernameExists", true);
				return "updateUser";
			}
		}
		
		//update password
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setUsername(user.getUsername());
		currentUser.setEmail(user.getEmail());
		
		BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
		currentUser.setPassword(passwordEncoder.encode(newPassword));
		
		userService.save(currentUser);
		model.addAttribute("updateSuccess", true);
		
		return "updateUser";
	}
	
	@RequestMapping("/userList")
	public String userList(Model model) {
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);		
		return "userList";
	}
	
	@RequestMapping(value="/removeUser", method=RequestMethod.POST)
	public String remove(
			@ModelAttribute("id") String id, Model model
			) {
		userService.removeOne(Long.parseLong(id.substring(8)));
		List<User>userList = userService.findAll();
		model.addAttribute("userList", userList);
		
		return "redirect:book/userList";
	}
}


