package org.CPPFoodDelivery.user;

import org.CPPFoodDelivery.meal.Meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantBuilder {
    private String name;
    private String address;
    private String county;
    private LocalDateTime operatingHoursStart;
    private LocalDateTime operatingHoursEnd;
    private String cuisineType;
    private List<Meal> meals;
    private List<String> toppingNames;

    public RestaurantBuilder() {
        meals = new ArrayList<>();
        toppingNames = new ArrayList<>();
    }

    public RestaurantBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RestaurantBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public RestaurantBuilder setCounty(String county) {
        this.county = county;
        return this;
    }

    public RestaurantBuilder setOperatingHoursStart(LocalDateTime operatingHoursStart) {
        this.operatingHoursStart = operatingHoursStart;
        return this;
    }

    public RestaurantBuilder setOperatingHoursEnd(LocalDateTime operatingHoursEnd) {
        this.operatingHoursEnd = operatingHoursEnd;
        return this;
    }

    public RestaurantBuilder setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
        return this;
    }

    public RestaurantBuilder addAvailableMeal(Meal meal) {
        if (this.meals.size() >= 4)
            throw new IllegalStateException("Cannot have more than 4 meals in menu");
        this.meals.add(meal);
        return this;
    }

    public RestaurantBuilder addAvailableTopping(String toppingName) {
        if (this.toppingNames.size() >= 3)
            throw new IllegalStateException("Cannot have more than 3 toppings in menu");
        this.toppingNames.add(toppingName);
        return this;
    }

    public Restaurant build() {
        return new Restaurant(name, address, county, operatingHoursStart, operatingHoursEnd, cuisineType, meals, toppingNames);
    }
}
