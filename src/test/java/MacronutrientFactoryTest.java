import org.CPPFoodDelivery.meal.DietRestriction;
import org.CPPFoodDelivery.meal.macros.carb.Carb;
import org.CPPFoodDelivery.meal.macros.carb.CarbFactory;
import org.CPPFoodDelivery.meal.macros.fat.Fat;
import org.CPPFoodDelivery.meal.macros.fat.FatFactory;
import org.CPPFoodDelivery.meal.macros.protein.Protein;
import org.CPPFoodDelivery.meal.macros.protein.ProteinFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MacronutrientFactoryTest {
    @Test
    public void canRandomCreateCarb() {
        Carb carb = CarbFactory.createRandomCarb();
        assertNotNull(carb);
    }

    @Test
    public void canCreateCarbFromName() {
        Carb carb = CarbFactory.createCarbByName("Bread");
        assertNotNull(carb);
    }

    @Test
    public void canCreateCarbByDiet() {
        Carb carb = CarbFactory.createCarbByDietRestriction(DietRestriction.VEGAN);
        assertNotNull(carb);
    }

    @Test
    public void canRandomCreateProtein() {
        Protein protein = ProteinFactory.createRandomProtein();
        assertNotNull(protein);
    }

    @Test
    public void canCreateProteinFromName() {
        Protein protein = ProteinFactory.createProteinByName("Chicken");
        assertNotNull(protein);
    }

    @Test
    public void canCreateProteinByDiet() {
        Protein protein = ProteinFactory.createProteinByDietRestriction(DietRestriction.VEGAN);
        assertNotNull(protein);
    }

    @Test
    public void canRandomCreateFat() {
        Fat fat = FatFactory.createRandomFat();
        assertNotNull(fat);
    }

    @Test
    public void canCreateFatFromName() {
        Fat fat = FatFactory.createFatByName("Peanuts");
        assertNotNull(fat);
    }

    @Test
    public void canCreateFatByDiet() {
        Fat fat = FatFactory.createFatByDietRestriction(DietRestriction.VEGAN);
        assertNotNull(fat);
    }
}
