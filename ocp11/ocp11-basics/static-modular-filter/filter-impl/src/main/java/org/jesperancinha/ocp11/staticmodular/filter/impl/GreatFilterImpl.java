package org.jesperancinha.ocp11.staticmodular.filter.impl;

import org.jesperancinha.ocp11.staticmodular.api.Filter;

import java.util.Arrays;
import java.util.List;

public class GreatFilterImpl implements Filter {
    @Override
    public List<String> getList() {
        return Arrays.asList("No","Yes","Nee","Nein","Não");
    }
}
