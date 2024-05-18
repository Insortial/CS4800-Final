package org.CPPFoodDelivery.server;

import org.CPPFoodDelivery.user.Driver;
import org.CPPFoodDelivery.user.Restaurant;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CountyHandler {
    private CountyHandler nextHandler;
    private String county;
    private LocalTime shiftStart;
    private LocalTime shiftEnd;
    private List<Driver> drivers;
    private List<Restaurant> restaurants;

    public CountyHandler(String county, LocalTime shiftStart, LocalTime shiftEnd) {
        this.county = county;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.drivers = new ArrayList<>();
        this.restaurants = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        if (isNotSameCounty(driver.getCounty())) {
            checkHasNextHandler();
            nextHandler.addDriver(driver);
        }
        drivers.add(driver);
        //System.out.println(driver.getName() + " " + driver.getCounty());
    }

    public void addRestaurant(Restaurant restaurant) {
        if (isNotSameCounty(restaurant.getCounty())) {
            checkHasNextHandler();
            nextHandler.addRestaurant(restaurant);
        }
        restaurants.add(restaurant);
    }

    public void addCounty(String county, LocalTime shiftStart, LocalTime shiftEnd) {
        if (nextHandler == null) {
            nextHandler = new CountyHandler(county, shiftStart, shiftEnd);
        } else {
            nextHandler.addCounty(county, shiftStart, shiftEnd);
        }
    }

    public List<Restaurant> getRestaurantsByCounty(String county) {
        if (isNotSameCounty(county)) {
            checkHasNextHandler();
            return nextHandler.getRestaurantsByCounty(county);
        }
        return restaurants;
    }

    public Driver getAvailableDriverByCounty(String county, LocalTime currentTime) {
        if (isNotSameCounty(county)) {
            checkHasNextHandler();
            return isInShift(currentTime) ? nextHandler.getAvailableDriverByCounty(county, currentTime) : null;
        }
        return findNextAvailableDriver();
    }

    private boolean isInShift(LocalTime currentTime) {
        return !(currentTime.isAfter(shiftEnd) || currentTime.isBefore(shiftStart));
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

    private void checkHasNextHandler() {
        if (nextHandler == null)
            throw new IllegalStateException("No county exists with that name");
    }
}
