package org.CPPFoodDelivery.order;

import org.CPPFoodDelivery.user.Driver;

public class OrderPlacedState implements OrderState {
    private static OrderPlacedState instance;

    private OrderPlacedState() { }

    @Override
    public void getOrderStatus(Order order) {
        System.out.println("Order is being prepared");
    }

    @Override
    public void placeOrder(Order order, Driver assignedDriver) {
        throw new IllegalStateException("Cannot place order again");
    }

    @Override
    public void makeOrder(Order order) {
        order.setState(OrderMadeState.getInstance());

        order.getCustomer().notifyOrderMade(order);
        order.getDriver().notifyOrderMade(order);
    }

    @Override
    public void pickupOrder(Order order) {
        throw new IllegalStateException("Cannot pickup order that is not made");
    }

    @Override
    public void deliverOrder(Order order) {
        throw new IllegalStateException("Cannot deliver order that is not made");
    }

    public static OrderPlacedState getInstance() {
        if (instance == null) {
            instance = new OrderPlacedState();
        }
        return instance;
    }
}
