package org.CPPFoodDelivery.meal.macros.carb;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Cheese extends Carb {

    protected Cheese() {
        super("Cheese", Set.of(DietRestriction.NUT_ALLERGY));
    }
}
