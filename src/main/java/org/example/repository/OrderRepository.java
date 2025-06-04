package org.example.repository;

import org.example.model.Order;

public interface OrderRepository {
    Order findOrderById(long id);
}
