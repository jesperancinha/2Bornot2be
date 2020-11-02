package org.jesperancinha.ocp11.books;

public class Book {
    private final String bookName;
    private final String author;
    private final double price;

    public Book(final String bookName, final String author, final double price) {
        this.bookName = bookName;
        this.author = author;
        this.price =  price;
    }

    public double getPrice() {
        return price;
    }
}
