package com.deepak.location;

public class Data {
    String name;
    double id;

    public Data(String name, double id) {
        this.name = name;
        this.id = id;
    }

    public Data(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}
