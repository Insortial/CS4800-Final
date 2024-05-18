import org.CPPFoodDelivery.meal.DietRestriction;
import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.meal.MealFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MealFactoryTest {
    private Meal meal = MealFactory.createMeal("Bread", "Avocado", "Beef");

    @Test
    public void mealCanBeMadeWithFactory() {
        assertEquals("Bread, Avocado, and Beef\nToppings: ", meal.toString());
    }

    @Test
    public void canModifyMealToDietRestriction() {
        assertFalse(meal.isProteinAllowedByDiet(DietRestriction.VEGAN));
        Meal newMeal = MealFactory.createModifiedMeal(meal, DietRestriction.VEGAN);
        assertTrue(newMeal.isCarbAllowedByDiet(DietRestriction.VEGAN));
        assertTrue(newMeal.isFatAllowedByDiet(DietRestriction.VEGAN));
        assertTrue(newMeal.isProteinAllowedByDiet(DietRestriction.VEGAN));
    }
}
