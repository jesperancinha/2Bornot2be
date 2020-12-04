package org.jesperancinha.ocp11.mastery4dot3;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery4dot3.song.Song;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightMagentaGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedThrowableAndExit;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;

public class Mastery4Dot3Runner {
    private static boolean skipQuestions;

    public static void main(String[] args) {
        if (args.length > 0) {
            skipQuestions = "-skip".equals(args[0]);
        }
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.maxLineCharsGlobal = 200;
        printBlueGenericLn("==================== Master Module mastery-4-3 And Then India ====================");
        printBlueGenericLn("----> Run with VM command -ea or -enableassertions for a more accurate run");
        printBlueGenericLn("----> Run with -skip to skip questions");
        printBlueGenericLn("----> Note that this mastery need the prepare.sh script to be run first.");

        exercise1();

        printBrightCyanGenericLn("--- 2. Using `mapToObj`");
        printRainbowLn('=', 10);
        printGreenGenericLn("Case: Oracular Spectacular reached interesting top positions world-wide.");
        printGreenGenericLn("Let's have a look at the math behind it");
        var peakPositionsPerCountry = Map.of(
                "US", 38, "AUS", 6, "BEL", 10, "CAN", 24,
                "FRA", 22, "GER", 65, "IRL", 5, "NZ", 13,
                "SWI", 68, "UK", 8
        );
        printMagentaGenericLn("This is their peak register on the charts on the  16th November 2020");
        printMagentaGenericLn(peakPositionsPerCountry);
        printRainbowLn('-', 10);
        // <R> R collect(Supplier<R> supplier,
        // ObjIntConsumer<R> accumulator,
        // BiConsumer<R, R> combiner);
        final List<Integer> list01 = peakPositionsPerCountry.values().stream().mapToInt(i -> i)
                .collect(ArrayList::new, new ObjIntConsumer<ArrayList<Integer>>() {
                    @Override
                    public void accept(ArrayList<Integer> integers, int value) {
                        printMagentaGenericLn("When our stream is sequential, we can see things nicely, but performance goes away:");
                        printMagentaGenericLn("Adding value %d", value);
                        integers.add(value);
                    }
                }, ArrayList::addAll);
        printRainbowLn('-', 10);
        final List<Integer> list02 = peakPositionsPerCountry.values().stream().mapToInt(i -> i)
                .parallel()
                .collect(
                        ArrayList::new,
                        (integers, value) -> {
                            integers.add(value);
                            printBrightMagentaGeneric(value);
                        }, (integers, integers2) -> {
                            printMagentaGeneric("I'm reaching this now, because I'm a parallel stream!");
                            printMagentaGeneric(integers);
                            printMagentaGeneric(integers2);
                            integers.addAll(integers2);
                        });
        printRainbowLn('-', 10);
        printMagentaGenericLn("Sequential list result -> %s", list01);
        printMagentaGenericLn("Sequential list result -> %s", list02);
        printRainbowLn('-', 10);
        printMagentaGenericLn("If we want to calculate the average this way and with high performance, we can!");
        final double avg = peakPositionsPerCountry.values().stream().mapToInt(i -> i)
                .parallel()
                .collect(
                        () -> new DoubleAccumulator(Double::sum, 0),
                        new ObjIntConsumer<DoubleAccumulator>() {
                            @Override
                            public void accept(DoubleAccumulator atomicInteger, int value) {
                                atomicInteger.accumulate(value);
                            }
                        }, new BiConsumer<DoubleAccumulator, DoubleAccumulator>() {
                            @Override
                            public void accept(DoubleAccumulator doubleAccumulator, DoubleAccumulator doubleAccumulator2) {
                                doubleAccumulator.accumulate(doubleAccumulator2.doubleValue());
                            }
                        }).doubleValue() / peakPositionsPerCountry.values().size();

        printMagentaGenericLn("This is the result -> %f", avg);
        printRainbowLn('-', 10);
        printMagentaGenericLn("However, Number streams, already contain average methods. This is the reason why a collector doesn't make sense to have in a Number stream");
        printMagentaGenericLn("Oracle Spectacular reached an average peak of %f around the world", peakPositionsPerCountry.values().stream().collect(Collectors.averagingDouble(i->i)));
        printMagentaGenericLn("Oracle Spectacular reached an average peak of %f around the world", peakPositionsPerCountry.values().stream().collect(Collectors.averagingInt(i->i)));
        printMagentaGenericLn("Oracle Spectacular reached an average peak of %f around the world", peakPositionsPerCountry.values().stream().collect(Collectors.averagingLong(i->i)));
        printMagentaGenericLn("Oracle Spectacular reached an average peak of %f around the world", peakPositionsPerCountry.values().stream().mapToInt(i->i).mapToObj(i->i).collect(Collectors.averagingLong(i->i)));
        printMagentaGenericLn("Oracle Spectacular reached an average peak of %f around the world", peakPositionsPerCountry.values().stream().mapToInt(i->i).boxed().collect(Collectors.averagingLong(i->i)));
        printMagentaGenericLn("Oracle Spectacular reached an average peak of %f around the world", peakPositionsPerCountry.values().stream().mapToInt(i->i).average().getAsDouble());
        printMagentaGenericLn("Oracle Spectacular reached an average peak of %f around the world", peakPositionsPerCountry.values().stream().mapToInt(i->i).mapToDouble(i->i).average().getAsDouble());
        printMagentaGenericLn("Oracle Spectacular reached an average peak of %f around the world", peakPositionsPerCountry.values().stream().mapToInt(i->i).mapToLong(i->i).average().getAsDouble());
        printRainbowLn('-', 10);
        printMagentaGenericLn("Curiosity 1 (Forcing Doubles) ->  %f", DoubleStream.of(11.45, 12.43, 14.56)
            .mapToObj(i->i).collect(Collectors.averagingDouble(i->i)));
        printMagentaGenericLn("Curiosity 2 (Forcing Longs) ->  %f", DoubleStream.of(11.45, 12.43, 14.56)
            .mapToObj(i->i).collect(Collectors.averagingLong(Double::longValue)));
        printMagentaGenericLn("Curiosity 3 (Forcing Ints) ->  %f", DoubleStream.of(11.45, 12.43, 14.56)
            .mapToObj(i->i).collect(Collectors.averagingInt(Double::intValue)));
        printMagentaGenericLn("Curiosity 4 (no values) ->  %f", DoubleStream.of()
            .mapToObj(i->i).collect(Collectors.averagingInt(Double::intValue)));
        printMagentaGenericLn("Note that the double average is more accurate because Long and Int have round up the decimals to unit.");
        printRainbowLn('-', 10);
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Calculating average can be done in different ways.");
        printGreenGenericLn("2. All ways require the return value to double in the end unless we make our custom calculation.");
        printGreenGenericLn("3. Using collectors, the result in never an Optional and this is because that is the way collectors work.");
        printGreenGenericLn("4. Number streams do have collectors. We calculated avg using our own average implementation, but it will always be less efficient.");
        printGreenGenericLn("5. The collector of the Number streams are used to solve value accumulation issues. They are perfect for custom reduce operations.");
        printGreenGenericLn("6. The BiConsumer of a Number stream collector is called only during `parallel` stream operations. It is not called at all otherwise.");
        printGreenGenericLn("7. The `average` method of a Number stream is there to solve this problem. However, it returns an `OptionalDouble`. We then call getAsDouble to know the value.");
        moduleEnd();
    }

