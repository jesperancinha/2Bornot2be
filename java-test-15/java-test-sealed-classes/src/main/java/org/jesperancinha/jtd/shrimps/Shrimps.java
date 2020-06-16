package org.jesperancinha.jtd.shrimps;

public sealed interface Shrimps permits CookedPrawns, GrilledPrawns, GrilledTigerShrimps {

    String wrapInABox();
}
