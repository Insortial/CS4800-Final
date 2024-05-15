package org.CPPFoodDelivery.user;

import org.CPPFoodDelivery.server.Server;

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

    public Server getRegisteredServer() {
        return registeredServer;
    }

    public void registerToServer(Server server) {
        if (server == null) {
            throw new NullPointerException("Cannot register to null server");
        }

        this.registeredServer = server;
    }
}