    private static void exercise1() {
        printBrightCyanGenericLn("--- 1. Indexes in a `ResultSet`");
        printRainbowLn('=', 10);
        printGreenGenericLn("Case: We are wondering what happened to MGMT and why we don't hear about them anymore.");
        printGreenGenericLn("On this first exercise we will investigate their triad of hits.");
        printGreenGenericLn("MGMT came into the Indie music scene in 2008 with their album Oracular Spectacular.");

        var songTimeToPretend =
                new Song("Time to pretend", "MGMT", LocalDate.of(2008, 3, 3));
        var songKids =
                new Song("Kids", "MGMT", LocalDate.of(2008, 10, 13));
        var songElectricFeel =
                new Song("Electric Feel", "MGMT", LocalDate.of(2008, 6, 23));

        var allSongs = List.of(songTimeToPretend, songKids, songElectricFeel);

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:", "sa", "");
        } catch (SQLException e) {
            printRedThrowableAndExit(e);
        }
        PreparedStatement preparedStatementCreate = null;
        try {
            assert connection != null;
            preparedStatementCreate = connection.prepareStatement("CREATE TABLE Song (" +
                    "   id INT AUTO_INCREMENT NOT NULL, \n" +
                    "   SONG VARCHAR(50) NOT NULL, \n" +
                    "   BAND VARCHAR(50) NOT NULL, \n" +
                    "   HITYEAR INT " +
                    ");");
        } catch (SQLException e) {
            printRedThrowableAndExit(e);
        }
        boolean executeCreation = false;
        try {
            assert preparedStatementCreate != null;
            executeCreation = preparedStatementCreate.execute();
        } catch (SQLException e) {
            printRedThrowableAndExit(e);
        }
        if (executeCreation) {
            printMagentaGeneric("Table Song is created!");
        }

