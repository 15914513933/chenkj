package com.chenkj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenkj.service.impl.MenuServiceImpl;
@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuServiceImpl menuService;
	
	@RequestMapping("/list")
	public String menulist(HttpServletRequest req, HttpServletResponse resp){
		req.setAttribute("menulist", menuService.getMenus());
		return "admin/menu/menulist";
	}
	
}
