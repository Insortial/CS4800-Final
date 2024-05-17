import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.meal.MealFactory;
import org.CPPFoodDelivery.meal.toppings.MealWithTopping;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToppingTest {
    private static Meal meal = MealFactory.createMeal("Bread", "Avocado", "Beef");

    @Test
    public void canDecorateMeal() {
        Meal meal = new MealWithTopping(this.meal, "Cheese");
        assertEquals("Bread, Avocado, and Beef\nToppings: Cheese", meal.toString().trim());
    }
}
