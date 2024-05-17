package org.CPPFoodDelivery.meal.macros.carb;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Bread extends Carb {
    protected Bread() {
        super("Bread", Set.of(DietRestriction.VEGAN, DietRestriction.NUT_ALLERGY));
    }
}
