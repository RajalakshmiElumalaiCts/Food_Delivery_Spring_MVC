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
public class ChocolateCakeController {

	
	@RequestMapping(value = "/addChocoCakeToCart", method = RequestMethod.GET)
	public ModelAndView addBurgerToCart(HttpServletRequest request, HttpServletResponse response,
			 @ModelAttribute("chocoCake") FoodItem chocoCake) {
		
		FoodCart foodCart = (FoodCart) request.getSession().getAttribute("foodCart");
		System.out.println("foodCart--------------------->>"+foodCart.getSelectedFood());
		System.out.println("chocoCake--------------------->>"+chocoCake);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("menu/food_menu");
		updateChocoCake(chocoCake);
		
		foodCart.getSelectedFood().add(chocoCake);
		
		model.addObject("foodMenu", new FoodMenu());
		return model;
		
	}

	private FoodItem updateChocoCake(FoodItem chocoCake) {
		chocoCake.setDescription("Chocolate cake is a cake flavored with melted chocolate or cocoa powder or both !!!");
		chocoCake.setName("Chocolate Cake");
		chocoCake.setPrice(5);
		return chocoCake;
	}


}
