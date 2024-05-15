package org.CPPFoodDelivery.meal.macros.protein;

import org.CPPFoodDelivery.meal.DietRestriction;
import org.CPPFoodDelivery.meal.macros.Macronutrient;

import java.util.Set;

public abstract class Protein extends Macronutrient {
    public Protein(String macroName, Set<DietRestriction> allowedDiets) {
        super(macroName, allowedDiets);
    }
}
