import org.CPPFoodDelivery.meal.DietRestriction;
import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.meal.MealFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MealTest {
    private Meal meal = MealFactory.createMeal("Bread", "Avocado", "Beef");

    @Test
    public void canCheckIsCarbAllowedByDiet() {
        assertTrue(meal.isCarbAllowedByDiet(DietRestriction.NO_RESTRICTION));
    }

    @Test
    public void canCheckIsFatAllowedByDiet() {
        assertTrue(meal.isFatAllowedByDiet(DietRestriction.NO_RESTRICTION));
    }

    @Test
    public void canCheckIsProteinAllowedByDiet() {
        assertTrue(meal.isProteinAllowedByDiet(DietRestriction.NO_RESTRICTION));
    }
}
