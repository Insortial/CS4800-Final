package org.CPPFoodDelivery;

public interface OrderState {
    String getOrderStatus();
    void pickupOrder();
    void makeOrder();
    void deliverOrder();


}
