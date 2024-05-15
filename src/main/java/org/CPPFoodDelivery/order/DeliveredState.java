package org.CPPFoodDelivery.order;

import org.CPPFoodDelivery.order.Order;
import org.CPPFoodDelivery.order.OrderState;
import org.CPPFoodDelivery.user.Driver;

public class DeliveredState implements OrderState {
    @Override
    public void getOrderStatus(Order order) {
        System.out.println("Order has been delivered");
    }

    @Override
    public void placeOrder(Order order, Driver assignedDriver) {
        throw new IllegalStateException("Cannot place order after delivery");
    }

    @Override
    public void makeOrder(Order order) {
        throw new IllegalStateException("Cannot make order after delivery");
    }

    @Override
    public void pickupOrder(Order order) {
        throw new IllegalStateException("Cannot pickup order after delivery");
    }

    @Override
    public void deliverOrder(Order order) {
        throw new IllegalStateException("Cannot deliver order again");
    }
}
