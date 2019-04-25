package com.food.delivery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.food.delivery.model.User;
import com.food.delivery.service.UserService;


@Controller
public class RegistrationController {
	
  @Autowired
  public UserService userService;

  @RequestMapping(value = "/loadRegister", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView(Messages.getString("HOME_REGISTER")); 
    mav.addObject(Messages.getString("USER"), new User()); 

    return mav;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("user") User user) {

	  System.out.println("phone----------------->"+user.getPhone());
	  user = userService.addUser(user);

		return new ModelAndView(Messages.getString("HOME_WELCOME"),
				Messages.getString("FIRSTNAME"), user.getFirstname()); 
  }
}
