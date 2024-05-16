package org.CPPFoodDelivery.meal.toppings;

import org.CPPFoodDelivery.meal.Meal;

public class Cheese extends Topping {
    public Cheese(Meal meal) {
        super(meal);
    }

    @Override
    public String toString() {
        return super.toString() + "Cheese";
    }
}
