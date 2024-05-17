package org.CPPFoodDelivery.meal.macros.fat;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Avocado extends Fat {
    protected Avocado() {
        super("Avocado", Set.of(DietRestriction.PALEO, DietRestriction.VEGAN, DietRestriction.NUT_ALLERGY));
    }
}
