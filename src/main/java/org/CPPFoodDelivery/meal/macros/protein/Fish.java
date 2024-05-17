package org.CPPFoodDelivery.meal.macros.protein;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Fish extends Protein {
    protected Fish() {
        super("Fish", Set.of(DietRestriction.PALEO, DietRestriction.NUT_ALLERGY));
    }
}
