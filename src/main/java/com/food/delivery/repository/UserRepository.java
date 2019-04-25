package com.food.delivery.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.delivery.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByUsername(String username);
}
