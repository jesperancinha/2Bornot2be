package org.jesperancinha.ocp11.staticmodular.usage;

import org.jesperancinha.ocp11.staticmodular.filter.GreatFilter;

public class UsageRunner {
    public static void main(String[] args) {
        GreatFilter filter  = new GreatFilter();
        System.out.printf("This is your filter %s", filter);
    }
}
