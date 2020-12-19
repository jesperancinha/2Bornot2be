package org.jesperancinha.ocp11.crums.crum25;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum25 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 25 - Using try with resources");

        printMagentaGenericLn("There are many ways to use a try with resources");
        printMagentaGenericLn("Please check the code in order to understand.");
        try (var fos = new FileOutputStream("/tmp/tmp.txt")) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (final FileOutputStream fos = new FileOutputStream("/tmp/tmp.txt")) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        printBlueGenericLn("        // FileOutputStream fos;\n" + "        // Unknown class: 'fos'\n"
            + "        // try(fos = new FileOutputStream(\"tmp.txt\")){\n" + "        // \n"
            + "        // } catch (FileNotFoundException e) {\n" + "        //     e.printStackTrace();\n"
            + "        // } catch (IOException e) {\n" + "        //     e.printStackTrace();\n" + "        // }");

        // FileOutputStream fos;
        // Unknown class: 'fos'
        // try(fos = new FileOutputStream("tmp.txt")){
        //
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        printGreenGenericLn("An important rule to know is that try with resources needs to know the reference type");
        printGreenGenericLn("It can be done with a var or with the traditional way of type referencing");

    }
}
