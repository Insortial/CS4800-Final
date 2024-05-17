package org.CPPFoodDelivery.meal.toppings;

import org.CPPFoodDelivery.meal.Meal;

public class SourCreamTopping extends Topping {
    public SourCreamTopping(Meal meal) {
        super(meal);
    }

    @Override
    public String toString() {
        return super.toString() + "Sour Cream";
    }
}