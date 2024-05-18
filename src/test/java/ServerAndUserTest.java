import org.CPPFoodDelivery.meal.DietRestriction;
import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.meal.MealFactory;
import org.CPPFoodDelivery.order.Order;
import org.CPPFoodDelivery.server.Server;
import org.CPPFoodDelivery.user.Customer;
import org.CPPFoodDelivery.user.Driver;
import org.CPPFoodDelivery.user.Restaurant;
import org.CPPFoodDelivery.user.RestaurantBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServerAndUserTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    private Restaurant restaurant;
    private Customer customer;
    private Driver driver;
    private Server server;
    private Meal meal;

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(out));

        server = new Server();
        server.addServiceableCounty("County", LocalTime.of(0,0), LocalTime.of(23,59));

        driver = new Driver("Name", "Address", "County");
        driver.registerToServer(server);

        meal = MealFactory.createMeal("Bread", "Peanuts", "Fish");
        restaurant = new RestaurantBuilder()
                .setName("Name")
                .setCuisineType("Cuisine")
                .setAddress("Address")
                .setCounty("County")
                .setOperatingHoursStart(LocalTime.of(0,0))
                .setOperatingHoursEnd(LocalTime.of(23, 59))
                .addAvailableMeal(meal)
                .addAvailableTopping("Cheese")
                .build();
        restaurant.registerToServer(server);

        customer = new Customer("Name", "Address", "County", DietRestriction.NO_RESTRICTION);
        customer.registerToServer(server);
    }

    @AfterEach
    public void teardown() {
        System.setOut(standardOut);
    }

    @Test
    public void customerCanPlaceOrder() {
        customer.placeOrder(new Order(restaurant, customer, new ArrayList<>(), LocalTime.of(13,0)));
        assertEquals("Driver Name has been assigned\n" +
                "Message to Restaurant: Order has been placed by the customer\n" +
                "Order: Order at Name for 0 meals", out.toString().trim());
    }

    @Test
    public void restaurantCanMakeOrder() {
        customer.placeOrder(new Order(restaurant, customer, new ArrayList<>(), LocalTime.of(13,0)));
        restaurant.makeOrder();
        assertEquals("Driver Name has been assigned\n" +
                "Message to Restaurant: Order has been placed by the customer\n" +
                "Order: Order at Name for 0 meals\n" +
                "Message to Customer: Order has been made by the restaurant\n" +
                "Order: Order at Name for 0 meals\n" +
                "Message to Driver: Order has been made and is ready for pick up\n" +
                "Order: Order at Name for 0 meals", out.toString().trim());
    }

    @Test
    public void driverCanPickUpOrder() {
        customer.placeOrder(new Order(restaurant, customer, new ArrayList<>(), LocalTime.of(13,0)));
        restaurant.makeOrder();
        driver.pickupOrder();
        assertEquals("Driver Name has been assigned\n" +
                "Message to Restaurant: Order has been placed by the customer\n" +
                "Order: Order at Name for 0 meals\n" +
                "Message to Customer: Order has been made by the restaurant\n" +
                "Order: Order at Name for 0 meals\n" +
                "Message to Driver: Order has been made and is ready for pick up\n" +
                "Order: Order at Name for 0 meals\n" +
                "Message to Restaurant: Order has been picked up by the driver\n" +
                "Order: Order at Name for 0 meals\n" +
                "Message to Customer: Order has been picked up by the driver\n" +
                "Order: Order at Name for 0 meals", out.toString().trim());
    }

    @Test
    public void driverCanDeliverOrder() {
        customer.placeOrder(new Order(restaurant, customer, new ArrayList<>(), LocalTime.of(13,0)));
        restaurant.makeOrder();
        driver.pickupOrder();
        driver.deliverOrder();
        assertEquals("Driver Name has been assigned\n" +
                "Message to Restaurant: Order has been placed by the customer\n" +
                "Order: Order at Name for 0 meals\n" +
                "Message to Customer: Order has been made by the restaurant\n" +
                "Order: Order at Name for 0 meals\n" +
                "Message to Driver: Order has been made and is ready for pick up\n" +
                "Order: Order at Name for 0 meals\n" +
                "Message to Restaurant: Order has been picked up by the driver\n" +
                "Order: Order at Name for 0 meals\n" +
                "Message to Customer: Order has been picked up by the driver\n" +
                "Order: Order at Name for 0 meals\n" +
                "Message to Customer: Order has been delivered\n" +
                "Order: Order at Name for 0 meals", out.toString().trim());
    }
}
