package org.CPPFoodDelivery.meal.macros.carb;

import org.CPPFoodDelivery.meal.DietRestriction;
import org.CPPFoodDelivery.meal.macros.Macronutrient;

import java.util.Set;

public abstract class Carb extends Macronutrient {
    public Carb(String macroName, Set<DietRestriction> allowedDiets) {
        super(macroName, allowedDiets);
    }
}
