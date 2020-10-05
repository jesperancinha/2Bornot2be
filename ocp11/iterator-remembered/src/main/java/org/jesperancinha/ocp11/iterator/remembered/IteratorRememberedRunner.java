package org.jesperancinha.ocp11.iterator.remembered;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class IteratorRememberedRunner {

    public static void main(String[] args) {
        filterData();
        filterDataSimplified();
        filterDataWithPredicate();
    }

    public static void filterData(ArrayList<Astronaut> astronautList, AstronautFilter f) {
        Iterator<Astronaut> i = astronautList.iterator();
        while (i.hasNext()) {
            if (f.test(i.next())) {
                i.remove();
            }
        }
    }

    public static void filterDataWithPredicate(ArrayList<Astronaut> astronautList, Predicate<Astronaut> f) {
        Iterator<Astronaut> i = astronautList.iterator();
        while (i.hasNext()) {
            if (f.test(i.next())) {
                i.remove();
            }
        }
    }

    public static void filterDataSimplified(ArrayList<Astronaut> astronautList, AstronautFilter f) {
        astronautList.removeIf(f::test);
    }

    private static void filterDataSimplified() {
        ArrayList<Astronaut> al = new ArrayList<>();
        Astronaut d = new Astronaut("Christa McAuliffe");
        al.add(d);
        d = new Astronaut("Kalpana Chawla");
        al.add(d);
        d = new Astronaut("Sally Ride");
        al.add(d);
        d = new Astronaut("Mae Jemison");
        al.add(d);
        d = new Astronaut("Eileen Collins");
        al.add(d);
        d = new Astronaut("Ellen Ochoa");
        al.add(d);
        filterDataSimplified(al, new AstronautFilter());
        System.out.println(al);
    }

    private static void filterData() {
        ArrayList<Astronaut> al = new ArrayList<>();
        Astronaut d = new Astronaut("Christa McAuliffe");
        al.add(d);
        d = new Astronaut("Kalpana Chawla");
        al.add(d);
        d = new Astronaut("Sally Ride");
        al.add(d);
        d = new Astronaut("Mae Jemison");
        al.add(d);
        d = new Astronaut("Eileen Collins");
        al.add(d);
        d = new Astronaut("Ellen Ochoa");
        al.add(d);
        filterData(al, new AstronautFilter());
        System.out.println(al);
    }

    private static void filterDataWithPredicate() {
        ArrayList<Astronaut> al = new ArrayList<>();
        Astronaut d = new Astronaut("Christa McAuliffe");
        al.add(d);
        d = new Astronaut("Kalpana Chawla");
        al.add(d);
        d = new Astronaut("Sally Ride");
        al.add(d);
        d = new Astronaut("Mae Jemison");
        al.add(d);
        d = new Astronaut("Eileen Collins");
        al.add(d);
        d = new Astronaut("Ellen Ochoa");
        al.add(d);
        filterDataWithPredicate(al, x-> x.name.contains("Ch"));
        System.out.println(al);
    }
}
