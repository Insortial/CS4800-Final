package org.CPPFoodDelivery.user;

import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.server.Server;
import org.CPPFoodDelivery.order.Order;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Restaurant extends User {
    private LocalTime operatingHoursStart;
    private LocalTime operatingHoursEnd;
    private String cuisineType;
    private List<String> toppingNames;
    private List<Meal> meals;
    private Queue<Order> orders;
    private List<Order> ordersReadyForPickup;

    public Restaurant(String name, String address, String county, LocalTime operatingHoursStart,
                      LocalTime operatingHoursEnd, String cuisineType, List<Meal> meals, List<String> toppingNames) {
        super(name, address, county);
        this.operatingHoursStart = operatingHoursStart;
        this.operatingHoursEnd = operatingHoursEnd;
        this.cuisineType = cuisineType;
        this.toppingNames = toppingNames;
        this.orders = new LinkedList<>();
        this.meals = meals;
        this.ordersReadyForPickup = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        if (isNotInOperatingHours(order.getOrderCreationTime())) {
            throw new IllegalStateException("Cannot place order out of operating hours");
        }
        orders.add(order);
        System.out.println("Message to Restaurant: Order has been placed by the customer");
    }

    private boolean isNotInOperatingHours(LocalTime orderCreationTime) {
        return orderCreationTime.isAfter(operatingHoursEnd) || orderCreationTime.isBefore(operatingHoursStart);
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

    @Override
    public void registerToServer(Server server) {
        super.registerToServer(server);
        server.registerRestaurant(this);
    }
}
