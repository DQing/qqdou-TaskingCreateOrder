package com.thoughtworks;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private UUID userId;
    private List<HashMap> products;
    private int orderPrice;
    private Timestamp timestamp;
    private OrderStatus status;

    Order(UUID id, UUID userId, List<HashMap> products, int orderPrice, Timestamp timestamp, OrderStatus status) {
        this.id = id;
        this.userId = userId;
        this.products = products;
        this.orderPrice = orderPrice;
        this.timestamp = timestamp;
        this.status = status;
    }

    UUID getId() {
        return id;
    }

    UUID getUserId() {
        return userId;
    }

    List<HashMap> getProducts() {
        return products;
    }

    int getOrderPrice() {
        return orderPrice;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    OrderStatus getStatus() {
        return status;
    }

}
