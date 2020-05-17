package com.adminportal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminportal.service.UserService;

@RestController
public class UserResourceController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/book/removeUserList", method=RequestMethod.POST)
	public String removeList(
			@RequestBody ArrayList<String> userList, Model model
			) {
		for(String id : userList) {
			String userId = id.substring(8);
			userService.removeOne(Long.parseLong(userId));
		}
		
		return "delete success";
	}
}
