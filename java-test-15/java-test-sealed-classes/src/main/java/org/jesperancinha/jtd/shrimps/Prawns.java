package org.jesperancinha.jtd.shrimps;

public sealed interface Prawns permits CookedPrawns, GrilledPrawns, GrilledTigerShrimps {

    String wrapInABox();
}
