package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Order;
import org.example.repository.InMemoryOrderRepository;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;

@Slf4j
public class Main {
    public static void main(String[] args) {

        OrderRepository repository = new InMemoryOrderRepository();
        OrderService service = new OrderService(repository);

        repository.save(new Order(1L, "Tablet", 1));
        log.info(service.getOrderItemName(1L));
        log.info(service.getOrderItemName(999L));

    }
}