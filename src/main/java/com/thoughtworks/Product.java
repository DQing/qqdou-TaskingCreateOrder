package com.thoughtworks;

class Product {
    private long id;
    private String name;
    private int price;

    Product(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    long getId() {
        return id;
    }

    int getPrice() {
        return price;
    }
}
