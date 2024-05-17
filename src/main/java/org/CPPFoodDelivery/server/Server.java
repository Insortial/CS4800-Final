package org.CPPFoodDelivery.server;

import org.CPPFoodDelivery.order.Order;
import org.CPPFoodDelivery.user.Customer;
import org.CPPFoodDelivery.user.Driver;
import org.CPPFoodDelivery.user.Restaurant;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Customer> customers;
    private CountyHandler countyHandler;

    public Server() {
        customers = new ArrayList<>();
    }

    public void addServiceableCounty(String county, LocalTime shiftStart, LocalTime shiftEnd) {
        if (countyHandler == null) {
            countyHandler = new CountyHandler(county, shiftStart, shiftEnd);
        } else {
            countyHandler.addCounty(county, shiftStart, shiftEnd);
        }
    }

    public void placeOrder(Order order) {
        Driver assignedDriver = countyHandler.getAvailableDriverByCounty(order.getCustomer().getCounty(), order.getOrderCreationTime());
        order.placeOrder(order, assignedDriver);
    }

    public void makeOrder(Order order) {
        order.makeOrder();
    }

    public void pickUpOrder(Order order) {
        order.pickupOrder();
    }

    public void deliverOrder(Order order) {
        order.deliverOrder();
    }

    public List<Restaurant> getRestaurantsByCounty(String county) {
        return countyHandler.getRestaurantsByCounty(county);
    }

    public void registerCustomer(Customer customer) {
        if (customer == null) {
            throw new NullPointerException("Customer cannot be null");
        }

        customers.add(customer);
    }

    public void registerRestaurant(Restaurant restaurant) {
        if (restaurant == null) {
            throw new NullPointerException("Restaurant cannot be null");
        }

        countyHandler.addRestaurant(restaurant);
    }

    public void registerDriver(Driver driver) {
        if (driver == null) {
            throw new NullPointerException("Driver cannot be null");
        }

        countyHandler.addDriver(driver);
    }
}
