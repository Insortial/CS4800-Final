package org.CPPFoodDelivery.meal.toppings;
import org.CPPFoodDelivery.meal.Meal;

public class MealWithTopping extends Meal {
    private Meal mealWithTopping;
    private String toppingName;

    public MealWithTopping(Meal meal, String toppingName) {
        super(meal.getCarb(), meal.getFat(), meal.getProtein());
        mealWithTopping = meal;
        this.toppingName = toppingName;
    }

    public String toString() {
        return mealWithTopping.toString() + toppingName;
    }
}
