package com.food.delivery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.food.delivery.model.User;
import com.food.delivery.service.UserService;
import com.food.delivery.view.Login;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
		
	  @Autowired
	  UserService userService;
	  
	 	
	  @RequestMapping(value = "/loadLogin", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView(Messages.getString("HOME_LOGIN")); 
	    mav.addObject(Messages.getString("LOGIN"), new Login()); 
	
	    return mav;
	  }
	
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("login") Login login) {
	    ModelAndView mav = new ModelAndView();
	    User user = userService.login(login);
	
	    if (user != null) {
	    	mav.setViewName("menu/food_menu"); 
	      mav.addObject(Messages.getString("FIRSTNAME"), user.getFirstname()); 
	    } else {
	    	mav.setViewName(Messages.getString("HOME_LOGIN")); 
	    	mav.addObject(Messages.getString("MESSAGE"), Messages.getString("INVALID_USER")); 
	    }
	
	    return mav;
	  }
	
}
