package com.chenkj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenkj.service.impl.MenuServiceImpl;
@Controller
public class IndexController {
	@Autowired
	private MenuServiceImpl menuService;
	@RequestMapping("/index")
	public String index(HttpServletRequest req, HttpServletResponse resp){
		req.setAttribute("menulist", menuService.getMenus());
		return "admin/index";
	}
	
}
