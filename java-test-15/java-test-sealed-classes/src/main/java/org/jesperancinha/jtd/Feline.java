package org.jesperancinha.jtd;

public class sealed interface Feline permits
        org.jesperancinha.jtd.Lion,
        org.jesperancinha.jtd.Panther,
        org.jesperancinha.jtd.Tigre {
}
