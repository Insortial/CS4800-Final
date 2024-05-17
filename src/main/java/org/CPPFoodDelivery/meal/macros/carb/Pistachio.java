package org.CPPFoodDelivery.meal.macros.carb;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Pistachio extends Carb {
    protected Pistachio() {
        super("Pistachio", Set.of(DietRestriction.PALEO, DietRestriction.VEGAN));
    }
}
