package org.CPPFoodDelivery.meal.macros.protein;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class Tofu extends Protein {
    public Tofu() {
        super("Tofu", Set.of(DietRestriction.VEGAN, DietRestriction.NUT_ALLERGY));
    }
}
