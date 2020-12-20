package org.jesperancinha.ocp11.crums.crum36;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum36 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 36 - groupingBy");

        var teaBags = Arrays.asList(
            new TeaBag("Black", 100),
            new TeaBag("Rooibos", 30),
            new TeaBag("Rooibos", 160),
            new TeaBag("Lime", 24)
        );

        printMagentaGenericLn("We have this tea collection with respective price associated");

        printMagentaGenericLn(teaBags);

        final Map<String, List<TeaBag>> collect = teaBags.parallelStream()
            .collect(Collectors.groupingBy(TeaBag::getDesignation));

        printOrangeGenericLn(collect);
        printMagentaGenericLn("We can see that we have two Rooibos teas");

        printGreenGenericLn("It may sound not very intuitive, but grouping by can be very simple and just have the grouping parameter on it");

    }
}
