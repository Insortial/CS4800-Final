package org.CPPFoodDelivery.meal;

import org.CPPFoodDelivery.meal.macros.carb.Carb;
import org.CPPFoodDelivery.meal.macros.fat.Fat;
import org.CPPFoodDelivery.meal.macros.protein.Protein;

public class Meal implements Cloneable {
    private Carb carb;
    private Fat fat;
    private Protein protein;

    protected Meal(Carb carb, Fat fat, Protein protein) {
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
    }

    public String toString() {
        String mealName = carb.getMacroName() + ", " + fat.getMacroName() + ", and " + protein.getMacroName() + "\nToppings: ";
        return mealName;
    }

    public Carb getCarb() {
        return carb;
    }

    public Fat getFat() {
        return fat;
    }

    public Protein getProtein() {
        return protein;
    }

    public boolean isCarbAllowedByDiet(DietRestriction dietRestriction) {
        return carb.isDietAllowed(dietRestriction);
    }

    public boolean isFatAllowedByDiet(DietRestriction dietRestriction) {
        return fat.isDietAllowed(dietRestriction);
    }

    public boolean isProteinAllowedByDiet(DietRestriction dietRestriction) {
        return protein.isDietAllowed(dietRestriction);
    }

    public void setCarb(Carb carb) {
        this.carb = carb;
    }

    public void setFat(Fat fat) {
        this.fat = fat;
    }

    public void setProtein(Protein protein) {
        this.protein = protein;
    }

    @Override
    protected Meal clone() {
        try {
            return (Meal) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cannot clone Meal");
        }
    }
}
