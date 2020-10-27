package org.jesperancinha.ocp11.annotations.books;

/**
 * All of these annotations are retained in the source.
 * We should not see them via reflection
 */
@SuppressWarnings("serial")
public class SdkMysteryBook {
    @Override
    public String toString() {
        return super.toString();
    }
}
