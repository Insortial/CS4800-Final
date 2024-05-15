package org.CPPFoodDelivery.user;

import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.server.Server;
import org.CPPFoodDelivery.order.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Restaurant extends User {
    private LocalDateTime operatingHoursStart;
    private LocalDateTime operatingHoursEnd;
    private String cuisineType;
    private List<String> toppingNames;
    private List<Meal> meals;
    private Queue<Order> orders;
    private List<Order> ordersReadyForPickup;

    public Restaurant(String name, String address, String county, LocalDateTime operatingHoursStart,
                      LocalDateTime operatingHoursEnd, String cuisineType) {
        super(name, address, county);
        this.operatingHoursStart = operatingHoursStart;
        this.operatingHoursEnd = operatingHoursEnd;
        this.cuisineType = cuisineType;
        this.toppingNames = new ArrayList<>();
        this.orders = new LinkedList<>();
        this.meals = new ArrayList<>();
        this.ordersReadyForPickup = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Message to Restaurant: Order has been placed by the customer");
    }

    public void makeOrder() {
        Order firstOrder = orders.poll();

        if (firstOrder != null) {
            getRegisteredServer().makeOrder(firstOrder);
            ordersReadyForPickup.add(firstOrder);
        }
    }

    public void pickupOrder(Order order) {
        if (!ordersReadyForPickup.contains(order))
            throw new IllegalStateException("Cannot pickup non-existing order");

        ordersReadyForPickup.remove(order);
        System.out.println("Message to Restaurant: Order has been picked up by the driver");
    }

    public void addAvailableTopping(String toppingName) {
        if (toppingNames.size() >= 3)
            throw new IllegalStateException("Cannot have more than 3 toppings on menu");
        toppingNames.add(toppingName);
    }

    public void addAvailableMeal(Meal meal) {
        if (meals.size() >= 4)
            throw new IllegalStateException("Cannot have more than 4 meals on menu");
        meals.add(meal);
    }

    @Override
    public void registerToServer(Server server) {
        super.registerToServer(server);
        server.registerRestaurant(this);
    }
}
