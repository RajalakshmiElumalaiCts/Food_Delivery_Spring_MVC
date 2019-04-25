package com.food.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.food.delivery.model.User;
import com.food.delivery.repository.UserRepository;
import com.food.delivery.service.UserService;
import com.food.delivery.view.Login;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);		
	}

	@Override
	public User login(Login login) {
		User user = userRepository.findByUsername(login.getUsername());
		
		if(user!= null && user.getUsername().equals(login.getUsername()) && user.getPassword().equals(login.getPassword())) {
			return user;
		}else
			return null;		
	}

}
