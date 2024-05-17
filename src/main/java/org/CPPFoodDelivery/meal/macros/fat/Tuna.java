package org.CPPFoodDelivery.meal.macros.fat;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Tuna extends Fat {
    protected Tuna() {
        super("Tuna", Set.of(DietRestriction.PALEO, DietRestriction.NUT_ALLERGY));
    }
}
