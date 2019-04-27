package com.food.delivery.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.food.delivery.model.FoodItem;
import com.food.delivery.view.FoodCart;
import com.food.delivery.view.FoodMenu;
import com.food.delivery.view.Login;

@Controller
public class FoodMenuController {
	
	public enum foodItem {
		burgerView, cakeView, cheeseCakeView, chickenView,
		chocoCakeView, combo1View, combo2View, pizzaView,
		noodle2View, smallCakeView, riceView, vegrollView,
		noodleView, veggiesView, saladView
	}
	
	@RequestMapping(value = "/viewFoodItem", method = RequestMethod.GET)
	public ModelAndView viewFoodDescription(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("foodMenu") FoodMenu foodMenu) {
		
		String chosenFood = request.getParameter("burgerView");
		System.out.println("chosenFood------------------->"+chosenFood);
		foodItem food = foodItem.valueOf(chosenFood);
		
		
		
		FoodCart foodCart = (FoodCart) request.getSession().getAttribute("foodCart");
		
		if(foodCart == null) {
			foodCart = new FoodCart();			
			foodCart.setSelectedFood(new ArrayList<FoodItem>());
		}else if(foodCart.getSelectedFood() == null) {
			foodCart.setSelectedFood(new ArrayList<FoodItem>());
		}
		request.getSession().setAttribute("foodCart", foodCart);
		
		return openSelectedFood(food);	
		
		
	}
	
	@RequestMapping(value = "/openCart", method = RequestMethod.GET)
	public ModelAndView viewCart(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("foodMenu") FoodMenu foodMenu) {
		
		ModelAndView modelView = new ModelAndView();
		FoodCart foodCart = (FoodCart) request.getSession().getAttribute("foodCart");
		if(foodCart != null) {
			modelView.setViewName("cart/view_cart"); 
			modelView.addObject("foodCart", foodCart); 
		}else {
			modelView.setViewName("menu/food_menu"); 
			modelView.addObject("emptyCart", "No item selected"); 
		}
		
		return modelView;
		
	}

	private ModelAndView openSelectedFood(foodItem food) {
		
		FoodItem foodObj = new FoodItem();
		ModelAndView modelView = new ModelAndView();
		
		switch (food) {
		case burgerView:
			modelView.setViewName("menu/burger");
			modelView.addObject("burger",foodObj);	
			break;
		case cakeView:
			modelView.setViewName("menu/cake");
			modelView.addObject("cake", foodObj);			
			break;
		case cheeseCakeView:
			modelView.setViewName("menu/cheese_cake");
			modelView.addObject("cheese_cake", foodObj);			
			break;
		case chickenView:
			modelView.setViewName("menu/chicken");
			modelView.addObject("chicken", new FoodItem());			
			break;
		case chocoCakeView:
			modelView.setViewName("menu/choco_cake");
			modelView.addObject("choco_cake", foodObj);			
			break;
		case combo1View:
			modelView.setViewName("menu/combo1");
			modelView.addObject("combo1", foodObj);			
			break;
		case combo2View:
			modelView.setViewName("menu/combo2");
			modelView.addObject("combo2", foodObj);			
			break;
		case pizzaView:
			modelView.setViewName("menu/pizza");
			modelView.addObject("pizza", foodObj);			
			break;
		case noodle2View:
			modelView.setViewName("menu/egg_noodle");
			modelView.addObject("egg_noodle", foodObj);			
			break;
		case smallCakeView:
			modelView.setViewName("menu/small_cake");
			modelView.addObject("small_cake", foodObj);			
			break;
		case riceView:
			modelView.setViewName("menu/rice");
			modelView.addObject("rice", foodObj);			
			break;
		case vegrollView:
			modelView.setViewName("menu/vegroll");
			modelView.addObject("vegroll", foodObj);			
			break;
		case noodleView:
			modelView.setViewName("menu/noddle");
			modelView.addObject("noddle", foodObj);			
			break;
		case veggiesView:
			modelView.setViewName("menu/veggies");
			modelView.addObject("veggies", foodObj);			
			break;
		case saladView:
			modelView.setViewName("menu/salad");
			modelView.addObject("salad", foodObj);			
			break;
		
		}
		return modelView;
	}

	

}
