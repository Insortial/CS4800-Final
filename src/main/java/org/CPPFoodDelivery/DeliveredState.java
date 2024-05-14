package org.CPPFoodDelivery;

public class DeliveredState implements OrderState{
    @Override
    public void getOrderStatus(Order order) {
        System.out.println("Order has been delivered");
    }

    @Override
    public void makeOrder(Order order) {

    }

    @Override
    public void pickupOrder(Order order) {

    }

    @Override
    public void deliverOrder(Order order) {

    }
}
