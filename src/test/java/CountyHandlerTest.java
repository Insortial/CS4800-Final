import org.CPPFoodDelivery.server.CountyHandler;
import org.CPPFoodDelivery.user.Driver;
import org.CPPFoodDelivery.user.Restaurant;
import org.CPPFoodDelivery.user.RestaurantBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountyHandlerTest {
    private CountyHandler handler;

    @BeforeEach
    public void setup() {
        handler = new CountyHandler("County 1", LocalTime.of(0, 0), LocalTime.of(23, 59));
    }

    @Test
    public void canAddAndGetNewDrivers() {
        Driver driver = new Driver("Name", "Address", "County 1");

        handler.addDriver(driver);
        assertEquals(driver, handler.getAvailableDriverByCounty("County 1", LocalTime.of(12, 0)));
    }

    @Test
    public void canAddAndGetNewRestaurants() {
        Restaurant restaurant = new RestaurantBuilder().setCounty("County 1")
                .setName("Name")
                .setAddress("Address")
                .setCuisineType("Cuisine")
                .setOperatingHoursStart(LocalTime.of(0,0))
                .setOperatingHoursEnd(LocalTime.of(23,59))
                .build();

        handler.addRestaurant(restaurant);
        assertTrue(handler.getRestaurantsByCounty("County 1").contains(restaurant));
    }

    @Test
    public void canAddNewCounties() {
        Driver driver = new Driver("Name", "Address", "County 2");
        
        handler.addCounty("County 2", LocalTime.of(0,0), LocalTime.of(23, 59));
        handler.addDriver(driver);
        assertEquals(driver, handler.getAvailableDriverByCounty("County 2", LocalTime.of(12, 0)));
    }
}
