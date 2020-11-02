package org.jesperancinha.ocp11.inferences;

public class InferencesRunner {

    public static void main(String[] args) {
        getMyStrings("Anne McCaffrey","Ursula K. Le Guin");
    }
    public static void getMyStrings(String... params) {
        var a = params;
        var b = params[0];

        System.out.println(a.getClass());
        System.out.println(b.getClass());
    }
}

