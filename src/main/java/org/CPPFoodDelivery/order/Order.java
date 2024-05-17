package org.CPPFoodDelivery.order;

import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.user.Customer;
import org.CPPFoodDelivery.user.Driver;
import org.CPPFoodDelivery.user.Restaurant;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Order {
    private Restaurant restaurant;
    private OrderState state;
    private Customer customer;
    private List<Meal> meals;
    private Driver driver;
    private LocalTime orderCreationTime;
    private LocalTime orderPickupTime;
    private LocalTime deliveredTime;

    public Order(Restaurant restaurant, Customer customer, List<Meal> meals) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.state = OrderCreatedState.getInstance();
        this.meals = meals;
        this.orderCreationTime = LocalTime.now();
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

    public LocalTime getOrderCreationTime() {
        return orderCreationTime;
    }

    public LocalTime getOrderPickupTime() {
        return orderPickupTime;
    }

    public LocalTime getDeliveredTime() {
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
        orderPickupTime = LocalTime.now();
    }

    public void deliverOrder() {
        state.deliverOrder(this);
        deliveredTime = LocalTime.now();
    }

    public void assignDriver(Driver assignedDriver) {
        this.driver = assignedDriver;
    }
}
