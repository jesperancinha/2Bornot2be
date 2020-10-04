package org.jesperancinha.ocp11.books;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BooksRunner {
    public static void main(String[] args) {
        List<List<Book>> books = Arrays.asList(
                Arrays.asList(
                        new Book("Cracking the Coding Interview: 150 Programming Questions and Solutions", "Gayle Laakmann McDowell", 36.83),
                        new Book("Code Reviews 101", "Giuliana Carullo", 9.0)),
                Arrays.asList(
                        new Book("Practical Object Oriented Design in Ruby","Sandi Metz", 46),
                        new Book("Life in Code: A Personal History of Technology","Ellen Ullman", 19.99)));

        double d = books.stream()
                .flatMap(Collection::stream)
                .mapToDouble(Book::getPrice)
                .sum();

        System.out.println(d);
    }
}
