package com.example.yogademoapp;

public class Yoga {

    private final String name;
    private final String date;

    public Yoga(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}