package org.CPPFoodDelivery;

import java.time.LocalDateTime;

public class Order {
    private Restaurant restaurant;
    private OrderState state;
    private Customer customer;
    private DietRestriction diet;
    private Meal meal;
    private Driver driver;
    LocalDateTime orderCreationTime;
    LocalDateTime orderPickupTime;
    LocalDateTime deliveredTime;

    public Order(Restaurant restaurant, Customer customer, Meal meal, Driver driver) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.state = new OrderPlacedState();
        this.meal = meal;
        this.driver = driver;
        this.orderCreationTime = LocalDateTime.now();
        this.orderPickupTime = null;
        this.deliveredTime = null;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public DietRestriction getDiet() {
        return diet;
    }

    public Meal getMeal() {
        return meal;
    }

    public OrderState getState() {
        return state;
    }

    public Driver getDriver() {
        return driver;
    }

    public LocalDateTime getOrderCreationTime() {
        return orderCreationTime;
    }

    public LocalDateTime getOrderPickupTime() {
        return orderPickupTime;
    }

    public LocalDateTime getDeliveredTime() {
        return deliveredTime;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void getOrderStatus() {
        state.getOrderStatus(this);
    }

    public void makeOrder() {
        state.makeOrder(this);
    }

    public void pickupOrder() {
        state.pickupOrder(this);
    }

    public void deliverOrder() {
        state.deliverOrder(this);
    }

}
