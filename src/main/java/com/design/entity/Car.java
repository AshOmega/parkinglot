package com.design.entity;

public class Car {

    private String regnNumber;
    private String color;

    public Car(String regnNumber, String color) {
        this.regnNumber = regnNumber;
        this.color = color;
    }

    public String getRegnNumber() {
        return regnNumber;
    }

    public String getColor() {
        return color;
    }

}
