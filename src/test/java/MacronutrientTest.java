import org.CPPFoodDelivery.meal.DietRestriction;
import org.CPPFoodDelivery.meal.macros.Macronutrient;
import org.CPPFoodDelivery.meal.macros.carb.CarbFactory;
import org.CPPFoodDelivery.meal.macros.fat.FatFactory;
import org.CPPFoodDelivery.meal.macros.protein.ProteinFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MacronutrientTest {
    public List<Macronutrient> macros = List.of(
            CarbFactory.createCarbByName("Bread"),
            CarbFactory.createCarbByName("Cheese"),
            CarbFactory.createCarbByName("Lentils"),
            CarbFactory.createCarbByName("Pistachio"),
            FatFactory.createFatByName("Avocado"),
            FatFactory.createFatByName("Peanuts"),
            FatFactory.createFatByName("Sour Cream"),
            FatFactory.createFatByName("Tuna"),
            ProteinFactory.createProteinByName("Beef"),
            ProteinFactory.createProteinByName("Chicken"),
            ProteinFactory.createProteinByName("Fish"),
            ProteinFactory.createProteinByName("Tofu")
    );

    @Test
    public void allMacrosAllowNoRestrictionDiet() {
        for (Macronutrient m : macros) {
            assertTrue(m.isDietAllowed(DietRestriction.NO_RESTRICTION));
        }
    }
}
