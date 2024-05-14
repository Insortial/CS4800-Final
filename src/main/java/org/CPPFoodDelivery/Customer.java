package org.CPPFoodDelivery;

public class Customer extends User {
    private DietRestriction dietaryRestriction;

    public Customer(String name, String address, String county, DietRestriction dietaryRestriction) {
        super(name, address, county);
        this.dietaryRestriction = dietaryRestriction;
    }

    public void placeOrder() {
        // TODO
    }

    public void receiveOrder() {
        // TODO
    }

    @Override
    public void registerToServer(Server server) {
        super.registerToServer(server);
        server.registerCustomer(this);
    }
}
