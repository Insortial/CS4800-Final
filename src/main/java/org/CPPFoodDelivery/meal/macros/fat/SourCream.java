package org.CPPFoodDelivery.meal.macros.fat;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public class SourCream extends Fat {
    protected SourCream() {
        super("Sour Cream", Set.of(DietRestriction.NUT_ALLERGY));
    }
}
