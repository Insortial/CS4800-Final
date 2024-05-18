package org.CPPFoodDelivery;

import org.CPPFoodDelivery.*;
import org.CPPFoodDelivery.meal.DietRestriction;
import org.CPPFoodDelivery.meal.Meal;
import org.CPPFoodDelivery.meal.MealFactory;
import org.CPPFoodDelivery.order.Order;
import org.CPPFoodDelivery.server.Server;
import org.CPPFoodDelivery.user.Customer;
import org.CPPFoodDelivery.user.Driver;
import org.CPPFoodDelivery.user.Restaurant;
import org.CPPFoodDelivery.user.RestaurantBuilder;

import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        Server server = new Server();

        //Create Counties
        server.addServiceableCounty("LA County", LocalTime.of(8,0), LocalTime.of(16,0));
        server.addServiceableCounty("Orange County", LocalTime.of(16,0), LocalTime.of(23, 59));
        server.addServiceableCounty("San Bernardino County", LocalTime.of(1,0), LocalTime.of(8,0));

        //Create Drivers
        Driver driver1 = new Driver("John", "East LA, Los Angeles", "LA County");
        Driver driver2 = new Driver("Mark", "Address", "LA County");
        Driver driver3 = new Driver("Simon", "Address", "LA County");
        Driver driver4 = new Driver("Jane", "Address", "Orange County");
        Driver driver5 = new Driver("Naimo", "Address", "Orange County");
        Driver driver6 = new Driver("Locker", "Address", "Orange County");
        Driver driver7 = new Driver("Bonji", "Address", "San Bernardino County");
        Driver driver8 = new Driver("Maine", "Address", "San Bernardino County");

        driver1.registerToServer(server);
        driver2.registerToServer(server);
        driver3.registerToServer(server);
        driver4.registerToServer(server);
        driver5.registerToServer(server);
        driver6.registerToServer(server);
        driver7.registerToServer(server);
        driver8.registerToServer(server);

        //Create restaurants and meals
        Meal meal = MealFactory.createMeal("Pasta", "Butter", "Meatball");
        Restaurant oliveGarden = new RestaurantBuilder()
                .setName("Olive Garden")
                .setCuisineType("Italian")
                .setAddress("North Los Angeles, Los Angeles")
                .setCounty("LA County")
                .setOperatingHoursStart(LocalTime.of(8,0))
                .setOperatingHoursEnd(LocalTime.of(17, 0))
                .addAvailableMeal(meal)
                .addAvailableTopping("Cheese")
                .build();
        oliveGarden.registerToServer(server);

        Meal meal2 = MealFactory.createMeal("Tortilla", "Sour Cream", "Beef");
        Restaurant tacoBell = new RestaurantBuilder()
                .setName("Taco Bell")
                .setCuisineType("Mexican")
                .setAddress("Monterrey Park, Los Angeles")
                .setCounty("LA County")
                .setOperatingHoursStart(LocalTime.of(8,0))
                .setOperatingHoursEnd(LocalTime.of(23, 59))
                .addAvailableMeal(meal2)
                .addAvailableTopping("Cheese")
                .build();
        tacoBell.registerToServer(server);

        Meal meal3 = MealFactory.createMeal("Chow Mein", "Seasame Oil", "Chicken");
        Restaurant pandaExpress = new RestaurantBuilder()
                .setName("Panda Express")
                .setCuisineType("Chinese")
                .setAddress("Anaheim, Orange County")
                .setCounty("Orange County")
                .setOperatingHoursStart(LocalTime.of(8,0))
                .setOperatingHoursEnd(LocalTime.of(23, 59))
                .addAvailableMeal(meal3)
                .addAvailableTopping("Soy Sauce")
                .build();
        pandaExpress.registerToServer(server);

        Meal meal4 = MealFactory.createMeal("Bun", "Cheese", "Fish");
        Restaurant mcDonalds = new RestaurantBuilder()
                .setName("McDonalds")
                .setCuisineType("American")
                .setAddress("Colton, San Bernardino")
                .setCounty("San Bernardino County")
                .setOperatingHoursStart(LocalTime.of(1,0))
                .setOperatingHoursEnd(LocalTime.of(23, 59))
                .addAvailableMeal(meal4)
                .addAvailableTopping("Tartar Sauce")
                .build();
        mcDonalds.registerToServer(server);

        //Create customers
        Customer customer1 = new Customer("Alice Johnson", "123 Maple St", "LA County", DietRestriction.NO_RESTRICTION);
        Customer customer2 = new Customer("Bob Smith", "456 Oak St", "Orange County", DietRestriction.PALEO);
        Customer customer3 = new Customer("Carol White", "789 Pine St", "San Bernardino County", DietRestriction.VEGAN);
        Customer customer4 = new Customer("David Brown", "101 Birch St", "LA County", DietRestriction.NUT_ALLERGY);
        Customer customer5 = new Customer("Eve Davis", "202 Cedar St", "Orange County", DietRestriction.NO_RESTRICTION);
        Customer customer6 = new Customer("Frank Wilson", "303 Walnut St", "San Bernardino County", DietRestriction.PALEO);
        Customer customer7 = new Customer("Grace Lee", "404 Elm St", "LA County", DietRestriction.VEGAN);
        Customer customer8 = new Customer("Henry Walker", "505 Spruce St", "Orange County", DietRestriction.NUT_ALLERGY);
        Customer customer9 = new Customer("Ivy Harris", "606 Fir St", "San Bernardino County", DietRestriction.NO_RESTRICTION);
        Customer customer10 = new Customer("Jack Martinez", "707 Willow St", "LA County", DietRestriction.PALEO);

        customer1.registerToServer(server);
        customer2.registerToServer(server);
        customer3.registerToServer(server);
        customer4.registerToServer(server);
        customer5.registerToServer(server);
        customer6.registerToServer(server);
        customer7.registerToServer(server);
        customer8.registerToServer(server);
        customer9.registerToServer(server);
        customer10.registerToServer(server);

        System.out.println("\nOrder 1:");
        ArrayList customer1Meals = new ArrayList<>();
        customer1Meals.add(meal);
        customer1.placeOrder(new Order(oliveGarden, customer1, customer1Meals, LocalTime.of(13,0)));
        oliveGarden.makeOrder();
        driver1.pickupOrder();
        driver1.deliverOrder();

        System.out.println("\nOrder 2:");
        ArrayList customer4Meals = new ArrayList<>();
        customer4Meals.add(meal);
        customer1.placeOrder(new Order(oliveGarden, customer4, customer4Meals, LocalTime.of(13,0)));
        oliveGarden.makeOrder();
        driver1.pickupOrder();
        driver1.deliverOrder();

        System.out.println("\nOrder 3:");
        ArrayList customer7Meals = new ArrayList<>();
        customer7Meals.add(meal2);
        customer1.placeOrder(new Order(tacoBell, customer7, customer7Meals, LocalTime.of(13,0)));
        tacoBell.makeOrder();
        driver1.pickupOrder();
        driver1.deliverOrder();

        System.out.println("\nOrder 4:");
        ArrayList<Meal> customer2Meals = new ArrayList<>();
        customer2Meals.add(meal3);
        customer2.placeOrder(new Order(pandaExpress, customer2, customer2Meals, LocalTime.of(13,0)));
        pandaExpress.makeOrder();
        driver4.pickupOrder();
        driver4.deliverOrder();

        System.out.println("\nOrder 5:");
        ArrayList<Meal> customer5Meals = new ArrayList<>();
        customer5Meals.add(meal3);
        customer5.placeOrder(new Order(pandaExpress, customer5, customer5Meals, LocalTime.of(13,0)));
        pandaExpress.makeOrder();
        driver4.pickupOrder();
        driver4.deliverOrder();

        System.out.println("\nOrder 6:");
        ArrayList<Meal> customer6Meals = new ArrayList<>();
        customer6Meals.add(meal4);
        customer6.placeOrder(new Order(mcDonalds, customer6, customer6Meals, LocalTime.of(5,0)));
        mcDonalds.makeOrder();
        driver7.pickupOrder();
        driver7.deliverOrder();

