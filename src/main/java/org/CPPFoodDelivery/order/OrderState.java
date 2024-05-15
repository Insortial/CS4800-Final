package org.CPPFoodDelivery.order;

import org.CPPFoodDelivery.user.Driver;

public interface OrderState {
    void getOrderStatus(Order order);
    void placeOrder(Order order, Driver assignedDriver);
    void pickupOrder(Order order);
    void makeOrder(Order order);
    void deliverOrder(Order order);


}
