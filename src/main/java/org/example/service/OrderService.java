package org.example.service;

import org.example.model.Order;
import org.example.repository.OrderRepository;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getOrderItemName(Long orderId) {
        Order order = orderRepository.findOrderById(orderId);
        if (order == null) {
            return "Order not found";
        }
        return order.getItem();
    }

}
