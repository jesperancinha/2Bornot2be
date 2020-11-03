package org.jesperancinha.ocp11.mastery2dot2;

import org.jesperancinha.ocp11.mastery2dot2.animals.Animal;
import org.jesperancinha.ocp11.mastery2dot2.animals.BirdCharacter;
import org.jesperancinha.ocp11.mastery2dot2.animals.Wolf;
import org.jesperancinha.ocp11.mastery2dot2.ost.manager.FileManager;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGeneric;

public class Mastery2Dot2Runner {
    public static void main(String[] args) {
        // 1. Interface Inheritance
        printYellowGeneric("### Creating wolf. Interface cannot access everything\n");
        Animal wolf = new Wolf("The Wolf");
        wolf.saySomething();
        printGreenGeneric("The wolf name is: %s. Of course now we use down casting\n",
                ((Wolf) wolf).name);
        // 2. Comparing with `thenComparing`
        printYellowGeneric("### Creating Bird. Interface cannot access everything\n");
        Animal bird = new BirdCharacter("Sasha");
        var list = List.of(wolf, bird);
        Comparator<Animal> comparator = Comparator.comparing(Animal::getName);
        Stream<Animal> animalStream = list.stream().sorted(comparator.thenComparing(Animal::found));
        printGreenGeneric("%s\n", list.toString());
        printGreenGeneric("The wolf name is: %s. Of course now we use down casting\n",
                ((Wolf) wolf).name);
        printGreenGeneric("The bird name is: %s. Of course now we use down casting\n",
                ((BirdCharacter) bird).name);
        printGreenGeneric("The new collection should be reordered: %s\n",
                animalStream.collect(Collectors.toList()));

        printYellowGeneric("### We will save our OST in /tmp/ost.txt.\n");
        printYellowGeneric("### After running there should be just one TEST text written on that file.\n");
        var filenameManager =  new FileManager();
        filenameManager.testFile();

    }
}
