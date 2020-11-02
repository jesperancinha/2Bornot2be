package org.jesperancinha.ocp11.operators;

public class Book {

    private final String title;

    private final double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
