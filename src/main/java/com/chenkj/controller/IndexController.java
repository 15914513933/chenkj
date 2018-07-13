package com.chenkj.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenkj.model.User;
import com.chenkj.service.impl.MenuServiceImpl;
@Controller
public class IndexController {
	@Autowired
	private MenuServiceImpl menuService;
	@RequestMapping("/index")
	public String index(HttpServletRequest req, HttpServletResponse resp,HttpSession session){
		User user = (User)session.getAttribute("USER_SESSION");
		req.setAttribute("menulist", menuService.getMenus());
		req.setAttribute("userInfo", user);
		Cookie[] cookies = req.getCookies();
		/*if(cookies.length>0){
	　　　　   for (Cookie cookie : cookies) {
	                String name = cookie.getName();
	                if(name.equals("id")){
	                	System.out.println(cookie.getValue());
	                }
	            }
	        }*/
		if(cookies.length>0){
			 for (Cookie cookie : cookies) {
	             System.out.println(cookie.getName()+":"+cookie.getValue());
			 }
		}
		return "admin/index";
	}
	
}
