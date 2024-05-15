package org.CPPFoodDelivery.server;

import org.CPPFoodDelivery.order.Order;
import org.CPPFoodDelivery.user.Customer;
import org.CPPFoodDelivery.user.Driver;
import org.CPPFoodDelivery.user.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Customer> customers;
    private CountyHandler countyHandler;

    public Server() {
        customers = new ArrayList<>();
        countyHandler = new CountyHandler();
    }

    public void placeOrder(Order order) {
        Driver assignedDriver = countyHandler.getAvailableDriverByCounty(order.getCustomer().getCounty());
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
