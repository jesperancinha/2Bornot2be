package org.jesperancinha.ocp11.groupingby.math;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingMathRunner {
    public static void main(String[] args) {
        var math1 = new Mathematician("Hypatia", 370, 415);
        var math2 = new Mathematician("Sophie Germain", 1776, 1831);
        var math3 = new Mathematician("Ada Lovelace", 1815, 1852);
        var math4 = new Mathematician("Sofja Kovalevskaja", 1850, 1891);
        var math5 = new Mathematician("Emmy Noether", 1882, 1935);
        var math6 = new Mathematician("Dorothy Vaughan", 1910, 2008);
        var math7 = new Mathematician("Katherine Johnson", 1918, 2020);
        var math8 = new Mathematician("Julia Robinson", 1919, 1985);
        var math9 = new Mathematician("Mary Jackson", 1921, 2005);
        var math10 = new Mathematician("Maryam  Mirzakhani", 1977, 2017);

        var mathematicians = Arrays.asList(math1, math2, math3, math4, math5, math6, math7, math8, math9, math10);

        var mathCentury = mathematicians.stream()
                .map(mathematician -> new MathematicianCentury(mathematician.getName(), (int) (Math.ceil(mathematician.getBirthYear()/100d))))
                .collect(Collectors.toList());


        // 1. Not Possible
        // final Map<Integer, Map<String, List<MathematicianCentury>>> centuryMath = mathCentury.stream()
        //        .collect(Collectors.groupingBy(MathematicianCentury::getCentury),
        //                Collectors.groupingBy(MathematicianCentury::getName,
        //                        Collectors.toList()));


        // 2. Possible but its a map of maps
        final Map<Integer, Map<String, List<MathematicianCentury>>> centuryMath = mathCentury.stream()
                .collect(Collectors.groupingBy(MathematicianCentury::getCentury,
                        Collectors.groupingBy(MathematicianCentury::getName,
                                Collectors.toList())));

        // 3. The correct solution
        final Map<Integer, List<String>> centuryMath2 = mathCentury.stream()
                .collect(Collectors.groupingBy(MathematicianCentury::getCentury,
                        Collectors.mapping(MathematicianCentury::getName,
                                Collectors.toList())));

        // 4. Not possible. Mapping expects two arguments in any case. Without a collector, it could be for example a concatenated string.
        // final Map<Integer, List<String>> centuryMath3 = mathCentury.stream()
        //        .collect(Collectors.groupingBy(MathematicianCentury::getCentury,
        //                Collectors.mapping(MathematicianCentury::getName)));

        System.out.println(centuryMath2);
    }
}
