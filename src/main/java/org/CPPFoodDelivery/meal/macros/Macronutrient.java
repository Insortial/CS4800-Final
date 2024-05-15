package org.CPPFoodDelivery.meal.macros;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.Set;

public abstract class Macronutrient {
    private String macroName;
    private Set<DietRestriction> allowedDiets;

    public Macronutrient(String macroName, Set<DietRestriction> allowedDiets) {
        this.macroName = macroName;
        this.allowedDiets = allowedDiets;
    }

    public String getMacroName() {
        return macroName;
    }

    public boolean isDietAllowed(DietRestriction dietRestriction) {
        return allowedDiets.contains(dietRestriction);
    }
}
