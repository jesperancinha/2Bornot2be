package org.jesperancinha.ocp11.crums.crum22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum22 {

    private static class One {

        public List<Integer> getNumbers(Set<Integer> numberSet) {
            printOrangeGenericLn("List<Integer> getNumbers(Set<Integer> numberSet) called!");
            java.util.Random random = new java.util.Random();
            numberSet.add(random.nextInt());
            return numberSet.stream().mapToInt(Math::toIntExact).boxed().collect(Collectors.toList());
        }

    }

    private static class Two extends One {

        //'getNumbers(Set<String>)' in 'org.jesperancinha.ocp11.crums.crum22.Crum22.Two' clashes with 'getNumbers(Set<Integer>)'
        // in 'org.jesperancinha.ocp11.crums.crum22.Crum22.One';
        // both methods have same erasure, yet neither overrides the other
        // public List<Integer> getNumbers(Set<String> numberSet){
        public List<Integer> getNumbers(HashSet<Long> numberSet) {
            printOrangeGenericLn("List<Integer> getNumbers(HashSet<Long> numberSet) called!");
            final java.util.Random random = new java.util.Random();
            numberSet.add(random.nextLong());
            return numberSet.stream().mapToInt(Long::intValue).boxed().collect(Collectors.toList());
        }

        public List<Integer> getNumbers(Set<Integer> numberSet) {
            printOrangeGenericLn("List<Integer> getNumbers(Set<Integer> numberSet) called!");
            java.util.Random random = new java.util.Random();
            numberSet.add(random.nextInt());
            return new ArrayList<>(numberSet);
        }

        // 'getNumbers(Set<Integer>)' in 'org.jesperancinha.ocp11.crums.crum22.Crum22.Two'
        // clashes with 'getNumbers(Set<Integer>)' in 'org.jesperancinha.ocp11.crums.crum22.Crum22.One';
        // attempting to use incompatible return type
        // public List<String> getNumbers(Set<Integer> numberSet) {
        //     printOrangeGenericLn("List<Integer> getNumbers(Set<Integer> numberSet) called!");
        //     java.util.Random random = new java.util.Random();
        //     numberSet.add(random.nextInt());
        //     return new ArrayList<>(numberSet);
        // }
    }

    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 22 - Overriding with type erasure");

        final Two two = new Two();
        final List<Integer> numbersTwoLong = two.getNumbers(new HashSet<Long>());
        final List<Integer> numbersTwoInt = two.getNumbers(new HashSet<Integer>());

        final One one = new One();
        final List<Integer> numbersOneInt = one.getNumbers(new HashSet<>());

        printMagentaGenericLn("We can call two different methods on Two");
        printMagentaGenericLn("Then we get:");
        printYellowGenericLn(numbersTwoInt);
        printMagentaGenericLn("And");
        printYellowGenericLn(numbersTwoLong);
        printMagentaGenericLn("In One, we can just call one method and yield:");
        printMagentaGenericLn(numbersOneInt);

        printGreenGenericLn("Overloading happens in general if overriding is not possible");
        printGreenGenericLn("If type erasure is the same, neither overriding nor overloading is possible");
        printGreenGenericLn("Type erasure means that on development time, the types are defined, but during compile time, the types from generics are removed");
        printGreenGenericLn("If after removal, the types match (i.e. List<Long> != List<Integer> => List<> == List<>), then type erasure is the same and compilation cannot happen");
        printGreenGenericLn("Type erasure rule applies to both input parameters ads well to return parameters");
    }
}
