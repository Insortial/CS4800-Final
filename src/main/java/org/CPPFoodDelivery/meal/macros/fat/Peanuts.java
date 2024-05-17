package org.CPPFoodDelivery.meal.macros.fat;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Peanuts extends Fat {
    protected Peanuts() {
        super("Peanuts", Set.of(DietRestriction.PALEO, DietRestriction.VEGAN));
    }
}
