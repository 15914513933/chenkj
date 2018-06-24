package com.chenkj.mapper;

import org.springframework.stereotype.Component;

import com.chenkj.model.User;

@Component
public interface UserMapper {
	void insertUser(User user);
}
