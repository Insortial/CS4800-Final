package org.CPPFoodDelivery.meal.toppings;

import org.CPPFoodDelivery.meal.Meal;

public class LettuceTopping extends Topping {
    public LettuceTopping(Meal meal) {
        super(meal);
    }

    @Override
    public String toString() {
        return super.toString() + "Lettuce";
    }
}