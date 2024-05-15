package org.CPPFoodDelivery.order;

import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.user.Customer;
import org.CPPFoodDelivery.user.Driver;
import org.CPPFoodDelivery.user.Restaurant;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Restaurant restaurant;
    private OrderState state;
    private Customer customer;
    private List<Meal> meals;
    private Driver driver;
    private LocalDateTime orderCreationTime;
    private LocalDateTime orderPickupTime;
    private LocalDateTime deliveredTime;

    public Order(Restaurant restaurant, Customer customer, List<Meal> meals) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.state = new OrderCreatedState();
        this.meals = meals;
        this.orderCreationTime = LocalDateTime.now();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Meal> getMeals() {
        return meals;
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

    public void placeOrder(Order order, Driver assignedDriver) {
        state.placeOrder(order, assignedDriver);
    }

    public void makeOrder() {
        state.makeOrder(this);
    }

    public void pickupOrder() {
        state.pickupOrder(this);
        orderPickupTime = LocalDateTime.now();
    }

    public void deliverOrder() {
        state.deliverOrder(this);
        deliveredTime = LocalDateTime.now();
    }

    public void assignDriver(Driver assignedDriver) {
        this.driver = assignedDriver;
    }
}
