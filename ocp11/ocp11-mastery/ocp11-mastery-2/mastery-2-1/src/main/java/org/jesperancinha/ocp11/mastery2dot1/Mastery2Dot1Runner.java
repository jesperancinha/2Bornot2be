package org.jesperancinha.ocp11.mastery2dot1;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery2dot1.animals.Animal;
import org.jesperancinha.ocp11.mastery2dot1.animals.Bird;
import org.jesperancinha.ocp11.mastery2dot1.animals.BirdCharacter;
import org.jesperancinha.ocp11.mastery2dot1.animals.CatCharacter;
import org.jesperancinha.ocp11.mastery2dot1.animals.DuckCharacter;
import org.jesperancinha.ocp11.mastery2dot1.animals.Feline;
import org.jesperancinha.ocp11.mastery2dot1.animals.FluteService;
import org.jesperancinha.ocp11.mastery2dot1.animals.GrandFatherCharacter;
import org.jesperancinha.ocp11.mastery2dot1.animals.OboeService;
import org.jesperancinha.ocp11.mastery2dot1.animals.Wolf;
import org.jesperancinha.ocp11.mastery2dot1.animals.WolfCharacter;
import org.jesperancinha.ocp11.mastery2dot1.animals.WolfCharacter.Food;
import org.jesperancinha.ocp11.mastery2dot1.ost.manager.FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Mastery2Dot1Runner {
    public static void main(String[] args) throws Exception {
        Consolerizer.typingWaitGlobal = 0;
        // 1. Interface Inheritance
        printRainbowLn("==");
        printYellowGeneric("### 1. Creating wolf. Interface cannot access everything\n");
        Animal wolf = new WolfCharacter("The Wolf");
        wolf.saySomething();
        printGreenGeneric("The wolf name is: %s. Of course now we use down casting\n",
                ((Wolf) wolf).name);
        // 2. Comparing with `thenComparing`
        printRainbowLn("==");
        printYellowGeneric("### 2. Creating Bird. Interface cannot access everything\n");
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

        // 3. AccessController and Permissions
        printRainbowLn("==");
        printYellowGeneric("### 3. We will save our OST in /tmp/ost.txt.\n");
        printYellowGeneric("### After running there should be just one TEST text written on that file.\n");
        var filenameManager = new FileManager();
        filenameManager.testFile();

        // 4. Marking with `markSupported`s
        printRainbowLn("==");
        printYellowGenericLn("### 4. Checking how marking works with a BufferedReader");
        printYellowGenericLn("### Don't forget that readAhead is an optimization parameter");
        printYellowGenericLn("### It has no logic influence");
        try (Reader r = new BufferedReader(
                new FileReader(
                        new File(Mastery2Dot1Runner
                                .class.getResource("/lyrics.txt").toURI())))) {
            Consolerizer.printBrightCyanGenericLn("The Reader class does not support mark %s", new Reader() {
                @Override
                public int read(char[] cbuf, int off, int len) throws IOException {
                    return 0;
                }

                @Override
                public void close() throws IOException {

                }
            }.markSupported());
            Consolerizer.printBlueGenericLn("The BufferedReader class does support mark %s", r.markSupported());
            if (r.markSupported()) {
                BufferedReader in = (BufferedReader) r;
                Consolerizer.printGreenGenericLn(in.readLine());
                in.mark(5);
                Consolerizer.printBlueGenericLn(in.readLine());
                Consolerizer.printGreenGenericLn(in.readLine());
                in.reset();
                Consolerizer.printBlueGenericLn(in.readLine());
                in.reset();
                Consolerizer.printBlueGenericLn(in.readLine());
                Consolerizer.printGreenGenericLn(in.readLine());
                Consolerizer.printGreenGenericLn(in.readLine());
                Consolerizer.printGreenGenericLn(in.readLine());
                Consolerizer.printGreenGenericLn(in.readLine());
                Consolerizer.printGreenGenericLn(in.readLine());
                in.reset();
                Consolerizer.printBlueGenericLn(in.readLine());
            } else {
                Consolerizer.printRedGenericLn("Mark Not Supported");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        // 5. `StringBuilder` vs `StringBuffer`
        printRainbowLn("==");
        printYellowGenericLn("### 5. StringBuilder and StringBuffer have the same methods but their implementations are different.");
        printYellowGenericLn("### StringBuilder and StringBuffer do not have a trim() method like String does!.");

        var sBuilder = new StringBuilder();
        sBuilder.ensureCapacity(10);
        sBuilder.append(true);
        sBuilder.append("Okay, um, hmm, in that case, the part of the Grandfather will be played by, huh, a bassoon...\n");
        sBuilder.reverse();
        sBuilder.setLength(20);
        printGreenGenericLn(sBuilder.toString());
        sBuilder.trimToSize();
        printGreenGenericLn(sBuilder.toString());

        var sBuffer = new StringBuffer();
        sBuffer.ensureCapacity(10);
        sBuffer.append(true);
        sBuffer.append("Okay, um, hmm, in that case, the part of the Grandfather will be played by, huh, a bassoon...\n");
        sBuffer.reverse();
        sBuffer.setLength(20);
        printGreenGenericLn(sBuffer.toString());
        sBuffer.trimToSize();
        printGreenGenericLn(sBuffer.toString());

        // 6. Super constructors
        printRainbowLn("==");
        printYellowGenericLn("### 6. When you develop a subclass, its constructors must know which super constructor to call");
        printYellowGenericLn("### If none is available, then the default, zero argument constructor is called");
        printYellowGenericLn("### One or more are available, then the subclass constructor must determine which constructor to use using super");
        printYellowGenericLn("### One or more constructors are implemented and none default is available, then the default is no longer available");

        var birdCharacter = new BirdCharacter("Sasha");
        printGreenGenericLn(birdCharacter.getName());
        printGreenGenericLn(birdCharacter.getInstrument());

        // 7. Abstraction: Interfaces vs Classes
        printRainbowLn("==");
        printYellowGenericLn("### 7. Know a few things about Interfaces");
        printYellowGenericLn("### All methods without a body are implicitly abstract and public");
        printYellowGenericLn("### public and abstract are redundant for these implicit properties");
        printGreenGenericLn(wolf.getName());
        printGreenGenericLn(wolf.getInstrument());

        // 8. Stream filters
        printRainbowLn("==");
        printYellowGenericLn("### 8. A parallel stream can change to be a sequential stream");
        printYellowGenericLn("### BaseStream.sequential() vs BaseStream.parallel");
        printYellowGenericLn("### Also in partitionBy the way to distinguish is using Boolean");
        var duck = new DuckCharacter("Bruce");
        var cat = new CatCharacter("Louis");

        var streamOfCharacters1 = Stream.of(wolf, cat, bird, duck);
        var streamFull1 = streamOfCharacters1.filter(animal -> animal instanceof Bird);
        streamFull1.forEach(Consolerizer::printGreenGenericLn);
        var streamOfCharacters2 = Stream.of(wolf, cat, bird, duck);
        var streamFull2 = streamOfCharacters2.parallel()
                .filter(animal -> !(animal instanceof Wolf))
                .filter(animal -> !(animal instanceof Feline))
                .sequential();
        streamFull2.forEach(Consolerizer::printGreenGenericLn);
        var streamOfCharacters3 = Stream.of(wolf, cat, bird, duck);
        Map<Boolean, List<Animal>> partitionMap = streamOfCharacters3.collect(Collectors.partitioningBy(animal -> animal instanceof Bird));
        var streamFull3 = partitionMap.get(Boolean.TRUE).stream();
        streamFull3.forEach(Consolerizer::printGreenGenericLn);

        // 9. Question mark in Mappings (left vs right)
        printRainbowLn("==");
        printYellowGenericLn("### 9. You do not need to know the type on the left operand of an assignment operation");
        printYellowGenericLn("### You also cannot use diamond notation. You can use question marks as placeholders");
        printYellowGenericLn("### Question marks are not allowed on the right");
        printYellowGenericLn("### On a practical note it seems to be because a question mark is a wildcard");
        printYellowGenericLn("### Wildcards do not make sense during creation.");
        printYellowGenericLn("### Diamond notation always knows that its type is defined on the left ");

        Map<String, List<Animal>> mapOfAnimals1 = new HashMap<String, List<Animal>>();
        Map<String, List<Animal>> mapOfAnimals2 = new HashMap<>();
        Map<?, List<Animal>> mapOfAnimals3 = new HashMap<>();
        Map<?, List<?>> mapOfAnimals4 = new HashMap<>();
        Map<?, ?> mapOfAnimals5 = new HashMap<>();
        var mapOfAnimals6 = new HashMap<>();
        var mapOfAnimals7 = new HashMap<Animal, List<Animal>>();

        printBlueGenericLn("Map<String, List<Animal>> mapOfAnimals1 = new HashMap<String, List<Animal>>(); -> %s", mapOfAnimals1.getClass());
        printBlueGenericLn("Map<String, List<Animal>> mapOfAnimals2= new HashMap<>();", mapOfAnimals2.getClass());
        printBlueGenericLn("Map<?, List<Animal>> mapOfAnimals3 = new HashMap<>(); -> %s", mapOfAnimals3.getClass());
        printBlueGenericLn("Map<?, List<?>> mapOfAnimals4 = new HashMap<>(); -> %s", mapOfAnimals4.getClass());
        printBlueGenericLn("Map<?,?> mapOfAnimals5 = new HashMap<>(); -> %s", mapOfAnimals5.getClass());
        printBlueGenericLn("var mapOfAnimals6 = new HashMap<>(); -> %s", mapOfAnimals6.getClass());
        printBlueGenericLn("var mapOfAnimals7 = new HashMap<Animal, List<Animal>>(); -> %s", mapOfAnimals7.getClass());

        // 10. provider() in modularity
        printRainbowLn("==");
        printYellowGenericLn("### 10. Key things to remember:");
        printYellowGenericLn("### There is no implements in module!");
        printYellowGenericLn("### provides is always followed by with");
        printYellowGenericLn("### using a service requires you to use it in the module definition");
        printYellowGenericLn("### to be able to implement a service outside the source module you need requires");
        printYellowGenericLn("### You can provide an implementation statically or with an instance");
        printYellowGenericLn("### Flute service is static");
        printYellowGenericLn("### Oboe service is an instance");

        ServiceLoader<FluteService> loader = ServiceLoader.load(FluteService.class);
        FluteService fluteService = loader.findFirst().orElseThrow(() -> new Exception("Fail!"));
        fluteService.play();
        ServiceLoader<OboeService> loader2 = ServiceLoader.load(OboeService.class);
        OboeService oboeService = loader2.findFirst().orElseThrow(() -> new Exception("Fail!"));
        oboeService.play();

        // 11. `IndexOutOfBoundsException`
        printRainbowLn("==");
        printYellowGenericLn("### 11. ArrayIndexOutOfBoundsException is not thrown by a charAt.");
        printYellowGenericLn("### IndexOutOfBoundsException is  thrown by a charAt.");
        printYellowGenericLn("### StringIndexOutOfBoundsException may be thrown by a charAt (It is implementation dependent).");

        var testString = "Can't make it? Oh. Huh.";
        try {
            testString.charAt(10000);
        } catch (IndexOutOfBoundsException e) {
            printGreenGenericLn("If parameter of charAt surpasses the length of the String, it results in: %s", e.getClass());
        }

        // 12. `allMatch` in stream
        printRainbowLn("==");
        printYellowGenericLn("### 12. allMatch means that one doesn't match, it will return false, otherwise true");
        printYellowGenericLn("### It is prone to fail fast, given that the false condition determines when the filtering stops");
        printYellowGenericLn("### This operation depends opn how many cores your machine is running on");

        AtomicInteger atomicInteger = new AtomicInteger();
        var streamOfCharacters = Stream.of(wolf, cat, bird, duck);
        var allMatchesForA = streamOfCharacters.allMatch(
                character -> {
                    atomicInteger.incrementAndGet();
                    printGreenGenericLn(character);
                    return character.getName().contains("o");
                });
        printGreenGenericLn("We have iterated %d times! This is unpredictable", atomicInteger.get());
        printGreenGenericLn("Has the condition matched? %s", allMatchesForA);


        // 10. provider() in modularity
        printRainbowLn("==");
        printYellowGenericLn("### 10. Double providers in modularity");
        ServiceLoader<FluteService> loader2Times = ServiceLoader.load(FluteService.class);
        Iterator<FluteService> iterator = loader.iterator();
        FluteService fluteServiceOne = iterator.next();
        FluteService fluteServiceTwo = iterator.next();
        fluteServiceOne.play();
        fluteServiceTwo.play();

        // 14. One line assignment operations
        printRainbowLn("==");
        printYellowGenericLn("### 14. One liner operators and different assignments");
        int a = 10;
        int b = 20;
        boolean c = a == b;
        boolean d = a != b;
        int f = a = b;
        printBlueGenericLn("        int a = 10; => %d\n" +
                "        int b = 20; => %d \n" +
                "        boolean c = a == b; => %s\n" +
                "        boolean d = a != b; => %s\n" +
                "        int f = a = b; => %d", a, b, c, d, f);

        // 15. Method calling and inner class instantiation
        printRainbowLn("==");
        printYellowGenericLn("### 15. Static imports are also possible for static inner classes");
        var food = new Food();
        printBlueGenericLn("var food  = new Food();");

        // 16. `null` role in collection copies
        printRainbowLn("==");
        printYellowGenericLn("### 16. Copies of null values from Arrays to immutable Lists  always fail");
        printYellowGenericLn("### Copies of null values from Arrays always to Unmodifiable lists don't fail");
        printYellowGenericLn("### Unmodifiable means you have a reference that doesn't allow you to modify the list");
        printYellowGenericLn("### Although if you have the reference to the original List, then you can change it that way");
        printYellowGenericLn("### Immutable means you cannot modify the list");
        var animals = new Animal[]{wolf, duck, null, bird, null, cat};
        try {
            var listOfAnimals = List.of(animals);
        } catch (NullPointerException e) {
            printRedGenericLn("%s was thrown on trying to copy the array into an immutableList -> var listOfAnimals = List.of(animals);", e);
        }
        try {
            List<Animal> animalList = List.of(wolf, duck, null, bird, null, cat);
        } catch (NullPointerException e) {
            printRedGenericLn("%s was thrown on trying to create an immutable list directly -> List<Animal> animalList = List.of(wolf, duck, null, bird, null, cat);", e);
        }

        List<Animal> animalList = Arrays.asList(wolf, duck, null, bird, null, cat);

        var listOfAnimalsViaCollectionSync = Collections.synchronizedList(animalList);
        var listOfAnimalsViaCollectionUnmod = Collections.unmodifiableList(animalList);
        printGreenGenericLn(listOfAnimalsViaCollectionSync);
        printGreenGenericLn(listOfAnimalsViaCollectionUnmod);

        // 17. `String`'s `isBlank`
        printRainbowLn("==");
        printYellowGenericLn("### 17. Test is String is blank");
        var blankSimple = "";
        var blankComplicated = "      ";
        printGreenGenericLn("blankSimple is blank? %s, blankComplicated is blank? %s",
                blankSimple.isBlank(), blankComplicated.isBlank());

        // 18. Flow control ans specification of Exceptions
        printRainbowLn("==");
        printYellowGenericLn("### 18. Always use control flow in detriment to Exceptions");

        // 19. Constructor rules vs Method rules in overriding
        printRainbowLn("==");
        printYellowGenericLn("### 19. Constructor exception implementation rules are inversely proportional to method return parameter implementation rules");
        var grandFather = new GrandFatherCharacter("The Grandfather");
        printGreenGenericLn(grandFather.getName());
        printGreenGenericLn(grandFather.name);
        printGreenGenericLn(grandFather.found());

        // 20. Simple `File` creation with `FileWriter`
        printRainbowLn("==");
        printYellowGenericLn("### 20. FileWriter always creates a file");
        var file = new FileWriter("/tmp/wolfdata.txt");
        file.close();
        printGreenGenericLn("Check your %s folder", file.toString());

        // 21. Overriding with generics
        printRainbowLn("==");
        printYellowGenericLn("### 21. Golden rule of Overriding methods is that the return value is always of a sub-class or the same as of the overridden one");
        abstract class Multiplexer {
            abstract <T> Collection<T> toList(Collection<T> list);

            abstract <T> Collection<T> toSet(Collection<T> list);
        }
        class CharacterDeduplicator extends Multiplexer {
            public <T> List<T> toList(Collection<T> list) {
                return new ArrayList<>(list);
            }

            ;

            public <V> Set<V> toSet(Collection<V> list) {
                return new HashSet<>(list);
            }

            ;
        }
        var dedup = new CharacterDeduplicator();
        var characterComplete = List.of(wolf, cat, bird, bird, duck, grandFather);
        var characterSet = dedup.toSet(characterComplete);
        printGreenGenericLn(characterComplete);
        printGreenGenericLn(characterSet);
        var characterReComplete = dedup.toList(characterSet);
        characterReComplete.add(duck);
        printGreenGenericLn(characterReComplete);

        // 22. `var` in `for` loops
        printRainbowLn("==");
        printYellowGenericLn("### 22. var can be used in for just like int");
        printRainbowLn("-");
        for (int i = 0; i < 10; i++) {
            printGreenGeneric(i);
        }
        printRainbowLn("-");
        for (var i = 0; i < 10; i++) {
            printGreenGeneric(i);
        }
        printRainbowLn("-");

        // 23. relativize of `Path`
        printRainbowLn("==");
        printYellowGenericLn("### 23. relativize will fail if paths have a different sort");
        var p1 = Path.of("wolf");
        var p2 = Path.of("/tmp/wolf");
        try {
            p1.relativize(p2);
        } catch (java.lang.IllegalArgumentException e) {
            printRedGenericLn("%s -> Process failed for p1=%s and p2=%s", e ,p1, p2);
        }
        p2 = Path.of("tmp");
        printGreenGenericLn("Process didn't fail for p1=%s and p2=%s and the result for p2.relativize(p1) is: %s", p1, p2, p2.relativize(p1));

        p2 = Path.of("/tmp/wolf");
        p1 = Path.of("/tmp/wolf/2");
        printGreenGenericLn("Process didn't fail for p1=%s and p2=%s and the result for p2.relativize(p1) is: %s", p1, p2, p2.relativize(p1));

        // 24. Creating methods in inner anonymous classes
        printRainbowLn("==");
        printYellowGenericLn("### 24. If we create an anonymous class and therein we crate methods,those methods are onle reachable via reflection or inside the instance itself");
        var wolfFood = new Food() {
            public void giveMeApples() {
                printGreenGeneric("You did this? You just cannot reach this method without reflection and so The Wolf gets no apples!");
            }
        };
        Method giveMeApples = wolfFood.getClass().getMethod("giveMeApples");
        giveMeApples.invoke(wolfFood);
    }
}