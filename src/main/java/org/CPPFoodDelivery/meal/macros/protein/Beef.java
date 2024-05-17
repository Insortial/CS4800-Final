package org.CPPFoodDelivery.meal.macros.protein;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Beef extends Protein {
    protected Beef() {
        super("Beef", Set.of(DietRestriction.PALEO, DietRestriction.NUT_ALLERGY));
    }
}
