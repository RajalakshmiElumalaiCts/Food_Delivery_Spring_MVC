package com.food.delivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.food.delivery.model.FoodItem;
import com.food.delivery.model.Order;
import com.food.delivery.model.User;
import com.food.delivery.view.FoodCart;
import com.food.delivery.view.Login;

@Service
public interface UserService {

	User addUser(User user);

	User login(Login login);

	void insertOrder(List<FoodItem> SelectedFood, Order order);

}
