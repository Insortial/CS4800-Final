package org.CPPFoodDelivery.meal.macros.carb;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.List;
import java.util.Random;

public class CarbFactory {
    private static final List<Carb> CARBS = List.of();

    public static Carb createRandomCarb() {
        if (CARBS.isEmpty()) return null;

        int randomIndex = new Random().nextInt(CARBS.size());
        return CARBS.get(randomIndex);
    }

    public static Carb createCarbByName(String carbName) {
        for (Carb carb : CARBS) {
            if (carb.getMacroName().equals(carbName))
                return carb;
        }
        return null;
    }

    public static Carb createCarbByDietRestriction(DietRestriction dietRestriction) {
        for (Carb carb : CARBS) {
            if (carb.isDietAllowed(dietRestriction))
                return carb;
        }
        return null;
    }
}
