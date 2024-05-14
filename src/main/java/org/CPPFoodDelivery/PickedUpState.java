package org.CPPFoodDelivery;

public class PickedUpState implements OrderState{
    @Override
    public void getOrderStatus(Order order) {
        System.out.println("Order has been picked up");
    }

    @Override
    public void makeOrder(Order order) {

    }

    @Override
    public void pickupOrder(Order order) {

    }

    @Override
    public void deliverOrder(Order order) {
        order.setState(new DeliveredState());
    }
}
