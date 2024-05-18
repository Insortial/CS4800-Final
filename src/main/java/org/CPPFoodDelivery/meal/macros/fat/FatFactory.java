package org.CPPFoodDelivery.meal.macros.fat;

import org.CPPFoodDelivery.meal.DietRestriction;

import java.util.List;
import java.util.Random;

public class FatFactory {
    private static final List<Fat> FATS = List.of(
            new Avocado(),
            new Peanuts(),
            new SourCream(),
            new Tuna(),
            new Butter(),
            new SesameOil()
    );

    public static Fat createRandomFat() {
        if (FATS.isEmpty()) return null;

        int randomIndex = new Random().nextInt(FATS.size());
        return FATS.get(randomIndex);
    }

    public static Fat createFatByName(String fatName) {
        for (Fat fat : FATS) {
            if (fat.getMacroName().equals(fatName))
                return fat;
        }
        throw new IllegalArgumentException(fatName + " is not a valid Fat");
    }

    public static Fat createFatByDietRestriction(DietRestriction dietRestriction) {
        for (Fat fat : FATS) {
            if (fat.isDietAllowed(dietRestriction))
                return fat;
        }
        throw new IllegalArgumentException("There is no fat for this diet");
    }
}
