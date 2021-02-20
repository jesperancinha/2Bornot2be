package org.jesperancinha.jtd.shrimps;

public sealed interface Shrimps permits CookedShrimps {

    String wrapInABox();
}
