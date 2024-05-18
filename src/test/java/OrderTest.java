import org.CPPFoodDelivery.meal.DietRestriction;
import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.meal.MealFactory;
import org.CPPFoodDelivery.order.*;
import org.CPPFoodDelivery.server.Server;
import org.CPPFoodDelivery.user.Customer;
import org.CPPFoodDelivery.user.Driver;
import org.CPPFoodDelivery.user.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.*;

public class OrderTest {
    @Test
    public void testGetOrderStatus() {
        Server testServer = new Server();
        testServer.addServiceableCounty("Los Angeles", LocalTime.of(0, 0), LocalTime.of(23, 59));

        Customer testCustomer = new Customer("TestCustomer", "123 Main St, Los Angeles, CA", "Los Angeles", DietRestriction.PALEO);
        Restaurant testRestaurant = new Restaurant("Name", "Address", "Los Angeles", LocalTime.of(0, 0), LocalTime.of(23, 59), "Cuisine", new ArrayList<>(), new ArrayList<>());
        Driver testDriver = new Driver("TestDriver", "323 Straight St, Los Angeles, CA", "Los Angeles");

        testCustomer.registerToServer(testServer);
        testRestaurant.registerToServer(testServer);
        testDriver.registerToServer(testServer);

        Order testOrder = new Order(testRestaurant, testCustomer, List.of(), LocalTime.of(13,0));

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


        Assertions.assertInstanceOf(OrderPlacedState.class, orderState1);
        Assertions.assertInstanceOf(OrderMadeState.class, orderState2);
        Assertions.assertInstanceOf(PickedUpState.class, orderState3);
        Assertions.assertInstanceOf(DeliveredState.class, orderState4);
    }

}
