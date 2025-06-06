package org.example.repository;

import org.example.model.Order;

import java.util.HashMap;
import java.util.Map;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<Long, Order> orders = new HashMap<>();

    @Override
    public Order findOrderById(long id) {
        return orders.get(id);
    }

    @Override
    public void save(Order order) {
        orders.put(order.getId(), order);
    }
}
