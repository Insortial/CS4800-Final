package org.CPPFoodDelivery.meal;

import org.CPPFoodDelivery.meal.macros.carb.Carb;
import org.CPPFoodDelivery.meal.macros.carb.CarbFactory;
import org.CPPFoodDelivery.meal.macros.fat.Fat;
import org.CPPFoodDelivery.meal.macros.fat.FatFactory;
import org.CPPFoodDelivery.meal.macros.protein.Protein;
import org.CPPFoodDelivery.meal.macros.protein.ProteinFactory;

public class MealFactory {
    public static Meal createMeal(String carbName, String fatName, String proteinName) {
        Carb carb = CarbFactory.createCarbByName(carbName);
        Fat fat = FatFactory.createFatByName(fatName);
        Protein protein = ProteinFactory.createProteinByName(proteinName);

        return new Meal(carb, fat, protein);
    }

    public static Meal createModifiedMeal(Meal baseMeal, DietRestriction dietRestriction) {
        Meal newMeal = baseMeal.clone();

        if (!newMeal.isCarbAllowedByDiet(dietRestriction)) {
            newMeal.setCarb(CarbFactory.createCarbByDietRestriction(dietRestriction));
        }

        if (!newMeal.isFatAllowedByDiet(dietRestriction)) {
            newMeal.setFat(FatFactory.createFatByDietRestriction(dietRestriction));
        }

        if (!newMeal.isProteinAllowedByDiet(dietRestriction)) {
            newMeal.setProtein(ProteinFactory.createProteinByDietRestriction(dietRestriction));
        }

        return newMeal;
    }
}
