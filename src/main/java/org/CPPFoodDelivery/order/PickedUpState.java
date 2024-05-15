package org.CPPFoodDelivery.order;

import org.CPPFoodDelivery.user.Driver;

public class PickedUpState implements OrderState{
    @Override
    public void getOrderStatus(Order order) {
        System.out.println("Order has been picked up");
    }

    @Override
    public void placeOrder(Order order, Driver assignedDriver) {
        throw new IllegalStateException("Cannot place order that is picked up");
    }

    @Override
    public void makeOrder(Order order) {
        throw new IllegalStateException("Cannot make order that is picked up");
    }

    @Override
    public void pickupOrder(Order order) {
        throw new IllegalStateException("Cannot pickup order again");
    }

    @Override
    public void deliverOrder(Order order) {
        order.setState(new DeliveredState());

        order.getCustomer().receiveOrder(order);
    }
}
