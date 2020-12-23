package org.jesperancinha.java11.mastery2dot2;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.compare;
import static java.util.Arrays.mismatch;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Master2Dot2Runner {
    public static void main(String[] args) {

        Consolerizer.typingWaitGlobal = 0;

        printBlueGenericLn("================== Master Module mastery-2-2 ==================");

        printRainbowTitleLn("1. Serializing `FileOutputStream` and `FileInputStream`");
        printRainbowLn("==");
        printYellowGeneric("### Creating Apollo 13 Mission but missing a few details\n");
        String fileName = "/tmp/destination";
        try (var fileOutputStream = new FileOutputStream(fileName);
             var objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            var missionData = new MissionData();
            missionData.destination = "The Moon";
            missionData.origin = "Earth";
            missionData.mission = "Apollo 13";
            objectOutputStream.writeObject(missionData);
            printGreenGenericLn("File has been created on this location -> %s", fileName);
            printGreenGenericLn("Data -> %s", missionData);
            printGreenGenericLn("Please run module %s to realize that default fields are read with Java default values and not the assigned ones,\nif they are not part of the serialized data", "mastery-2-2-deserializer");
        } catch (IOException e) {
            e.printStackTrace();
        }

        printRainbowTitleLn("2. `compare` and `mismatch` in arrays");
        printRainbowLn("==");
        printYellowGenericLn("### We compare two arrays defining the crew and test mismatch and compare");
        var astronauts1 = new String[]{"James A. Lovell", "John L. Swigert, Jr.", "Fred W. Haise, Jr."};
        var astronauts2 = new String[]{"Jim Lovell", "Jack Swigert", "Fred Haise"};
        var astronauts3 = new String[]{"James A. Lovell", "Jack Swigert", "Fred W. Haise, Jr."};
        printBrightCyanGenericLn("comparing %s with %s -> result is: %s", astronauts1, astronauts2, compare(astronauts1, astronauts2));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts1[0], astronauts2[0], astronauts1[0].compareTo(astronauts2[0]));
        printBrightCyanGenericLn("comparing %s with %s -> result is: %s", astronauts1, astronauts3, compare(astronauts1, astronauts3));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts1[1], astronauts3[1], astronauts1[1].compareTo(astronauts3[1]));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts3[1], astronauts1[1], astronauts3[1].compareTo(astronauts1[1]));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts1[2], astronauts3[2], astronauts1[2].compareTo(astronauts3[2]));
        printBrightCyanGenericLn("comparing %s with %s -> result is: %s", astronauts2, astronauts3, compare(astronauts2, astronauts3));
        printYellowGenericLn("### We mismatch two arrays defining the crew and test mismatch and compare");
        printBrightCyanGenericLn("mismatching %s with %s -> result is: %s", astronauts1, astronauts2, mismatch(astronauts1, astronauts2));
        printGreenGenericLn("mismatching %s with %s -> result is: %s", astronauts1[0], astronauts2[0], astronauts1[0].compareTo(astronauts2[0]));
        printBrightCyanGenericLn("mismatching %s with %s -> result is: %s", astronauts1, astronauts3, mismatch(astronauts1, astronauts3));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts1[1], astronauts3[1], astronauts1[1].compareTo(astronauts3[1]));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts3[1], astronauts1[1], astronauts3[1].compareTo(astronauts1[1]));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts1[2], astronauts3[2], astronauts1[2].compareTo(astronauts3[2]));
        printBrightCyanGenericLn("mismatching %s with %s -> result is: %s", astronauts2, astronauts3, mismatch(astronauts2, astronauts3));
        printYellowGenericLn("### Note that comparing is different with integers");
        var badCounting = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 1};
        var goodCounting = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        var badCounting2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 11};
        var badCounting2AndShort = new int[]{1, 2, 3};
        printGreenGenericLn("comparing %s with %s -> result is: %s", badCounting, goodCounting, Arrays.compare(badCounting, goodCounting));
        printGreenGenericLn("mismatching %s with %s -> result is: %s", badCounting, goodCounting, Arrays.mismatch(badCounting, goodCounting));
        printGreenGenericLn("comparing %s with %s -> result is: %s", badCounting2, goodCounting, Arrays.compare(badCounting2, goodCounting));
        printGreenGenericLn("comparing %s with %s -> result is: %s", badCounting2AndShort, goodCounting, Arrays.compare(badCounting2AndShort, goodCounting));

        printRainbowTitleLn("3. TYPE_USE and TYPE_PARAMETER");
        printRainbowLn("==");
        printYellowGenericLn("### A TYPE_USE case");
        printBlueGenericLn("@Rocket String rocket1 = \"Saturn V\";");
        @Rocket String rocket1 = "Saturn V";
        printBlueGenericLn("var rocket2 = (@Rocket String) \"Saturn V\";");
        var rocket2 = (@Rocket String) "Saturn V";
        printBlueGenericLn("Function<Integer, String> f = ( @Rocket Integer val ) -> Integer.toHexString(val);");
        Function<Integer, String> f = (@Rocket Integer val) -> Integer.toHexString(val);
        printYellowGenericLn("### A TYPE_PARAMETER case");
        var missionModified = new MissionDataTyped<String>();
        printBlueGenericLn("var missionModified = new MissionDataTyped<String>();");
        printYellowGenericLn("### Not that TYPE_PARAMETER is a part of TYPE_USE. If you have TYPE_USE, you don't need TYPE_PARAMETER");

        printRainbowTitleLn("4. Switch valid numeric types and their limits");
        printRainbowLn("==");
        printYellowGenericLn("### Permitted Values");
        printYellowGenericLn("### short");
        printGreenGenericLn("%s <= byte <= %s", Byte.MIN_VALUE, Byte.MAX_VALUE);
        printYellowGenericLn("### byte");
        printGreenGenericLn("%s <= short <= %s", Short.MIN_VALUE, Short.MAX_VALUE);
        printYellowGenericLn("### int");
        printGreenGenericLn("%s <= short <= %s", Integer.MIN_VALUE, Integer.MAX_VALUE);
        printYellowGenericLn("### char");
        printGreenGenericLn("%d <= char <= %d", (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
        printGreenGenericLn("%c <= char <= %c", Character.MIN_VALUE, Character.MAX_VALUE);
        printRedGenericLn("### Not permitted Values");
        printRedGenericLn("### bool");
        printRedGenericLn("%s <= bool <= %s", Boolean.FALSE, Boolean.TRUE);
        printRedGenericLn("### long");
        printRedGenericLn("%s <= long <= %s", Long.MIN_VALUE, Long.MAX_VALUE);
        printRedGenericLn("### float");
        printRedGenericLn("%s <= float <= %s", Float.MIN_VALUE, Float.MAX_VALUE);
        printRedGenericLn("### double");
        printRedGenericLn("%s <= double <= %s", Double.MIN_VALUE, Double.MAX_VALUE);

        printRainbowTitleLn("5. Float value declaration");
        printRainbowLn("==");
        printYellowGenericLn("### We try to assign an absolute number");
        float fNumber = 1000;
        printBlueGenericLn(fNumber);
        printYellowGenericLn("### We try to assign a number with decimals. Think that by default they are double");
        fNumber = 100.12345f;
        printBlueGenericLn(fNumber);
        printYellowGenericLn("### With a double, we do not need to cast");
        double dNumber = 100.45677;
        printBlueGenericLn(dNumber);

        printRainbowTitleLn("6. Conflicting exports in modularization");
        printRainbowLn("==");
        printYellowGenericLn("### Check the module definitions of this module");

        printRainbowTitleLn("7. Multi interface inheritance");
        printRainbowLn("==");
        printYellowGenericLn("### Check the two interfaces. There is a subclass which overrides the superclass method. This is Ok");
        printBlueGenericLn("public interface BriefingTrajectory {\n" +
                "    String getOriginLocation();\n" +
                "    String getDestinationLocation();\n" +
                "}");
        printYellowGenericLn("### And this is the sub interface");
        printBlueGenericLn("public interface MissionBriefingControl extends BriefingDate, BriefingTrajectory {\n" +
                "    String getDestinationLocation();\n" +
                "    String getDestinationLocation(MissionData missionData);\n" +
                "    LocalDateTime getBriefingDate();\n" +
                "    String getOriginLocation();\n" +
                "}");


        printRainbowTitleLn("8. `Function`'s and `ToFunction`'s");
        printRainbowLn("==");
        ToDoubleFunction<String> toDoubleFunction = a -> {
            if (a.equals("SATCAT")) {
                return 4371;
            }
            return -1;
        };
        DoubleFunction<String> doubleFunction = a -> {
            if (a == 4371) {
                return "SATCAT";
            }
            return null;
        };
        printYellowGenericLn("### A ToDoubleFunction uses an Object parameter, but always returns a primitve");
        printYellowGenericLn("### The name is self-exlanatory. To<>Function's always return a primitive type");
        printGreenGenericLn(toDoubleFunction.applyAsDouble("SATCAT"));
        printGreenGenericLn(toDoubleFunction.applyAsDouble("AAAAAA"));
        printYellowGenericLn("### A DoubleFunction uses an double parameter, but always returns an object");
        printYellowGenericLn("### The name is self-exlanatory. <>Function's always receive a primitive type");
        printGreenGenericLn(doubleFunction.apply(4371));
        printGreenGenericLn(doubleFunction.apply(2222));

        printRainbowTitleLn("9. `--add-exports` and `--add-reads` in modularization");
        printRainbowLn("==");
        printYellowGenericLn("### Check module mastery-2-2-modularity for an example in action");

        printRainbowTitleLn("10. Security guidelines");
        printRainbowLn("==");
        printYellowGenericLn("### Check https://www.oracle.com/java/technologies/javase/seccodeguide.html for more info on java security");

        printRainbowTitleLn("11. Project Jigsaw");
        printRainbowLn("==");
        printYellowGenericLn("### Check http://cr.openjdk.java.net/~mr/jigsaw/ea/module-summary.html for more info on java.base");

        printRainbowTitleLn("12. `AutoCloseable`close method and exception handling");
        printRainbowLn("==");
        printYellowGenericLn("### AutoCloseable interface and exception handling");
        var rocketInfoFile = "/tmp/rocket-info.txt";
        try (FileOutputStream fos = new FileOutputStream(rocketInfoFile)) {
            fos.write("2,949,136".getBytes());
            throw new NullPointerException("See? I can throw NullPointerException whenever I want!");
        } catch (IOException | NullPointerException e) {
            printRedGenericLn("%s", e);
        }
        FileInputStream fisOut = null;
        try (FileInputStream fis = new FileInputStream(rocketInfoFile)) {
            byte[] bytes = fis.readAllBytes();
            printGreenGenericLn(new String(bytes));
            fisOut = fis;
        } catch (IOException e) {
            printRedGenericLn("%s", e);
        }
        try {
            fisOut.close();
            printYellowGenericLn("### We re-close the FileInputStream, but note that, that one also throws IOException.");
        } catch (IOException e) {
            printRedGenericLn("%s", e);
        }

        printRainbowTitleLn("13. `Files` list and walk");
        printRainbowLn("==");
        printYellowGenericLn("### In the following sequence of examples we'll see how to list and now not to list files");
        Stream<Path> allFiles1;
        try {
            printOrangeGenericLn("### Stream<Path> allFiles1 = Files.list(Paths.get(\"/**/rocket*.txt\")); -> should fail!");
            printOrangeGenericLn("### It may throw an InvalidPathException which is a RuntimeException. This depends on your FileSystems");
            allFiles1 = Files.list(Paths.get("/**/rocket*.txt"));
        } catch (IOException e) {
            printYellowGenericLn("### It is also safer to assume that if something goes on reading, it will throw a IOException, instead of possibly the NoSuchFileException");
            printRedGenericLn("%s", e);
            try {
                allFiles1 = Files.list(Paths.get("/tmp"));
                printGreenGenericLn("These are the files with list: %s", allFiles1.collect(Collectors.toList()));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        // Cannot resolve method 'find(java.nio.file.Path)'
        // allFiles1 = Files.find(Paths.get("/tmp/rocket-info.txt"));
        try {
            allFiles1 = Files.find(Paths.get("/tmp/rocket-info.txt"), 0, (p, a)
                    -> p.endsWith("rocket-info.txt") && a.isRegularFile());
            printGreenGenericLn("These are the files with find: %s", allFiles1.collect(Collectors.toList()));
        } catch (IOException e) {
            printRedGenericLn("%s", e);
        }
        // Cannot resolve method 'walk(java.nio.file.Path, java.lang.String)'
        // allFiles1= Files.walk(Paths.get("/tmp/rocket-info.txt"), "test.txt");
        try {
            allFiles1 = Files.walk(Paths.get("/tmp/rocket-info.txt"), 0);
            printGreenGenericLn("These are the files with walk: %s", allFiles1.collect(Collectors.toList()));
        } catch (IOException e) {
            printRedGenericLn("%s", e);
        }

        printRainbowTitleLn("14. Reading sub-paths `Path.subpath`");
        printRainbowLn("==");
        printYellowGenericLn("### A few things to remember:");
        printYellowGenericLn("### 1. The root is never element 0");
        printYellowGenericLn("### 2. First index is inclusive, last index is exclusive (just like almost every index in Java");
        printYellowGenericLn("### 3. Individual paths do not start or end with path separator");
        var lunarPath = new File("/tmp/controller/lunar");
        var orbitPath = new File("/tmp/controller/orbit");
        var launcherPath = new File("/tmp/controller/launcher");
        lunarPath.mkdirs();
        orbitPath.mkdirs();
        launcherPath.mkdirs();
        var pathLunar = Paths.get("/tmp/controller/lunar");
        var pathOrbit = Paths.get("/tmp/controller/orbit");
        var pathLauncher = Paths.get("/tmp/controller/launcher");
        printOrangeGenericLn("A subpath 0 to 1 of %s is %s", pathLunar, pathLunar.subpath(0, 1));
        printOrangeGenericLn("A subpath 0 to 2 of %s is %s", pathLunar, pathLunar.subpath(0, 2));
        printOrangeGenericLn("Path 0 of %s is %s", pathLunar, pathLunar.getName(0));
        printOrangeGenericLn("Root of %s is %s", pathLunar, pathLunar.getRoot());
        printOrangeGenericLn("A subpath 0 to 3 of %s is %s", pathOrbit, pathOrbit.subpath(0, 3));
        printOrangeGenericLn("A subpath 1 to 3 of %s is %s", pathLauncher, pathLauncher.subpath(1, 3));

        printRainbowTitleLn("15. Prepared statement different types `BLOB` and `CLOB`.");
        printRainbowLn("==");
        printYellowGenericLn("### Multiple runs of the same query is better performed with `PreparedStatement`");
        printYellowGenericLn("### Performance can be hindered if only one query is run per `PreparedStatement`");
        try {
            Connection conn = DriverManager.
                    getConnection("jdbc:h2:mem:", "sa", "");
            printGreenGenericLn("Connection: %s / %s", conn.getMetaData().getDatabaseProductName(), conn.getCatalog());
            printGreenGenericLn("Current auto-commit setting: %s", conn.getAutoCommit());
            PreparedStatement preparedStatement = conn.prepareStatement("select 1 as value from dual");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                printOrangeGenericLn(resultSet.getString("value"));
                printOrangeGenericLn(resultSet.getString(1));
            }
            var resourceAsStream = Master2Dot2Runner.class.getResourceAsStream("/master.2.2.JPG");
            PreparedStatement createBlogs = conn.
                    prepareStatement("CREATE TABLE Blog (ID INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
                            "TEXT CLOB,\n" +
                            "IMAGE BLOB);");
            printGreenGenericLn(createBlogs);
            createBlogs.execute();
            Blob blob = conn.createBlob();
            blob.setBytes(1, resourceAsStream.readAllBytes());
            java.sql.Clob clob = conn.createClob();
            clob.setString(1, "This is a big big blog");
            PreparedStatement insertBlog = conn.
                    prepareStatement("INSERT INTO Blog(\n" +
                            "TEXT,\n" +
                            "IMAGE) VALUES (?,?)");
            insertBlog.setClob(1, clob);
            insertBlog.setBlob(2, blob);
            printGreenGenericLn(insertBlog);
            insertBlog.execute();
            PreparedStatement selectBlog = conn.prepareStatement("select ID, TEXT, IMAGE from Blog");
            ResultSet resultSet2 = selectBlog.executeQuery();
            while (resultSet2.next()) {
                printOrangeGenericLn(resultSet2.getString(1));
                printOrangeGenericLn(new String(resultSet2.getClob(2).getAsciiStream().readAllBytes()));
                byte[] bytes = resultSet2.getBlob(3).getBinaryStream().readAllBytes();
                try (FileOutputStream fos = new FileOutputStream("/tmp/master.2.2.JPG")) {
                    fos.write(bytes);
                }
                printOrangeGenericLn("Check /tmp/master.2.2.JPG. The contents of %s..., have been copied there!",
                        new String(bytes).substring(0, 10));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        printRainbowTitleLn("16. Non-deterministic nature of findAny.");
        printRainbowLn("==");
        printYellowGenericLn("### findAny of Java streams is non deterministic");
        printYellowGenericLn("### It may give the feeling that the cause of it are parallel streams");
        printYellowGenericLn("### We pick a list of the actors of Apollo 13");
        var actors = List.of("Tom Hanks", "Bill Paxton", "Kevin Bacon", "Gary Sinise");
        printBlueGenericLn("This is the list: %s", "var actors = List.of(\"Tom Hanks\", \"Bill Paxton\",\"Kevin Bacon\",\"Gary Sinise\");");
        printBlueGenericLn("We select one with findAny and a parallel stream:\n %s", "        var actorParallel = actors. parallelStream()\n" +
                "                .findAny().orElse(null);");
        var actorParallel = actors.parallelStream()
                .findAny().orElse(null);
        printOrangeGenericLn("We've found actor %s. Note that if you run this several times, you'll still get %s. However you would not be able to determine that before-hand right?", actorParallel, actorParallel);
        printBlueGenericLn("We select one with findAny and a sequential stream:\n %s", "        var actorParallel2 = actors.stream()\n" +
                "                .findAny().orElse(null);");
        var actorParallel2 = actors.stream()
                .findAny().orElse(null);
        printOrangeGenericLn("Now we get %s. Run again and you'll still get %s. However, this wasn't possible to determine was it?", actorParallel2, actorParallel2);

        printRainbowTitleLn("17. Loops and Labels");
        printRainbowLn("==");
        printYellowGenericLn("### Loops and Labels cannot be broken or continued for outside flow control statements such as while, do, for and if");
        printYellowGenericLn("### Break and continue alone do work, but only within a loop");
        var i = 0;
        SPACE:
        while (i++ < 2) {
            var j = 0;
            ORBIT:
            while (j++ < 10) {
                var k = 0;
                MOON:
                while (k++ < 10) {
                    ACCIDENT:
                    printRedGenericLn("This will never break");
                    if (k == 5) {
                        printOrangeGenericLn("We leave the countdown with i=%d, j=%d, k=%d", i, j, k);
                        DODO:
                        do {
                            printGreenGenericLn("The next text won't print");
                            if (true)
                                break DODO;
                            printGreenGenericLn("The next text won't print");
                        } while (false);
                        break ORBIT;
                        // Undefined label: 'ACCIDENT'
                        // break ACCIDENT;
                    }
                }
            }
        }

        printRainbowTitleLn("18. Overriding `CharSequence`");
        printRainbowLn("==");
        printYellowGenericLn("### How do we override a CharSequence for different classes?");
        printYellowGenericLn("### Here are some examples");
        class Moon {
            public <T extends CharSequence> Collection<String> translateData(Collection<T> list) {
                printBlueGenericLn("We now print the moon with -> public <T extends CharSequence> Collection<String> translateData(Collection<T> list)");
                return new ArrayList<>();
            }

            public <T extends String> Collection<String> translateData(List<T> list) {
                printBlueGenericLn("We now print the moon with -> public <T extends String> Collection<String> translateData(List<T> list)");
                return new ArrayList<>();
            }
        }
        class MoonBase extends Moon {
            public <T extends CharSequence> Collection<String> translateData(Collection<T> list) {
                printBlueGenericLn("We now print the moon-base with -> public <T extends CharSequence> Collection<String> translateData(Collection<T> list)");
                return super.translateData(list);
            }

            public <T extends String> Collection<String> translateData(List<T> list) {
                printBlueGenericLn("We now print the moon-base with -> public <T extends String> Collection<String> translateData(List<T> list)");
                return super.translateData(list);
            }
        }
        var moonBase = new MoonBase();
        // Cannot resolve method 'transform(java.util.ArrayList<java.lang.Long>)'
        // moonBase.transform(new ArrayList<Long>());
        moonBase.translateData(new ArrayList<>());
        moonBase.translateData((Collection)new Vector<>());
        printUnicornsLn(100);
    }
}
