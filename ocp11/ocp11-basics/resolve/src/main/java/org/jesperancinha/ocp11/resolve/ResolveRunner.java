package org.jesperancinha.ocp11.resolve;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveRunner {
    public static void main(String[] args) {
        Path p1 = Paths.get("/tmp/thesinner");
        Path p2 = Paths.get("HarryAmbrose");
        Path p3 = Paths.get("/tmp/thesinner/NickHaas");
        System.out.println(p2 + "  resolves " + p1);
        System.out.println(p2.resolve(p1));
        System.out.println(p1 + "  resolves " + p2);
        System.out.println(p1.resolve(p2));
        System.out.println(p3 + "  resolves " + p1);
        System.out.println(p3.resolve(p1));
        System.out.println(p1 + "  resolves " + p3);
        System.out.println(p1.resolve(p3));
    }
}
