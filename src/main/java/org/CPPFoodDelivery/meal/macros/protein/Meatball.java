package org.CPPFoodDelivery.meal.macros.protein;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Meatball extends Protein {
    protected Meatball() {
        super("Meatball", Set.of(DietRestriction.NUT_ALLERGY, DietRestriction.PALEO));
    }
}
