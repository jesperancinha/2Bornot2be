package org.jesperancinha.ocp11.system.properties;

import java.util.function.Consumer;

public class SystemPropertiesRunner {
    public static void main(String[] args) {
        System.out.println("------------ All Keys! ------------");
        System.getProperties().entrySet().forEach(objectObjectEntry -> System.out.println(objectObjectEntry.getKey()));
        System.out.println("------------ All Keys 2! ------------");
        System.getProperties().forEach((key, value) -> System.out.println(key));
        System.out.println("------------ All values! ------------");
        System.getProperties().entrySet().forEach(objectObjectEntry -> System.out.println(objectObjectEntry.getValue()));
        System.out.println("------------ All values 2! ------------");
        System.getProperties().forEach((key, value) -> System.out.println(value));

        // Please define type
        // var k = System.out::println;
        var k = (Consumer<String>) System.out::println;

        // Null does not define a type
        // var x = null;
    }
}
