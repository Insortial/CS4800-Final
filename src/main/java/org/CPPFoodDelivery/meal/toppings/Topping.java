package org.CPPFoodDelivery.meal.toppings;
import org.CPPFoodDelivery.meal.Meal;

public abstract class Topping extends Meal {
    protected Meal mealWithTopping;
    public Topping(Meal meal) {
        super(meal.getCarb(), meal.getFat(), meal.getProtein());
    }

    public String toString() {
        return super.toString();
    }
}
