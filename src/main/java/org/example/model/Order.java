package org.example.model;

import lombok.Getter;

@Getter
public class Order {
    private Long id;
    private String item;
    private int quantity;

    public Order() {}

    public Order(Long id, String item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

}
