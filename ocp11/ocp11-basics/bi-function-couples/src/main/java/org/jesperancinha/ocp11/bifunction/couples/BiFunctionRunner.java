package org.jesperancinha.ocp11.bifunction.couples;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Remember that with a BiFunction you have to specify the two input types and the return type. This means that you always have to declare three types.
 */
public class BiFunctionRunner {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "Angela Clayton");
        map1.put("b", "Ruth Gates");
        map1.put("d", "Valerie E. Stone");
        BiFunction<String, String, String> f = String::concat;
        map1.merge("b", "Robin Burton Gates", f);
        map1.merge("d", "Kathryn Hall", f);
        map1.merge("c", "Irena Klepfisz", f);
        System.out.println(map1);
    }
}
