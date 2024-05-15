package org.CPPFoodDelivery.server;

import org.CPPFoodDelivery.user.Driver;
import org.CPPFoodDelivery.user.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class CountyHandler {
    private CountyHandler nextHandler;
    private String county;
    private List<Driver> drivers;
    private List<Restaurant> restaurants;

    public CountyHandler() {
        this.drivers = new ArrayList<>();
        this.restaurants = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        if (isNotSameCounty(driver.getCounty())) {
            ensureNextHandlerNotNull();
            nextHandler.addDriver(driver);
        }
        drivers.add(driver);
    }

    public void addRestaurant(Restaurant restaurant) {
        if (isNotSameCounty(restaurant.getCounty())) {
            ensureNextHandlerNotNull();
            nextHandler.addRestaurant(restaurant);
        }
        restaurants.add(restaurant);
    }

    public List<Restaurant> getRestaurantsByCounty(String county) {
        if (isNotSameCounty(county)) {
            ensureNextHandlerNotNull();
            return nextHandler.getRestaurantsByCounty(county);
        }
        return restaurants;
    }

    public Driver getAvailableDriverByCounty(String county) {
        if (isNotSameCounty(county)) {
            ensureNextHandlerNotNull();
            return nextHandler.getAvailableDriverByCounty(county);
        }
        return findNextAvailableDriver();
    }

    private Driver findNextAvailableDriver() {
        for (Driver driver : drivers) {
            if (driver.hasNoAssignedOrder())
                return driver;
        }
        return null;
    }

    private boolean isNotSameCounty(String county) {
        if (this.county == null) {
            this.county = county;
            return false;
        }

        return !this.county.equals(county);
    }

    private void ensureNextHandlerNotNull() {
        if (nextHandler == null)
            nextHandler = new CountyHandler();
    }
}
