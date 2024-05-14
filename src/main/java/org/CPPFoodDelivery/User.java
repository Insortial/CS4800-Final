package org.CPPFoodDelivery;

public abstract class User {
    private Server registeredServer;
    private String name;
    private String address;
    private String county;

    public User(String name, String address, String county) {
        this.name = name;
        this.address = address;
        this.county = county;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCounty() {
        return county;
    }

    public void registerToServer(Server server) {
        if (server == null) {
            throw new NullPointerException("Cannot register to null server");
        }

        this.registeredServer = server;
    }
}
