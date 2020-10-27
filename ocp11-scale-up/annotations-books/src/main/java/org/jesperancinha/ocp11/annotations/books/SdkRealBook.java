package org.jesperancinha.ocp11.annotations.books;

import java.util.List;

@FunctionalInterface
@Deprecated
public interface SdkRealBook {
    void varagSafeMethod(List<String>... stringLists);
}
