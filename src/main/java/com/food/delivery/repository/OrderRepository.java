package com.food.delivery.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.delivery.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
