package org.jesperancinha.jtd.cats;

public sealed class interface Feline permits
        org.jesperancinha.jtd.cats.Lion,
        org.jesperancinha.jtd.cats.Panther,
        org.jesperancinha.jtd.cats.Tigre {
}
