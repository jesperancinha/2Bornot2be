package org.jesperancinha.ocp11.staticmodular.filter;

import org.jesperancinha.ocp11.staticmodular.api.Filter;

import java.util.Arrays;
import java.util.List;

public class GreatFilterImpl1 implements Filter {
    @Override
    public List<String> getList() {
        return Arrays.asList("No","Yes","Nee","Nein","Não");
    }
}
