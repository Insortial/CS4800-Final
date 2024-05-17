package org.CPPFoodDelivery.meal.macros.protein;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Chicken extends Protein {
    protected Chicken() {
        super("Chicken", Set.of(DietRestriction.PALEO, DietRestriction.NUT_ALLERGY));
    }
}
