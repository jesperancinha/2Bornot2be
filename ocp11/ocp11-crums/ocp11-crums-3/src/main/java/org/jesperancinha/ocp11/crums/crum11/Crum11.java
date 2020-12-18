package org.jesperancinha.ocp11.crums.crum11;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum11 {


    private static  class BaseSuper {
        public <T> Collection <? super CharSequence> areYouOutOfTouch(Collection<T> lyrics){
            return new ArrayList<>(lyrics);
        }
    }
    private static abstract class Base {

        public  <T> Collection<T> areYouOutOfTouch(Collection<T> lyrics){
          return (Collection<T>) Arrays.asList("You didn't Override this!!");
        }

    }

    private static class Main1 extends Base {
        public Collection<String> areYouOutOfTouch(List<String> lyrics) {
            printOrangeGenericLn(lyrics);
            return Arrays.asList("I'm out of time");
        }
    }

    private static class Main2 extends Base {
        public <T> Collection<T> areYouOutOfTouch(Collection<T> lyrics) {
            printOrangeGenericLn(lyrics);
            return (Collection<T>) Arrays.asList("I'm out of time");
        }
    }

    private static class Main3 extends Base {
        public <T> List<T> areYouOutOfTouch(Collection<T> lyrics) {
            printOrangeGenericLn(lyrics);
            return (List<T>) Arrays.asList("I'm out of time");
        }
    }
    private static class Main4 extends Base {
        public <T> List<T> areYouOutOfTouch(List<T> lyrics) {
            printOrangeGenericLn(lyrics);
            return (List<T>) Arrays.asList("I'm out of time");
        }
    }

    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 11 - Overriding and overloading generics");

        printYellowGenericLn("from: https://genius.com/Hall-and-oates-out-of-touch-lyrics ");
        printMagentaGenericLn("1 - %s", new Main1().areYouOutOfTouch(Arrays.asList("You're out of touch")));
        printMagentaGenericLn("2 - %s", new Main1().areYouOutOfTouch(Collections.singletonList("You're out of touch")));
        printMagentaGenericLn("3 - %s", new Main1().areYouOutOfTouch((Collection)Arrays.asList("You're out of touch")));
        printMagentaGenericLn("4 - %s", new Main2().areYouOutOfTouch(Arrays.asList("You're out of touch")));
        printMagentaGenericLn("5 - %s", new Main2().areYouOutOfTouch((Collection)Arrays.asList("You're out of touch")));
        printMagentaGenericLn("6 - %s", new Main3().areYouOutOfTouch(Arrays.asList("You're out of touch")));
        printMagentaGenericLn("7 - %s", new Main3().areYouOutOfTouch((Collection)Arrays.asList("You're out of touch")));
        printMagentaGenericLn("8 - %s", new Main4().areYouOutOfTouch(Arrays.asList("You're out of touch")));
        printMagentaGenericLn("9 - %s", new Main4().areYouOutOfTouch((Collection)Arrays.asList("You're out of touch")));
        printMagentaGenericLn("10 - %s", new BaseSuper().areYouOutOfTouch(Arrays.asList("You're out of touch")));
        printMagentaGenericLn("11 - %s", new BaseSuper().areYouOutOfTouch(Arrays.asList(1123443432342L)));
        final Collection<? super CharSequence> objects = new BaseSuper().areYouOutOfTouch(
            new ArrayList<>(Arrays.asList("I'm out of time!")));
        printMagentaGenericLn("12 - %s", objects);
        objects.add(new StringBuilder());
        final Object next = objects.iterator()
            .next();
        printMagentaGenericLn("Notice that '%s' is an Object! Using super in a wildcard allows us to write only specific types but offers no guarantee about the read type", next);
        // Required type:
        // capture of ? super CharSequence
        // objects.add(1L);
        printGreenGenericLn("You need to be careful with type erasure -> Set<String> and Set<Object> have the same type erasure.");
        printGreenGenericLn("If they have the same type erasure, the compiler will try to override the two methods.");
        printGreenGenericLn("If the sub method return type isn't at least the same type or a sub type of the overridden one, then the compiler will report an error.");
        printGreenGenericLn("Using wildcard extends, you cannot add any element to the list. You know that the element is of a specific type or subtype only, but you don't know which");
        printGreenGenericLn("You can read wildcard extends though with the guarantee of the given type");
        printGreenGenericLn("Super in a wildcard generic type, means that every element has a given super type. This also means that adding an element of that type or subtype is allowed");
        printGreenGenericLn("Further reading: https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java");
    }
}
