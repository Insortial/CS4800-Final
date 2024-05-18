package org.CPPFoodDelivery.meal.macros.carb;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Tortilla extends Carb {
    protected Tortilla() {
        super("Tortilla", Set.of(DietRestriction.VEGAN, DietRestriction.NUT_ALLERGY));
    }
}
