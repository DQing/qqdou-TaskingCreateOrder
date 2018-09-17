package com.thoughtworks;

class User {
    private long id;
    private String name;

    User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    long getId() {
        return id;
    }
}
