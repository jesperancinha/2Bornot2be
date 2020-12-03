package org.jesperancinha.ocp11.annotations.books;

import java.util.List;

public class SdkRealBookImpl implements SdkRealBook{
    @Override
    @SafeVarargs
    public final void varagSafeMethod(List<String>... stringLists) {
    }
}
