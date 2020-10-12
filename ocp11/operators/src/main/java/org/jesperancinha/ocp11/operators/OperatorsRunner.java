package org.jesperancinha.ocp11.operators;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Stream;

public class OperatorsRunner {
    public static void main(String[] args) {

        testVanilla();
        test1();
        test2();
        test3();
    }

    private static void test3() {
        try {
            var books = List.of(new Book("The Golden Notebook", 11.99), new Book("Beloved", 8.9), new Book("The Left Hand Of Darkness", 10.99), new Book("Mrs Dalloway", 11.99));
            Stream<Book> bkStrm = books.stream();

            DoubleBinaryOperator bo = (a, b) -> a + b;
            OptionalDouble total = bkStrm.mapToDouble(Book::getPrice).reduce(bo);
            System.out.printf("Test 3 - This is the total using DoubleBinaryOperator and no reducing start, %f\n", total.orElse(0d));
        } catch (java.lang.ClassCastException e) {
            System.out.printf("Test 3 - We cannot cast a DoubleBinaryOperator into a BinaryOperator. They sound a like that they are the same, but they are not: %s\n", e.getMessage());
        }
    }

    private static void test2() {
        try {
            var books = List.of(new Book("The Golden Notebook", 11.99), new Book("Beloved", 8.9), new Book("The Left Hand Of Darkness", 10.99), new Book("Mrs Dalloway", 11.99));
            Stream<Book> bkStrm = books.stream();

            BinaryOperator<Double> bo = (a, b) -> a + b;
            double total = bkStrm.map(Book::getPrice).reduce(0.0, bo);
            System.out.printf("Test 2 - This is the total using BinaryOperator, %f\n", total);
        } catch (java.lang.ClassCastException e) {
            System.out.printf("Test 2 - We cannot cast a DoubleBinaryOperator into a BinaryOperator. They sound a like that they are the same, but they are not: %s\n", e.getMessage());
        }
    }


    private static void test1() {
        try {
            var books = List.of(new Book("The Golden Notebook", 11.99), new Book("Beloved", 8.9), new Book("The Left Hand Of Darkness", 10.99), new Book("Mrs Dalloway", 11.99));
            Stream<Book> bkStrm = books.stream();

            DoubleBinaryOperator dbo = (a, b) -> a + b;
            double total = bkStrm.mapToDouble(Book::getPrice).reduce(0.0, dbo);
            System.out.printf("Test 1 - This is the total using DoubleBinaryOperator, %f\n", total);
        } catch (java.lang.ClassCastException e) {
            System.out.printf("Test 1 - We cannot cast a DoubleBinaryOperator into a BinaryOperator. They sound a like that they are the same, but they are not: %s\n", e.getMessage());
        }

    }

    private static void testVanilla() {
        var books = List.of(new Book("The Golden Notebook", 11.99), new Book("Beloved", 8.9), new Book("The Left Hand Of Darkness", 10.99), new Book("Mrs Dalloway", 11.99));
        Stream<Book> bkStrm = books.stream();

        double totalVanilla = bkStrm.map(Book::getPrice).reduce(0.0, Double::sum);
        System.out.printf("Test 0 - This is the total vanilla price, %f\n", totalVanilla);
    }
}
