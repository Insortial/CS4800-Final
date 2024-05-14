package org.CPPFoodDelivery;

public class Driver extends User {
    // private Order assignedOrder;

    public Driver(String name, String address, String county) {
        super(name, address, county);
    }

    public void assignOrder() {

    }

    public void pickupOrder() {

    }

    public void deliverOrder() {

    }

    @Override
    public void registerToServer(Server server) {
        super.registerToServer(server);
        server.registerDriver(this);
    }
}
