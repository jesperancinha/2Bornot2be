package org.jesperancinha.java11.crums.crum18;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum18 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 18 - Locale building and resources");

        final Locale locale = new Locale.Builder().setLanguage("portunol")
            .setRegion("ZZ")
            .build();

        final Locale locale2 = new Locale.Builder().setLanguage("portunol")
            .setRegion("WW")
            .build();

        printMagentaGenericLn("We first try a happy case with locale -> %s", locale);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("dictionary", locale);
        resourceBundle.getKeys()
            .asIterator()
            .forEachRemaining(key -> Consolerizer.printOrangeGenericLn(resourceBundle.getString(key)));
        resourceBundle.getKeys()
            .asIterator()
            .forEachRemaining(Consolerizer::printOrangeGenericLn);

        printMagentaGenericLn("Now we first try an unhappy case with locale -> %s", locale2);
        try {
            ResourceBundle resourceBundle2 = ResourceBundle.getBundle("dictionary", locale2);
            resourceBundle2.getKeys()
                .asIterator()
                .forEachRemaining(key -> Consolerizer.printOrangeGenericLn(resourceBundle.getString(key)));
            resourceBundle2.getKeys()
                .asIterator()
                .forEachRemaining(Consolerizer::printOrangeGenericLn);
        } catch (final MissingResourceException e) {
            printRedGenericLn("This is expected. In this case we should have some files that do not exist");
            printRedGenericLn("We should have had dictionary_portunol_WW.properties or any of the default files");
            printRedGenericLn("These would be dictionary.properties or dictionary_portunol.properties");
            printRedGenericLn("Exception thrown -> %s", e);
        }

        printGreenGenericLn("For the resource bundle to work we have some default hierarchy to follow");
        printGreenGenericLn("<bundle_name>_<language>_<location>.properties");
        printGreenGenericLn("If a location is not available, the ResourceBundle will try to look for other default files");
        printGreenGenericLn("<bundle_name>_<language>.properties");
        printGreenGenericLn("or <bundle_name>.properties");
        printGreenGenericLn("If all fails, the ResourceBundle will not load and will throw a MissingResource Exception");
        printGreenGenericLn("Its important to note that getBundle is a static method which gives back a ResourceBundle");
        printGreenGenericLn("The builder for Language uses setLanguage and setRegion to define a Locale, which is needed along with the bundle name to create a Resource bundle");
    }
}
