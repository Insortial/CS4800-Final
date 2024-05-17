package org.CPPFoodDelivery.user;

import org.CPPFoodDelivery.meal.DietRestriction;
import org.CPPFoodDelivery.server.Server;
import org.CPPFoodDelivery.order.Order;

public class Customer extends User {
    private DietRestriction dietaryRestriction;

    public Customer(String name, String address, String county, DietRestriction dietaryRestriction) {
        super(name, address, county);
        this.dietaryRestriction = dietaryRestriction;
    }

    public void placeOrder(Order order) {
        getRegisteredServer().placeOrder(order);
    }

    public void notifyOrderMade(Order order) {
        System.out.println("Message to Customer: Order has been made by the restaurant\nOrder: " + order.toString());
    }

    public void notifyOrderPickedUp(Order order) {
        System.out.println("Message to Customer: Order has been picked up by the driver\nOrder: " + order.toString());
    }

    public void receiveOrder(Order order) {
        System.out.println("Message to Customer: Order has been delivered\nOrder: " + order.toString());
    }

    public DietRestriction getDietaryRestriction() {
        return dietaryRestriction;
    }

    @Override
    public void registerToServer(Server server) {
        super.registerToServer(server);
        server.registerCustomer(this);
    }
}
