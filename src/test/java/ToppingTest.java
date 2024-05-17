import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.meal.MealFactory;
import org.CPPFoodDelivery.meal.toppings.CheeseTopping;
import org.CPPFoodDelivery.meal.toppings.LettuceTopping;
import org.CPPFoodDelivery.meal.toppings.SourCreamTopping;
import org.CPPFoodDelivery.meal.toppings.Topping;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToppingTest {
    private static Meal meal = MealFactory.createMeal("Bread", "Avocado", "Beef");

    public static Stream<Arguments> provideToppings() {
        return Stream.of(
                Arguments.of(new CheeseTopping(meal), "Bread, Avocado, and Beef\nToppings: Cheese"),
                Arguments.of(new LettuceTopping(meal), "Bread, Avocado, and Beef\nToppings: Lettuce"),
                Arguments.of(new SourCreamTopping(meal), "Bread, Avocado, and Beef\nToppings: Sour Cream")
        );
    }

    @ParameterizedTest
    @MethodSource("provideToppings")
    public void canDecorateMeal(Topping topping, String expected) {
        assertEquals(expected, topping.toString());
    }
}
