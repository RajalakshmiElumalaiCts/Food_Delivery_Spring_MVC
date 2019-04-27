package com.food.delivery.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.delivery.model.FoodItem;

public interface FoodRepository extends CrudRepository<FoodItem, Integer> {

}
