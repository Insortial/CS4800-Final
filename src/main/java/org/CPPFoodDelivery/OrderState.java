package org.CPPFoodDelivery;

public interface OrderState {
    void getOrderStatus(Order order);
    void pickupOrder(Order order);
    void makeOrder(Order order);
    void deliverOrder(Order order);


}
