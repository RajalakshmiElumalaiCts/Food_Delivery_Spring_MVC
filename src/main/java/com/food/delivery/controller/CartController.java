package com.food.delivery.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.food.delivery.model.FoodItem;
import com.food.delivery.model.Order;
import com.food.delivery.service.UserService;
import com.food.delivery.view.FoodCart;

@Controller
public class CartController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/placeOrder", method = RequestMethod.GET)
	public ModelAndView placeOrder(HttpServletRequest request, HttpServletResponse response) {
		
		FoodCart foodCart = (FoodCart) request.getSession().getAttribute("foodCart");
		Order order = createOrder(foodCart);
		userService.insertOrder(foodCart.getSelectedFood(), order);
		
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("confirmation/show_confirmation");
		
		return modelView;
		
	}

	private Order createOrder(FoodCart foodCart) {
		Order order = new Order();
		order.setStatus("ordered");
		order.setTimestamp(new Timestamp(new Date().getTime()));		
		double totalPrice = foodCart.getSelectedFood().stream().map(FoodItem :: getPrice).mapToDouble(Float :: floatValue).sum();
		order.setPrice(totalPrice);
		return order;
	}

}
