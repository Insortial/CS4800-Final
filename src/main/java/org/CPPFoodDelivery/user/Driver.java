package org.CPPFoodDelivery.user;

import org.CPPFoodDelivery.server.Server;
import org.CPPFoodDelivery.order.Order;

public class Driver extends User {
    private Order assignedOrder;

    public Driver(String name, String address, String county) {
        super(name, address, county);
    }

    public void assignOrder(Order order) {
        if (assignedOrder == null)
            assignedOrder = order;
    }

    public void notifyOrderMade(Order order) {
        System.out.println("Message to Driver: Order has been made and is ready for pick up");
    }

    public void pickupOrder() {
        checkHasAssignedOrder();
        getRegisteredServer().pickUpOrder(assignedOrder);
    }

    public void deliverOrder() {
        checkHasAssignedOrder();
        getRegisteredServer().deliverOrder(assignedOrder);
        assignedOrder = null;
    }

    public boolean hasNoAssignedOrder() {
        return assignedOrder == null;
    }

    @Override
    public void registerToServer(Server server) {
        super.registerToServer(server);
        server.registerDriver(this);
    }

    private void checkHasAssignedOrder() {
        if (assignedOrder == null)
            throw new IllegalStateException("No assigned order");
    }
}
