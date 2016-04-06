package com.steelzack.b2b2java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by joaofilipesabinoesperancinha on 06-04-16.
 */
public class Collections1 {
    private List<String> testArrayOfStrings = Arrays.asList(//
            "Eucaliptus", //
            "Mint", //
            "Car", //
            "Uncle Bob", //
            "Developers Developers", //
            "No hands" //
    );

    protected List<String> getStringsThatStartWith(){
        Stream<String> stream = testArrayOfStrings.stream();
        return stream.filter( item -> item.startsWith("E")).collect(Collectors.toList());
    }
}
