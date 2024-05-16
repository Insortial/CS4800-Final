package org.CPPFoodDelivery.meal.toppings;

import org.CPPFoodDelivery.meal.Meal;

public class SourCream extends Topping {
    public SourCream(Meal meal) {
        super(meal);
    }

    @Override
    public String toString() {
        return super.toString() + "Sour Cream";
    }
}