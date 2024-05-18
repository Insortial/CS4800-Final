import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.meal.MealFactory;
import org.junit.jupiter.api.Test;

public class MealTest {
    private Meal meal = MealFactory.createMeal("Bread", "Avocado", "Beef");
}
