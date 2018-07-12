package com.chenkj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenkj.model.User;
import com.chenkj.result.ResultBean;
import com.chenkj.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("/list")
	public String userlist(){
		return "admin/user/userlist";
	}
	
	@RequestMapping("/admin/login")
	public String login(){
		return "admin/login";
	}
	
	@RequestMapping("/insertUser")
	public String insertUser(@RequestParam("userid") String userid,@RequestParam("password") String password){
		User user = new User(userid,password);
		userService.insertUser(user);
		return "login";
	}
	
	@RequestMapping("getUsers")
	@ResponseBody
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@RequestMapping(value = "/doLogin",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> doLogin(HttpServletRequest req){
		ResultBean<String> result = new ResultBean<String>("success");
		return result;
	}
}
