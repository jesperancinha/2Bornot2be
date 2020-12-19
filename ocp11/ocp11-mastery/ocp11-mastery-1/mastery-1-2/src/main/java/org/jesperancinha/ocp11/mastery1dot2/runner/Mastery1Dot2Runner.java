package org.jesperancinha.ocp11.mastery1dot2.runner;

import org.jesperancinha.console.consolerizer.ConColor;
import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery1dot2.runn1er.FailMutantTurtle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import static org.jesperancinha.console.consolerizer.ConColor.BRIGHT_CYAN;

public class Mastery1Dot2Runner {
    public static void main(String[] args) throws InterruptedException {
        // 1. Root Interfaces Collection and Map
        var typingWait = 0;
        var console = Consolerizer.createGreen().typingWait(typingWait);
        var slogan = "Heroes in a half shell. Turtle power!";
        console.printText("@@@@@@@@@ Welcome to %s @@@@@@@@@\n", slogan);
        console.conColor(ConColor.RED);
        console.printText("WOW!\n");

        String splinterMain = "Splinter";
        var mapTurtles = new HashMap<String, String>() {{
            String splinter = splinterMain;
            put("Leonardo", splinter);
            put("Raphael", splinter);
            put("Michelangelo", splinter);
            put("Donatello", splinter);
        }};
        console.conColor(BRIGHT_CYAN);
        console.printText("These all report to %s:\n%s\n", splinterMain, mapTurtles.toString());
        console.conColor(ConColor.YELLOW);
        console.printText("@@ As you can see a Map is no collection!\n");
        console.printGreen("var mapTurtles = new HashMap<String, String>() {{\n" +
                "            String splinter = splinterMain;\n" +
                "            put(\"Leonardo\", splinter);\n" +
                "            put(\"Raphael\", splinter);\n" +
                "            put(\"Michelangelo\", splinter);\n" +
                "            put(\"Donatello\", splinter);\n" +
                "        }};\n");
        console.printRed("Collection test2 = mapTurtles;\n");
        console.printGreen("Map test = mapTurtles;\n");

        var villains = List.of(
                "The Shredder",
                "Karai",
                "Baxter Stockman",
                "Krang",
                "Bebop",
                "Rocksteady");
        console.printBrightCyan("These all report to %s\n%s\n", "Shredder", villains.toString());
        console.printText("@@ As you can see a List is no Map!\n");
        console.printGreen(" var villains = List.of(\n" +
                "                \"The Shredder\",\n" +
                "                \"Karai\",\n" +
                "                \"Baxter Stockman\",\n" +
                "                \"Krang\",\n" +
                "                \"Bebop\",\n" +
                "                \"Rocksteady\");\n");

        console.printRed("Map test= villains;\n");
        console.printGreen("Collection test2 = villains;\n");

        // 2. Thread-safe and thread-unsafe standard collections
        console.printText("@@ Same collections but with thread unsafe instances\n");

        var mapTurtlesSynchronizedUnsafe = new Hashtable<String, String>() {{
            final String splinter = splinterMain;
            put("Leonardo", splinter);
            put("Raphael", splinter);
            put("Michelangelo", splinter);
            put("Donatello", splinter);
        }};
        console.printGreen("We remove Donatello from the Hashtable to see what happens\n");
        try {
            mapTurtlesSynchronizedUnsafe.forEach((s, s2) -> mapTurtlesSynchronizedUnsafe.remove("Donatello"));
        } catch (ConcurrentModificationException e) {
            console.printRed("A ConcurrentModificationException has occurred! It's not safe!%s\n", e.getMessage());
        }

        var villainsSynchronizedUnsafe = new Vector<String>();
        villainsSynchronizedUnsafe.add("The Shredder");
        villainsSynchronizedUnsafe.add("Karai");
        villainsSynchronizedUnsafe.add("Baxter Stockman");
        villainsSynchronizedUnsafe.add("Krang");
        villainsSynchronizedUnsafe.add("Bebop");
        villainsSynchronizedUnsafe.add("Rocksteady");
        console.printGreen("We remove Krang from the Vector to see what happens\n");
        try {
            villainsSynchronizedUnsafe.forEach((s) -> villainsSynchronizedUnsafe.remove("Karai"));
        } catch (ConcurrentModificationException e) {
            console.printRed("A ConcurrentModificationException has occurred! It's not safe!%s\n", e.getMessage());
        }

        console.printText("@@ As a cherry on the cake let's modify an unmodifiable list\n");
        console.printBrightCyan("var villainsUnmodifiable = Collections.unmodifiableCollection(villains);\n");
        var villainsUnmodifiable = Collections.unmodifiableCollection(villains);
        try {
            villainsUnmodifiable.add("Rookie");
        } catch (UnsupportedOperationException e) {
            console.printRed("We cannot modify, unmodifiable collections ok?\n");
        }

        // 4. Default methods multi-implementation
        console.printText("@@ With default methods, we can provide multiple implementations\n");
        console.printText("@@ We want a hard shell, but also to be able to have some movement in it\n");
        var shell = new Shell();
        shell.protectTheShell();

        // 5. Return type in overriden methods
        console.printText("@@ We create the Splinter lab and create a turtle\n");
        var lab = new SplinterLab();
        lab.doExperiment();

        // 6. Properties of a JDBC connection
        try {
            Properties p = new Properties();
            p.setProperty("user", "sa");
            p.setProperty("password", "");
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:", p);
            System.out.printf("Connection: %s / %s\n", conn.getMetaData().getDatabaseProductName(), conn.getCatalog());
            System.out.printf("Current auto-commit setting: %s\n", conn.getAutoCommit());
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 7. The `protected` nuances
        console.printText("@@ With protected we can only sneaky feel the other turtle's hand from the outside\n");
        var failMutantTurtle = new FailMutantTurtle();
        failMutantTurtle.feelHandOfAnotherTurtle();
        failMutantTurtle.feelHandOfAnotherTurtleSneaky();

        // 8. Nested class inheritance
        console.printText("@@ Here is a secret lab and its our own!\n");
        SplinterLab.SecretLab secretLab = lab.new SecretLab();
        SplinterLab lab1 = secretLab.getLab();

        // 9. Conversion information losses
        console.printText("@@ One final sprint!\n");
        int leftSide = 1098765432;
        Consolerizer.printGreenGeneric("Left side as float %f\n", 1098765432f);
        Consolerizer.printGreenGeneric("Left side %d\n", leftSide);
        float rightSide = leftSide;
        Consolerizer.printGreenGeneric("Right side %f\n", rightSide);
        Consolerizer.printGreenGeneric("Right side casted to int %d\n", (int) rightSide);
        Consolerizer.printGreenGeneric(Integer.toString(leftSide - (int) rightSide));
    }
}