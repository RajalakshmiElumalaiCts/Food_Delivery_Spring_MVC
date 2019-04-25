package com.food.delivery.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.food.delivery.model.FoodItem;
import com.food.delivery.view.FoodCart;

@Controller
public class BurgerController {
	
	@RequestMapping(value = "addBurgerToCart", method = RequestMethod.GET)
	public ModelAndView viewBurgerDescription(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("foodObj") FoodItem burger) {
		System.out.println("burger---------------->"+burger.getPrice());
		ModelAndView model = new ModelAndView();
		model.setViewName("menu/food_menu");
		updateBurger(burger);
		
		FoodCart cart = new FoodCart();
		List<FoodItem> selectedFood = new ArrayList<FoodItem>();
		selectedFood.add(burger);
		
		model.addObject("foodCart", selectedFood);
		return model;
		
	}

	private FoodItem updateBurger(FoodItem burger) {
		burger.setDescription("Bleu Cheese,chicken,lettuce,tomato,pickles,onions,special sauce and catsup top this spectacular burger!!!");
		burger.setName("Chicken Burger");
		burger.setPrice(10);
		return burger;
	}
}
