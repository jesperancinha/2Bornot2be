package org.jesperancinha.ocp11.automated.modules.application;

import org.jesperancinha.ocp11.automated.modules.analytics.Analytics;
import org.jesperancinha.ocp11.automated.modules.database.Database;

public class Application {
    public static void main(String[] args) {
        System.out.println("I'm running!");
        Analytics.analyse();
        Database.useDatabase();
        System.out.println("I'm done!");
    }
}