//        System.out.println("\nOrder 7:");
//        ArrayList<Meal> customer3Meals = new ArrayList<>();
//        customer3Meals.add(meal4);
//        customer3.placeOrder(new Order(mcDonalds, customer3, customer3Meals, LocalTime.of(5,0)));
//        mcDonalds.makeOrder();
//        driver7.pickupOrder();
//        driver7.deliverOrder();

        System.out.println("\nOrder 8:");
        ArrayList<Meal> customer8Meals = new ArrayList<>();
        customer8Meals.add(meal3);
        customer8.placeOrder(new Order(pandaExpress, customer8, customer8Meals, LocalTime.of(13,0)));
        pandaExpress.makeOrder();
        driver4.pickupOrder();
        driver4.deliverOrder();

//        System.out.println("\nOrder 9:");
//        ArrayList<Meal> customer9Meals = new ArrayList<>();
//        customer9Meals.add(meal4);
//        customer9.placeOrder(new Order(mcDonalds, customer9, customer9Meals, LocalTime.of(5,0)));
//        mcDonalds.makeOrder();
//        driver7.pickupOrder();
//        driver7.deliverOrder();

        System.out.println("\nOrder 10:");
        ArrayList<Meal> customer10Meals = new ArrayList<>();
        customer10Meals.add(meal2);
        customer10.placeOrder(new Order(tacoBell, customer10, customer10Meals, LocalTime.of(13,0)));
        tacoBell.makeOrder();
        driver1.pickupOrder();
        driver1.deliverOrder();
    }
}
