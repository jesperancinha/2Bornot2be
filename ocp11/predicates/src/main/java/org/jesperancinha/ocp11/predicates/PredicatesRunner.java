package org.jesperancinha.ocp11.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Remember parenthesis are mandatory if you want to declare input lambda parameters
 * For predicate, you just need to return a boolean
 * For the predicate to work, the input parameter needs to match the type exactly.
 */
public class PredicatesRunner {
    public static boolean checkList(List list, Predicate<List> predicateList) {
        boolean test = predicateList.test(list);
        System.out.println(list);
        return test;
    }

    public static void main(String[] args) {
        // 1. Works
        boolean b = checkList(new ArrayList(), List::isEmpty);
        System.out.println(b);

        // Doesn't work. ArrayList isn't exactly a List
        // boolean c = checkList(new ArrayList(), (ArrayList al) -> al.isEmpty());

        // 2. Works
        boolean d = checkList(new ArrayList(), al -> al.add("Florence Nightingale"));
        System.out.println(d);
    }
}
