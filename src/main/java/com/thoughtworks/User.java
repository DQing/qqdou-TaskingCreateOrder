package com.thoughtworks;

import java.util.UUID;

class User {
    private UUID id;
    private String name;

    User(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    UUID getId() {
        return id;
    }
}
