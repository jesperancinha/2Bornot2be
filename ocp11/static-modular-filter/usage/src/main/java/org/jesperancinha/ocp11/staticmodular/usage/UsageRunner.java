package org.jesperancinha.ocp11.staticmodular.usage;

import org.jesperancinha.ocp11.staticmodular.api.Filter;
import org.jesperancinha.ocp11.staticmodular.filter.GreatFilter;

import java.util.ServiceLoader;

public class UsageRunner {
    public static void main(String[] args) {
        GreatFilter filter = new GreatFilter();
        System.out.printf("This is your filter %s\n", filter);
        System.out.println("Now let's try and load the service");
        ServiceLoader<Filter> filterServiceLoader = ServiceLoader.load(Filter.class);
        System.out.printf("This is your filter %s\n", filterServiceLoader.iterator().next());

    }
}
