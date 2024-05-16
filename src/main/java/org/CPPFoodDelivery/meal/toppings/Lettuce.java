package org.CPPFoodDelivery.meal.toppings;

import org.CPPFoodDelivery.meal.Meal;

public class Lettuce extends Topping {
    public Lettuce(Meal meal) {
        super(meal);
    }

    @Override
    public String toString() {
        return super.toString() + "Lettuce";
    }
}