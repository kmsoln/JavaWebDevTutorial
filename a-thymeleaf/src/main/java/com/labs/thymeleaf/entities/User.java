package com.labs.thymeleaf.entities;

public class User {
    private final Integer id;
    private final String firstMame;
    private final String sureName;

    private final Boolean isAdmin;

    public User(Integer id, String firstMame, String sureName, Boolean isAdmin) {
        this.id = id;
        this.firstMame = firstMame;
        this.sureName = sureName;
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstMame() {
        return firstMame;
    }

    public String getSureName() {
        return sureName;
    }


    public Boolean isAdmin() {
        return isAdmin;
    }
}
