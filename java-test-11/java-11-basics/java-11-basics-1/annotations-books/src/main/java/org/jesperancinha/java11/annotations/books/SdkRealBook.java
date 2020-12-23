package org.jesperancinha.java11.annotations.books;

import java.util.List;

@FunctionalInterface
@Deprecated
public interface SdkRealBook {
    void varagSafeMethod(List<String>... stringLists);
}
