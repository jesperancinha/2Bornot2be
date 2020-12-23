package org.jesperancinha.java11.crums.crum13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum13 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        printBlueGenericTitleLn("Crum 13 - Serialization of objects into files. The non serialized");

        printMagentaGenericLn(
            "We create a table model 5A, which is 5 meters tall and 25 square meters area. Tall table eh? 😊");

        var table = new Table5A();

        var output = new FileOutputStream("/tmp/table.object");
        var oos = new ObjectOutputStream(output);
        oos.writeObject(table);
        oos.close();
        output.close();

        var input = new FileInputStream("/tmp/table.object");
        var ois = new ObjectInputStream(input);
        try {
            Table5A table5A = (Table5A) ois.readObject();
            printYellowGenericLn(
                "See, with the uncommented default empty constructors you were able to deserialize our Table5A: %s",
                table5A);
        } catch (InvalidClassException e) {
            printRedGenericLn(
                "This is expected! All classes in the hierarchy must have a default public empty constructor when deserializing -> %s",
                e);
            printRedGenericLn("Try again with the uncommented constructors to see how this works.");
        }
        printGreenGenericLn("There is a difference between creating serializable classes in inner classes");
        printGreenGenericLn(
            "In a normal case, is the subclass is serializable, the others must have a default empty constructor");
        printGreenGenericLn(
            "If the inner class is being serialized, both wrapper class and inner class must be serializable");
        printGreenGenericLn(
            "The requirement then changes and being serializable is the must requirement for the upper classes.");
    }
}
