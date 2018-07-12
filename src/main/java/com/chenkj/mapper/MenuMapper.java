package com.chenkj.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chenkj.model.Menu;

@Component
public interface MenuMapper {
	List<Menu> getMenus();
}
