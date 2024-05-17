package org.CPPFoodDelivery.meal.macros.protein;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.List;
import java.util.Random;

public class ProteinFactory {
    private static final List<Protein> PROTEINS = List.of(
            new Beef(),
            new Chicken(),
            new Fish(),
            new Tofu()
    );

    public static Protein createRandomProtein() {
        if (PROTEINS.isEmpty()) return null;

        int randomIndex = new Random().nextInt(PROTEINS.size());
        return PROTEINS.get(randomIndex);
    }

    public static Protein createProteinByName(String carbName) {
        for (Protein protein : PROTEINS) {
            if (protein.getMacroName().equals(carbName))
                return protein;
        }
        return null;
    }

    public static Protein createProteinByDietRestriction(DietRestriction dietRestriction) {
        for (Protein protein : PROTEINS) {
            if (protein.isDietAllowed(dietRestriction))
                return protein;
        }
        return null;
    }
}
