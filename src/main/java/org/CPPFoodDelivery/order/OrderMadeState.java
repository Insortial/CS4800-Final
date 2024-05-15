package org.CPPFoodDelivery.order;

import org.CPPFoodDelivery.user.Driver;

public class OrderMadeState implements OrderState{
    @Override
    public void getOrderStatus(Order order) {
        System.out.println("Order has been made");
    }

    @Override
    public void placeOrder(Order order, Driver assignedDriver) {
        throw new IllegalStateException("Cannot place order after order is made");
    }

    @Override
    public void makeOrder(Order order) {
        throw new IllegalStateException("Cannot make order again");
    }

    @Override
    public void pickupOrder(Order order) {
        order.setState(new PickedUpState());

        order.getRestaurant().pickupOrder(order);
        order.getCustomer().notifyOrderPickedUp(order);
    }

    @Override
    public void deliverOrder(Order order) {
        throw new IllegalStateException("Cannot deliver order that is not picked up");
    }
}
