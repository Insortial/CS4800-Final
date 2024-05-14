package org.CPPFoodDelivery;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Queue;

public class Restaurant extends User {
    private LocalDateTime operatingHoursStart;
    private LocalDateTime operatingHoursEnd;
    private String cuisineType;
    private List<String> toppingNames;
    // private List<Meal> meals;
    // private Queue<Order> order;

    public Restaurant() {
        super(null, null, null);
        // TODO
    }

    public void placeOrder() {
        // TODO
    }

    public void makeOrder() {

    }

    public void pickupOrder() {

    }

    @Override
    public void registerToServer(Server server) {
        super.registerToServer(server);
        server.registerRestaurant(this);
    }
}
