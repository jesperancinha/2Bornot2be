package org.jesperancinha.ocp11.foreach;

import java.util.ArrayList;

public class ForEachRunner {
    public static void main(String[] args) {
        var values = new ArrayList<String>();

        // 1. var needs to be declared between brackets
        // values.forEach(var k->System.out.println(k.length));

        // 2. type declaration
        values.forEach((var k) -> System.out.println(k.length()));

        // 3. Generic usage
        values.forEach(k -> System.out.println(k.length()));

        // 4. var k and adding it
        var k = values.get(0);
        values.add(k);

        // 5. For value in values
        for(var value: values){
        }

        // 6. Wrong type
        // values.add(1);

    }
}
