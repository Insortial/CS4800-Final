package org.CPPFoodDelivery;

public class OrderPlacedState implements OrderState{
    @Override
    public void getOrderStatus(Order order) {
        System.out.println("Order is being prepared");
    }

    @Override
    public void makeOrder(Order order) {
        order.setState(new OrderMadeState());
    }

    @Override
    public void pickupOrder(Order order) {

    }

    @Override
    public void deliverOrder(Order order) {

    }
}
