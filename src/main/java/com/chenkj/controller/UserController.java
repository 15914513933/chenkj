package com.chenkj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chenkj.model.User;
import com.chenkj.service.impl.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	@RequestMapping("/insertUser")
	public String insertUser(@RequestParam("userid") String userid,@RequestParam("password") String password){
		User user = new User(userid,password);
		userService.insertUser(user);
		return "login";
	}
}
