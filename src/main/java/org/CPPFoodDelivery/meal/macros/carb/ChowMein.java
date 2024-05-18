package org.CPPFoodDelivery.meal.macros.carb;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class ChowMein extends Carb {
    protected ChowMein() {
        super("Chow Mein", Set.of(DietRestriction.VEGAN, DietRestriction.NUT_ALLERGY));
    }
}
