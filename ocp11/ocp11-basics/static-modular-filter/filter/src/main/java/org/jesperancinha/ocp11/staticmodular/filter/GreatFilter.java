package org.jesperancinha.ocp11.staticmodular.filter;

import org.jesperancinha.ocp11.staticmodular.api.Filter;

import java.util.Arrays;
import java.util.List;

public class GreatFilter {
    public static Filter provider() {
        return new Filter() {
            @Override
            public List<String> getList() {
                return Arrays.asList("a","b");
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @Override
            public String toString() {
                return super.toString();
            }

            @Override
            protected void finalize() throws Throwable {
                super.finalize();
            }
        };
    }
}
