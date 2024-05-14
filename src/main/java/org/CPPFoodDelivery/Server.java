package org.CPPFoodDelivery;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Customer> customers;

    public Server() {
        customers = new ArrayList<>();
    }

    public void placeOrder() {

    }

    public void pickUpOrder() {

    }

    public void deliverOrder() {

    }

    public List<Restaurant> getRestaurantsByCounty(String county) {
        return null; // TODO
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

        // TODO chain of responsibility
    }

    public void registerDriver(Driver driver) {
        if (driver == null) {
            throw new NullPointerException("Driver cannot be null");
        }

        // TODO chain of responsibility
    }
}
