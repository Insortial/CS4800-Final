package org.CPPFoodDelivery.meal.macros.fat;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class SesameOil extends Fat {
    protected SesameOil() {
        super("Sesame Oil", Set.of(DietRestriction.NUT_ALLERGY, DietRestriction.VEGAN));
    }
}
