import org.CPPFoodDelivery.meal.DietRestriction;
import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.meal.macros.carb.Carb;
import org.CPPFoodDelivery.order.*;
import org.CPPFoodDelivery.server.Server;
import org.CPPFoodDelivery.user.Customer;
import org.CPPFoodDelivery.user.Driver;
import org.CPPFoodDelivery.user.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

public class OrderTest {
    @Test
    public void testGetOrderStatus() {
        Server testServer = new Server();
        Customer testCustomer = new Customer("TestCustomer", "123 Main St, Los Angeles, CA", "Los Angeles", DietRestriction.PALEO);
        Restaurant testRestaurant = new Restaurant("Name", "Address", "Los Angeles", LocalDateTime.now(), LocalDateTime.now(), "Cuisine", new ArrayList<>(), new ArrayList<>());
        Driver testDriver = new Driver("TestDriver", "323 Straight St, Los Angeles, CA", "Los Angeles");

        testCustomer.registerToServer(testServer);
        testRestaurant.registerToServer(testServer);
        testDriver.registerToServer(testServer);
        
        Order testOrder = new Order(testRestaurant, testCustomer, List.of());

        testCustomer.placeOrder(testOrder);
        OrderState orderState1 = testOrder.getState();
        testOrder.getOrderStatus();

        testRestaurant.makeOrder();
        testOrder.getOrderStatus();
        OrderState orderState2 = testOrder.getState();

        testDriver.pickupOrder();
        testOrder.getOrderStatus();
        OrderState orderState3 = testOrder.getState();

        testDriver.deliverOrder();
        testOrder.getOrderStatus();
        OrderState orderState4 = testOrder.getState();


        Assertions.assertTrue(orderState1 instanceof OrderPlacedState);
        Assertions.assertTrue(orderState2 instanceof OrderMadeState);
        Assertions.assertTrue(orderState3 instanceof PickedUpState);
        Assertions.assertTrue(orderState4 instanceof DeliveredState);
    }

    @Test
    public void testMealAndToppings() {
        List<Meal> testListOfMeals =  new ArrayList<>();
        Set<DietRestriction> dietRestrictions = new HashSet<>();
        dietRestrictions.add(DietRestriction.NO_RESTRICTION);
    }


}
