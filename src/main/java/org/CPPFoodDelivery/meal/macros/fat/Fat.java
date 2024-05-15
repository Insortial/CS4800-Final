package org.CPPFoodDelivery.meal.macros.fat;

import org.CPPFoodDelivery.meal.DietRestriction;
import org.CPPFoodDelivery.meal.macros.Macronutrient;

import java.util.Set;

public abstract class Fat extends Macronutrient {
    public Fat(String macroName, Set<DietRestriction> allowedDiets) {
        super(macroName, allowedDiets);
    }
}
