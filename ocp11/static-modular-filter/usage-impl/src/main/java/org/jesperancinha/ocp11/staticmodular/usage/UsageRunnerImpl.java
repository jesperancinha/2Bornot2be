package org.jesperancinha.ocp11.staticmodular.usage;

import org.jesperancinha.ocp11.staticmodular.api.Filter;
import org.jesperancinha.ocp11.staticmodular.filter.impl.GreatFilterImpl;

import java.util.ServiceLoader;

public class UsageRunnerImpl {
    public static void main(String[] args) {
        GreatFilterImpl filter = new GreatFilterImpl();
        System.out.printf("This is your filter %s\n", filter);
        System.out.println("Now let's try and load the service");
        ServiceLoader<Filter> filterServiceLoader = ServiceLoader.load(Filter.class);
        Filter loadedService = filterServiceLoader.iterator().next();
        System.out.printf("This is your filter %s\n", loadedService);
        System.out.println("We now call its array");
        System.out.println(loadedService.getList());
    }
}
