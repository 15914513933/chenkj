package com.chenkj.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenkj.mapper.MenuMapper;
import com.chenkj.model.Menu;
import com.chenkj.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> getMenus() {
		List<Menu> list = menuMapper.getMenus();
		List<Menu> menus = new ArrayList<Menu>();
		for(Iterator<Menu> it = list.iterator();it.hasNext();){
			Menu menu = it.next();
			if(menu.getPid()==null){
				menus.add(menu);
				it.remove();
			}
		}
		for(Menu menu : menus){
			for(Iterator<Menu> it = list.iterator();it.hasNext();){
				Menu subMenu = it.next();
				if(menu.getMenuid().equals(subMenu.getPid())){
					menu.getSubMenus().add(subMenu);
					it.remove();
				}
			}
		}
		return menus;
	}

}
