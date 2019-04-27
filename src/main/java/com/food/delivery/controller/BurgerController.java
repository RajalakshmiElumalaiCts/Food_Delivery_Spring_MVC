package com.food.delivery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.food.delivery.model.FoodItem;
import com.food.delivery.view.FoodCart;
import com.food.delivery.view.FoodMenu;

@Controller
public class BurgerController {
	
	@RequestMapping(value = "/addBurgerToCart", method = RequestMethod.GET)
	public ModelAndView viewBurgerDescription(HttpServletRequest request, HttpServletResponse response,
			 @ModelAttribute("burger") FoodItem burger) {
		
		FoodCart foodCart = (FoodCart) request.getSession().getAttribute("foodCart");
		System.out.println("foodCart--------------------->>"+foodCart.getSelectedFood());
		System.out.println("burger--------------------->>"+burger);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("menu/food_menu");
		updateBurger(burger);
		
		foodCart.getSelectedFood().add(burger);
		
		model.addObject("foodMenu", new FoodMenu());
		return model;
		
	}

	private FoodItem updateBurger(FoodItem burger) {
		burger.setDescription("Bleu Cheese,chicken,lettuce,tomato,pickles,onions,special sauce and catsup top this spectacular burger!!!");
		burger.setName("Chicken Burger");
		burger.setPrice(10);
		return burger;
	}
}
