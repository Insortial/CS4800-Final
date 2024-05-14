package org.CPPFoodDelivery;

public class OrderMadeState implements OrderState{
    @Override
    public void getOrderStatus(Order order) {
        System.out.println("Order has been made");
    }

    @Override
    public void makeOrder(Order order) {

    }

    @Override
    public void pickupOrder(Order order) {
        order.setState(new PickedUpState());
    }

    @Override
    public void deliverOrder(Order order) {

    }
}
