package org.CPPFoodDelivery.meal.macros.carb;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Pasta extends Carb {
    protected Pasta() {
        super("Pasta", Set.of(DietRestriction.VEGAN, DietRestriction.NUT_ALLERGY));
    }
}
