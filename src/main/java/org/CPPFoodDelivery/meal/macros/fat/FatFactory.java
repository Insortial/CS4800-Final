package org.CPPFoodDelivery.meal.macros.fat;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.List;
import java.util.Random;

public class FatFactory {
    private static final List<Fat> FATS = List.of();

    public static Fat createRandomFat() {
        if (FATS.isEmpty()) return null;

        int randomIndex = new Random().nextInt(FATS.size());
        return FATS.get(randomIndex);
    }

    public static Fat createFatByName(String carbName) {
        for (Fat fat : FATS) {
            if (fat.getMacroName().equals(carbName))
                return fat;
        }
        return null;
    }

    public static Fat createFatByDietRestriction(DietRestriction dietRestriction) {
        for (Fat fat : FATS) {
            if (fat.isDietAllowed(dietRestriction))
                return fat;
        }
        return null;
    }
}
