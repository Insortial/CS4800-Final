package org.CPPFoodDelivery.order;

import org.CPPFoodDelivery.user.Driver;

public class OrderCreatedState implements OrderState {
    private static OrderCreatedState instance;

    private OrderCreatedState() { }

    @Override
    public void getOrderStatus(Order order) {
        System.out.println("Order has been created");
    }

    @Override
    public void placeOrder(Order order, Driver assignedDriver) {
        order.setState(OrderPlacedState.getInstance());

        order.assignDriver(assignedDriver);
        assignedDriver.assignOrder(order);
        order.getRestaurant().placeOrder(order);
    }

    @Override
    public void pickupOrder(Order order) {
        throw new IllegalStateException("Cannot pickup order that is not placed");
    }

    @Override
    public void makeOrder(Order order) {
        throw new IllegalStateException("Cannot make order that is not placed");
    }

    @Override
    public void deliverOrder(Order order) {
        throw new IllegalStateException("Cannot deliver order that is not placed");
    }

    public static OrderCreatedState getInstance() {
        if (instance == null) {
            instance = new OrderCreatedState();
        }
        return instance;
    }
}