        // It doesn't look like it, but this Connection is effectively final.
        Connection finalConnection = connection;
        allSongs.forEach(song -> {
            try {
                final PreparedStatement statement = finalConnection.prepareStatement("INSERT INTO Song (SONG, BAND, HITYEAR) VALUES(?,?,?);");
                statement.setString(1, song.getSong());
                statement.setString(2, song.getBand());
                statement.setLong(3, song.getHitLocalDate().getYear());
                if (statement.execute()) {
                    printMagentaGeneric("Inserted song %s", song);
                }
            } catch (SQLException e) {
                printRedThrowableAndExit(e);
            }

        });
        printRainbowLn('-', 10);
        try {
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT SONG, BAND, HITYEAR from SONG;");
            while (resultSet.next()) {
                final String song = resultSet.getString("SONG");
                final String song1 = resultSet.getString(1);
                final String band = resultSet.getString("BAND");
                final String band2 = resultSet.getString(2);
                final Array bandArray = resultSet.getArray("BAND");
                final Array bandArray2 = resultSet.getArray(2);
                final Long hitYear = resultSet.getLong("HITYEAR");
                final Long hitYearLong3 = resultSet.getLong(3);
                final Integer hitYearInt = resultSet.getInt("HITYEAR");
                final Integer hitYearInt3 = resultSet.getInt(3);
                final BigDecimal hitYearBigDecimal = resultSet.getBigDecimal("HITYEAR");
                final BigDecimal hitYearBigDecimal3 = resultSet.getBigDecimal(3);
                final Float hitYearFloat = resultSet.getFloat("HITYEAR");
                final Float hitYearFloat3 = resultSet.getFloat(3);
                final Array hitYearArray = resultSet.getArray("HITYEAR");
                final Array hitYearArray3 = resultSet.getArray(3);
                printMagentaGenericLn("resultSet.getString(\"SONG\"); -> %s", song);
                printMagentaGenericLn("resultSet.getString(1); -> %s", song1);
                printMagentaGenericLn("resultSet.getString(\"BAND\"); -> %s", band);
                printMagentaGenericLn("resultSet.getString(2); -> %s", band2);
                printMagentaGenericLn("resultSet.getArray(\"BAND\"); -> %s", bandArray);
                printMagentaGenericLn("resultSet.getArray(2);-> %s", bandArray2);
                printMagentaGenericLn("resultSet.getLong(\"HITYEAR\");-> %s", hitYear);
                printMagentaGenericLn("resultSet.getLong(3); -> %s", hitYearLong3);
                printMagentaGenericLn("resultSet.getInt(\"HITYEAR\");-> %s", hitYearInt);
                printMagentaGenericLn("resultSet.getInt(3);-> %s", hitYearInt3);
                printMagentaGenericLn("resultSet.getBigDecimal(\"HITYEAR\");-> %s", hitYearBigDecimal);
                printMagentaGenericLn("resultSet.getBigDecimal(3); -> %s", hitYearBigDecimal3);
                printMagentaGenericLn("resultSet.getFloat(\"HITYEAR\");-> %s", hitYearFloat);
                printMagentaGenericLn("resultSet.getFloat(3); -> %s", hitYearFloat3);
                printMagentaGenericLn("resultSet.getArray(\"HITYEAR\");-> %s", hitYearArray);
                printMagentaGenericLn("resultSet.getArray(3); -> %s", hitYearArray3);
                printRainbowLn("----------");
            }
        } catch (SQLException e) {
            printRedThrowableAndExit(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            printRedThrowableAndExit(e);
        }
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. In Result sets, indexes are 1 based");
        printGreenGenericLn("2. Conversions happen automatically if they match");
        printGreenGenericLn("3. An Int if convertible to Integer, Long, Float, Double and Big Integer");
        printGreenGenericLn("4. We can even get a special java.sql.Array type, which  returns the data in an array form valid for all types");
    }

    private static void moduleEnd() {
        printUnicornsLn(100);
        printGreenGenericLn("Hope you enjoyed this mastery into Java 11 with some Indie/Pop flavor to it.");
        printGreenGenericLn("Please keep coming back as I'll be creating more mastery modules.");
        printGreenGenericLn("Thank you!");
        printUnicornsLn(100);
    }
}
