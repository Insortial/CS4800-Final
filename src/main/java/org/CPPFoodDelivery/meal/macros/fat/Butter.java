package org.CPPFoodDelivery.meal.macros.fat;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Butter extends Fat {
    protected Butter() {
        super("Butter", Set.of(DietRestriction.NUT_ALLERGY, DietRestriction.PALEO));
    }
}
