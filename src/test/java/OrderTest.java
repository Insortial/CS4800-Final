import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.CPPFoodDelivery.*;

public class OrderTest {
    @Test
    public void testGetOrderStatus() {
        Customer testCustomer = new Customer("TestCustomer", "123 Main St, Los Angeles, CA", "Los Angeles", DietRestriction.PALEO);
        Restaurant testRestaurant = new Restaurant();
        Meal testMeal = new Meal();
        Driver testDriver = new Driver("TestDriver", "323 Straight St, Los Angeles, CA", "Los Angeles");
        Order testOrder = new Order(testRestaurant, testCustomer, testMeal, testDriver);
        OrderState orderState1 = testOrder.getState();
        testOrder.getOrderStatus();

        testOrder.makeOrder();
        testOrder.getOrderStatus();
        OrderState orderState2 = testOrder.getState();


        testOrder.pickupOrder();
        testOrder.getOrderStatus();
        OrderState orderState3 = testOrder.getState();

        testOrder.deliverOrder();
        testOrder.getOrderStatus();
        OrderState orderState4 = testOrder.getState();


        Assertions.assertTrue(orderState1 instanceof OrderPlacedState);
        Assertions.assertTrue(orderState2 instanceof OrderMadeState);
        Assertions.assertTrue(orderState3 instanceof PickedUpState);
        Assertions.assertTrue(orderState4 instanceof DeliveredState);
    }


}
