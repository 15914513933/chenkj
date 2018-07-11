package com.chenkj.service;

import java.util.List;

import com.chenkj.model.User;

public interface UserService {
	User insertUser(User user);
	List<User> getUsers();
}
