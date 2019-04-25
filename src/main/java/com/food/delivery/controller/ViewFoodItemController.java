package com.food.delivery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.food.delivery.model.FoodItem;

@Controller
public class ViewFoodItemController {
	
	public enum foodItem {
		burgerView, cakeView, cheeseCakeView, chickenView,
		chocoCakeView, combo1View, combo2View, pizzaView,
		noodle2View, smallCakeView, riceView, vegrollView,
		noodleView, veggiesView, saladView
	}
	
	@RequestMapping(value = "viewFoodItem", method = RequestMethod.GET)
	public ModelAndView viewFoodDescription(HttpServletRequest request, HttpServletResponse response) {
		
		String chosenFood = request.getParameter("view");
		foodItem food = foodItem.valueOf(chosenFood);
		ModelAndView modelView = new ModelAndView();
		FoodItem foodObj = new FoodItem();
		
		switch (food) {
		case burgerView:
			modelView.setViewName("menu/burger");
			modelView.addObject("foodItemObj",foodObj);	
			break;
		case cakeView:
			modelView.setViewName("menu/cake");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		case cheeseCakeView:
			modelView.setViewName("menu/cheese_cake");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		case chickenView:
			modelView.setViewName("menu/chicken");
			modelView.addObject("foodItemObj", new FoodItem());			
			break;
		case chocoCakeView:
			modelView.setViewName("menu/choco_cake");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		case combo1View:
			modelView.setViewName("menu/combo1");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		case combo2View:
			modelView.setViewName("menu/combo2");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		case pizzaView:
			modelView.setViewName("menu/pizza");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		case noodle2View:
			modelView.setViewName("menu/egg_noodle");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		case smallCakeView:
			modelView.setViewName("menu/small_cake");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		case riceView:
			modelView.setViewName("menu/rice");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		case vegrollView:
			modelView.setViewName("menu/vegroll");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		case noodleView:
			modelView.setViewName("menu/noddle");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		case veggiesView:
			modelView.setViewName("menu/veggies");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		case saladView:
			modelView.setViewName("menu/salad");
			modelView.addObject("foodItemObj", foodObj);			
			break;
		
		}
		
		return modelView;
		
	}

	

}
