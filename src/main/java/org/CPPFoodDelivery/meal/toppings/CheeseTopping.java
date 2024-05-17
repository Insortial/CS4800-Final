package org.CPPFoodDelivery.meal.toppings;

import org.CPPFoodDelivery.meal.Meal;

public class CheeseTopping extends Topping {
    public CheeseTopping(Meal meal) {
        super(meal);
    }

    @Override
    public String toString() {
        return super.toString() + "Cheese";
    }
}
