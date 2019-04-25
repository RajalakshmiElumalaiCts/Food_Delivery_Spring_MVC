package com.food.delivery.view;

import java.util.List;

import com.food.delivery.model.FoodItem;

public class FoodCart {
	
	private List<FoodItem> selectedFood;

	public List<FoodItem> getSelectedFood() {
		return selectedFood;
	}

	public void setSelectedFood(List<FoodItem> selectedFood) {
		this.selectedFood = selectedFood;
	}

}
