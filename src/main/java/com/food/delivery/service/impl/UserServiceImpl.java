package com.food.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.food.delivery.model.FoodItem;
import com.food.delivery.model.Order;
import com.food.delivery.model.User;
import com.food.delivery.repository.FoodRepository;
import com.food.delivery.repository.OrderRepository;
import com.food.delivery.repository.UserRepository;
import com.food.delivery.service.UserService;
import com.food.delivery.view.Login;

public class UserServiceImpl implements UserService{

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	
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

	@Override
	public void insertOrder(List<FoodItem> SelectedFood, Order order) {
		
		orderRepository.save(order);
		foodRepository.saveAll(SelectedFood);
		
	}

}
