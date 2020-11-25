package org.jesperancinha.ocp11.mastery4dot1;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery4dot1.concert.Artist;
import org.jesperancinha.ocp11.mastery4dot1.concert.Venue;
import org.jesperancinha.ocp11.mastery4dot1.levels.BeginnerException;
import org.jesperancinha.ocp11.mastery4dot1.levels.ExpertException;
import org.jesperancinha.ocp11.mastery4dot1.levels.JuniorException;
import org.jesperancinha.ocp11.mastery4dot1.levels.MediorException;
import org.jesperancinha.ocp11.mastery4dot1.levels.RookieException;
import org.jesperancinha.ocp11.mastery4dot1.levels.SeniorException;
import org.jesperancinha.ocp11.mastery4dot1.levels.SuperSeniorException;
import org.jesperancinha.ocp11.mastery4dot1.riots.RaidException;
import org.jesperancinha.ocp11.mastery4dot1.riots.ResponseException;
import org.jesperancinha.ocp11.mastery4dot1.society.TheGreatSocietyAdapter;
import org.jesperancinha.ocp11.mastery4dot1.states.LBJGovernment;
import org.jesperancinha.ocp11.mastery4dot1.supreme.Case;
import org.jesperancinha.ocp11.mastery4dot1.supreme.SupremeCourt;
import org.jesperancinha.ocp11.mastery4dot1.supreme.SupremeCourtArchive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedThrowableAndExit;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;

public class Mastery4Dot1Runner {
    private static boolean skipQuestions;

    public static void main(String[] args) {
        if (args.length > 0) {
            skipQuestions = "-skip".equals(args[0]);
        }
        Consolerizer.typingWaitGlobal = 0;
        printBlueGenericLn("==================== Master Module mastery-4-1 ====================");
        printBlueGenericLn("Note that this mastery need the prepare.sh script to be run first.");
        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();
        exercise7();
        exercise8();
        exercise9();
        exercise10();
        exercise11();
        exercise12();
        exercise13();

        printUnicornsLn(100);
        printGreenGenericLn("Hope you enjoyed this mastery into Java 11 with the united states of america's history flavour to it.");
        printGreenGenericLn("Please keep coming back as I'll be creating more mastery modules.");
        printGreenGenericLn("Thank you!");
        printUnicornsLn(100);
    }

    private static void exercise13() {
        printBrightCyanGenericLn("--- 13. References operation in shadowing static interface members with class members");
        printRainbowLn("==");
        printGreenGenericLn("Case: You don't want to miss the time Joan Baez is going to perform");
        printGreenGenericLn("Your ticket has two dates and times on it, but which one is the one from your concert?");
        printGreenGenericLn("And what is the other date about?");
        var artist = new Artist("Joan Baez",
                LocalDateTime.of(1968, 8, 16, 3,0),
                LocalDateTime.of(1968, 8, 16,  3,45)
        );
        printMagentaGenericLn("In your ticket it says: %s", artist);
        printMagentaGenericLn("And the other date is start: %s", ((Venue)artist).start);
        printMagentaGenericLn("And the other date is end: %s", ((Venue)artist).end);
        printMagentaGenericLn("Right! This is actually the time Woodstock '69 in %s starts and ends!", artist.location);
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Members in interfaces are implicitly static");
        printGreenGenericLn("2. Static members can be shadowed by instance members");
        printGreenGenericLn("3. We can, however, by upcasting access them anyways");
        printGreenGenericLn("4. If we don't upcast, in our specific case, the compiler would interpret that an attempt to access instance members");
        printGreenGenericLn("5. Since instance members are package protected, and we are on a different package, this results in a compilation failure");
    }

    private static void exercise12() {
        printBrightCyanGenericLn("--- 12. All possible `switch`");
        printRainbowLn("==");
        printGreenGenericLn("Case: It is the 15th of August 1969 and you just went to have fun with your pals.");
        printGreenGenericLn("We'll look at the listings to see wha't happening for today and tomorrow.");
        printBlueGenericLn("Switch case for day 15 and day 16");
        var testDay = 15;
        printMagentaGenericLn("On day %d these bands:\n%s\nwill play!", testDay, getArtistsPerDay(testDay));
        testDay = 16;
        printMagentaGenericLn("On day %d these bands:\n%s\nwill play!", testDay, getArtistsPerDay(testDay));
        printBlueGenericLn("Switch case for Joan Baez");
        var artist = "Joan Baez";
        printMagentaGenericLn("%s is playing these songs:\n%s", artist, getSongsByArtist(artist));
        printBlueGenericLn("Switch case for who played 5 songs only");
        var songs = (byte) 5;
        printMagentaGenericLn("These artists are playing %d songs: %s", songs, getArtistsPerSungSongs(songs));
        printBlueGenericLn("Switch case for artists who played for 45 minutes = 2700 seconds");
        var duration = (short) 2700;
        printMagentaGenericLn("These artists played for %d seconds:\n%s", duration, getArtitstByDuration(duration));
        var character = 'C';
        printBlueGenericLn("Switch case for artists who start with a C.");
        printMagentaGenericLn("These artists played for %s seconds:\n%s", character, getArtitstByFirstCharacter(character));
        printGreenGenericLn("Take-aways");
        printGreenGenericLn("1. for switch case, the allowed primitive types are int, short, char and byte");
        printGreenGenericLn("2. for switch case, the allowed boxing types are Integer, Short, Character and Byte");
        printGreenGenericLn("3. extra objects can be of type String of enum");
        printGreenGenericLn("4. cases must be declared with constants");
        printGreenGenericLn("5. default isn't mandatory but there can only be one");
    }

    private static List<String> getArtitstByFirstCharacter(char character) {
        switch (character) {
            case 'S':
                return List.of("Swami Satchidananda", "Sweetwater", "Santana", "Sly & the Family Stone", "Sha Na Na");
            case 'C':
                return List.of("Country Joe McDonald", "Canned Heat", "Creedence Clearwater Revival", "Country Joe and the Fish", "Crosby, Stills, Nash & Young");
        }
        return List.of();
    }

    private static List<String> getArtitstByDuration(short duration) {
        switch (duration) {
            case 2700:
                return List.of("Sweetwater", "Tim Hardin", "Ravi Shankar", "Joan Baez", "Quill", "Santana", "Keef Hartley Band", "");
            case 600:
                return List.of("Swami Satchidananda");
            default:
                return List.of();
        }
    }

    private static List<String> getArtistsPerSungSongs(byte songs) {
        switch (songs) {
            case 5:
                return List.of("John Sebastian", "Keef Hartley Band", "Grateful Dead");
            case 6:
                return List.of("The Incredible String Band", "Canned Heat", "Ten Years After");
        }
        return List.of();
    }

    private static List<String> getSongsByArtist(String artist) {
        switch (artist) {
            case "Joan Baez":
                return List.of("Oh Happy Day",
                        "The Last Thing on My Mind", "I Shall Be Released",
                        "Story about how federal marshals took husband David Harris into custody",
                        "Joe Hill", "Sweet Sir Galahad", "Hickory Wind",
                        "Drug Store Truck Driving Man (duet with Jeffrey Shurtleff)", "One Day at a Time",
                        "Take Me Back to the Sweet Sunny South", "Warm and Tender Love",
                        "Swing Low, Sweet Chariot", "We Shall Overcome");
            case "Quill":
                return List.of("They Live the Life", "That's How I Eat", "Driftin'", "Waiting for You");
        }
        return List.of();
    }

    private static List<String> getArtistsPerDay(int testDay) {
        switch (testDay) {
            case 15:
                return List.of("Richie Havens", "Swami Satchidananda", "Sweetwater", "Bert Sommer", "Tim Hardin", "Ravi Shankar");
            case 16:
                return List.of("Ravi Shankar", "Melanie", "Arlo Guthrie", "Joan Baez", "Quill", "Country Joe McDonald", "Santana", "John Sebastian", "Keef Hartley Band", "The Incredible String Band", "Canned Heat", "Mountain", "Grateful Dead", "Creedence Clearwater Revival");
            default:
                return List.of();
        }
    }

    private static void exercise11() {
        printBrightCyanGenericLn("--- 11. Using `private` in inner classes");
        printRainbowLn("==");
        printGreenGenericLn("Case: In 1957, Frank Kameny's was fired from the United States Army.");
        printGreenGenericLn("The case seemed to come from institutionalized homophobia. In fact he was discharged for being found to be a homosexual");
        printGreenGenericLn("In those years, that was, unfortunately a reason to be used against someone to keep them out of the workforce.");
        printGreenGenericLn("That started a 4 year case in the Supreme Court of the United States of America.");
        printGreenGenericLn("Unfortunately, it all came to close in 1961, where Kameny was denied certiorari.");
        printGreenGenericLn("This means that his case was denied the right to be reviewed and Kameny lost his case.");
        printGreenGenericLn("This case was closed back then");
        printGreenGenericLn("Based on this, we will now see how can two classes with exactly the same code, can make properties accessible and non-accessible.");
        var supremeCourtSession = new SupremeCourt("from:https://en.wikipedia.org/wiki/1960s_in_LGBT_rights\nThe United States Supreme Court denies certiorari to Frank Kameny's petition to review the legality of his firing by the United States Army's Map Service in 1957, bringing his four-year legal battle to a close");
        printBlueGenericLn("Court Session is opened:");
        printMagentaGenericLn(supremeCourtSession.getCourtCaseDescription());
        var supremeCourtSessionArchived = new SupremeCourtArchive(supremeCourtSession.getCourtCaseDescription());
        printBlueGenericLn("Court Session is closed:");
        printMagentaGenericLn(supremeCourtSessionArchived.getCourtCaseDescription());
        printBlueGenericLn("If we check via reflection:");
        try {
            Field courtCaseField = supremeCourtSessionArchived.getClass().getDeclaredField("courtCase");
            courtCaseField.setAccessible(true);
            Case courtCase = (Case) courtCaseField.get(supremeCourtSessionArchived);
            Field courtCaseStringField = courtCase.getClass().getDeclaredField("courtCase");
            courtCaseStringField.setAccessible(true);
            String courtCaseString = (String) courtCaseStringField.get(courtCase);
            printMagentaGenericLn(courtCaseString);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            printRedThrowableAndExit(e);
        }
        printBlueGenericLn("This means that although the courtCase is private now, it is still registered for the future.");
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. private members can be always access from the outer and inner classes alike");
        printGreenGenericLn("2. the scope, however, changes when the class is taken out");
        printGreenGenericLn("3. although the code stays the same, the scope changes");
        printGreenGenericLn("4. moving classes away from their inner scope can also be used to change scope without changing a single line of code.");
    }

    private static void exercise10() {
        printBrightCyanGenericLn("--- 10. Using non-modularized jars in modularized jars");
        printRainbowLn("==");
        printGreenGenericLn("Please check module mastery-4-1-modularity to continue.");
    }

    private static void exercise9() {
        printBrightCyanGenericLn("--- 9. DOS attacks in Java");
        printRainbowLn("==");
        printGreenGenericLn("Case: It's 1967, you work for the Pentagon and you come across some papers about the USA involvement in the Vietnam war.");
        printGreenGenericLn("You have to keep these papers safe, so you decide to make a copy of these files to your safe.");
        printGreenGenericLn("We'll this in some safe way.");
        printGreenGenericLn("We also know that files bigger than 2000 characters are fake.");
        printGreenGenericLn("We still copy until its 2000 characters.");
        printGreenGenericLn("We will also process maximum 200 files.");
        printGreenGenericLn("We will validate evey file and check for pattern /tmp/pentagon to avoid path traversal.");
        final String[] fileNames = {"/tmp/pentagon_paper1.txt", "/tmp/pentagon_paper2.txt", "/tmp/pentagon_paper3.txt"};
        printMagentaGenericLn("Check your /tmp/tmp folder for the results!");
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Guideline 1-1 / DOS-1: Beware of activities that may use disproportionate resources");
        printGreenGenericLn("2. Guideline 1-2 / DOS-2: Release resources in all cases");
        printGreenGenericLn("3. Guideline 1-3 / DOS-3: Resource limit checks should not suffer from integer overflow");
        printGreenGenericLn("4. Guideline 1-4 / DOS-4: Implement Robust Error/Exceptions handling for services");
        processFilesToMainServer(fileNames);
    }

    private static void processFilesToMainServer(String[] fileNames) {
        try {
            int fileCount = 100;
            for (String file : fileNames) {
                fileCount--;
                if (fileCount < 0) {
                    break;
                }
                if (file.startsWith("/tmp/pentagon")) {
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/tmp/" + file))) {
                        int i = 0;
                        int result;
                        do {
                            char[] chars = new char[1000 * (i + 1)];
                            result = bufferedReader.read(chars, i * 1000, 1000);
                            bufferedWriter.write(chars, i * 1000, 1000);
                        } while (result > -1 && ++i <= 1);
                    } catch (FileNotFoundException e) {
                        printRedGenericLn("File was not found!");
                        printRedThrowableAndExit(e);
                    } catch (IOException e) {
                        printRedGenericLn("An error occurred!");
                        printRedThrowableAndExit(e);
                    }
                }
            }
        } catch (Throwable e) {
            printRedThrowableAndExit(e);
        }
    }

    private static void exercise8() {
        printBrightCyanGenericLn("--- 8. Loading drivers in JDBC 4.0");
        printRainbowLn("==");
        printGreenGenericLn("Case: We need to record the different missions that took place in the Vietnam War.");
        printGreenGenericLn("The Vietnam war is a period that lasted between 1887 and 1975.");
        printGreenGenericLn("The US had a prominent role in this role which escalated very fast between 1965 and 1968.");
        printGreenGenericLn("During period, Operation Rolling Thunder took place.");
        printGreenGenericLn("From: https://en.wikipedia.org/wiki/Operation_Rolling_Thunder:");
        printGreenGenericLn("Operation Rolling Thunder was the title of a gradual and sustained aerial bombardment campaign conducted by the United States (U.S.) 2nd Air Division (later Seventh Air Force), U.S. Navy, and Republic of Vietnam Air Force (RVNAF) against the Democratic Republic of Vietnam (North Vietnam) from 2 March 1965 until 2 November 1968, during the Vietnam War.");
        printGreenGenericLn("Let's put this in our database. We will use an H2 database");
        try {
            Properties p = new Properties();
            p.setProperty("user", "sa");
            p.setProperty("password", "");
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:", p);
            printMagentaGenericLn("Connection: %s / %s", conn.getMetaData().getDatabaseProductName(), conn.getCatalog());
            printMagentaGenericLn("Current auto-commit setting: %s", conn.getAutoCommit());
            printMagentaGenericLn("We can configure this because our dependency com.h2database:h2:1.4.200 contains:");
            printMagentaGenericLn("1. file java.sql.Driver in /META-INF/services/java.sql.Driver");
            printMagentaGenericLn("2. this file contains: org.h2.Driver");
            printMagentaGenericLn("This way, the runtime knows which driver to use.");
            PreparedStatement statement = conn.prepareStatement(
                    "CREATE TABLE Operations(ID IDENTITY AUTO_INCREMENT NOT NULL, DESCRIPTION VARCHAR(1000), SOURCE VARCHAR(50), YEAR INT);");
            statement.executeUpdate();
            statement = conn.prepareStatement("INSERT INTO Operations(DESCRIPTION,SOURCE, YEAR) VALUES ( ?,?,? );");
            statement.setString(1, "Operation Rolling Thunder was the title of a gradual and sustained aerial bombardment campaign conducted by the United States (U.S.) 2nd Air Division (later Seventh Air Force), U.S. Navy, and Republic of Vietnam Air Force (RVNAF) against the Democratic Republic of Vietnam (North Vietnam) from 2 March 1965 until 2 November 1968, during the Vietnam War.");
            statement.setString(2, "Wikipedia");
            statement.setString(3, "1965");
            statement.execute();
            statement = conn.prepareStatement("SELECT * FROM OPERATIONS;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                printMagentaGenericLn("The result is %s", resultSet.getString(1));
                printMagentaGenericLn("The result is %s", resultSet.getString(2));
                printMagentaGenericLn("The result is %s", resultSet.getString(3));
                printMagentaGenericLn("The result is %s", resultSet.getString(4));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. In JDBC4.0, available in Java 11, we don't need to load the driver.");
        printGreenGenericLn("2. As file java.sql.Driver exists in /META-INF/services of that library, the driver is automatically loaded.");
    }

    private static void exercise7() {
        printBrightCyanGenericLn("--- 7. Calculating averages with `collector`'s or with Number typed streams");
        printRainbowLn("==");
        printGreenGenericLn("Case: We will count the average count of electoral votes per state in the results of the 1968th USA presidential election.");
        final int[] votes = {3, 5, 40, 6, 3, 14, 4, 26, 13, 9, 7, 9, 12, 4, 5, 3, 4, 17, 4, 12, 4, 26, 8, 6, 8, 4, 11, 4, 3, 12, 12, 3};
        var sum1FromIntStream = Arrays.stream(votes).sum();
        var sum1FromObjStream = Arrays.stream(votes).mapToObj(i -> i).reduce(0, (a, b) -> a + b);
        var sum1FromBoxedStrem = Arrays.stream(votes).boxed().reduce(0, Integer::sum);
        printMagentaGenericLn("The sum of electoral votes for %s in 1968 was %d (via IntStream)", "Richard Nixon", sum1FromIntStream);
        printMagentaGenericLn("The sum of electoral votes for %s in 1968 was %d (via ObjStream)", "Richard Nixon", sum1FromObjStream);
        printMagentaGenericLn("The sum of electoral votes for %s in 1968 was %d (via BoxedStream)", "Richard Nixon", sum1FromBoxedStrem);
        var avg1FromIntStream = Arrays.stream(votes).average().getAsDouble();
        var avg1FromBoxedStreamDouble = Arrays.stream(votes).boxed().collect(Collectors.averagingDouble(i -> i));
        var avg1FromBoxedStreamInt = Arrays.stream(votes).boxed().collect(Collectors.averagingInt(i -> i));
        var avg1FromBoxedStreamLong = Arrays.stream(votes).boxed().collect(Collectors.averagingLong(i -> i));
        printMagentaGenericLn("So the electoral vote average for Richard Nixon was %f (via IntStream)", avg1FromIntStream);
        printMagentaGenericLn("So the electoral vote average for Richard Nixon was %f (via averagingDouble)", avg1FromBoxedStreamDouble);
        printMagentaGenericLn("So the electoral vote average for Richard Nixon was %f (via averagingInt)", avg1FromBoxedStreamInt);
        printMagentaGenericLn("So the electoral vote average for Richard Nixon was %f (via averagingLong)", avg1FromBoxedStreamLong);
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. All average calculation using streams result in a double result");
        printGreenGenericLn("2. There are at least two ways of doing this. One via collectors and the other via the average method of a Number Stream");
    }

    private static void exercise6() {
        printBrightCyanGenericLn("--- 6. Java Inheritance of state");
        printRainbowLn("==");
        printGreenGenericLn("Case: After JFK's assassination, LBJ inherited the bill of rights which JFK had fought for, for so long.");
        printGreenGenericLn("This was the time to make a move, and make a move LBJ did!");
        printGreenGenericLn("Marylin Monroe, didn't sing Happy B'Day to LBJ though.");
        var lbjGovernment = new LBJGovernment();
        printMagentaGenericLn("Work to do:");
        printMagentaGenericLn("Civil Rights Bill passed: %s", lbjGovernment.civilRightsBill);
        printMagentaGenericLn("Happy birthday passed: %s", lbjGovernment.bDay);
        printMagentaGenericLn("But wait! This is not an instance member!: %s", LBJGovernment.bDay);
        printMagentaGenericLn("So no `Happy Birthday Mr. President`for LBJ");
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Since we cannot have a subclass of multiple classes, only interfaces, then there is no multiple inheritance of state in Java");
    }

    private static void exercise5() {
        printBrightCyanGenericLn("--- 5. Generics separation between `<T>` and `T`");
        printRainbowLn("==");
        printGreenGenericLn("Case: Lyndon B. Johnson envisioned `The Great Society plan` in 1963.");
        printGreenGenericLn("This led through the years to the civil rights act of 1964 and 1965.");
        printGreenGenericLn("We can make a few sentences with this:");
        var theGreatSocietyString = new TheGreatSocietyAdapter<String>();
        try {
            final String theGreatSociety = theGreatSocietyString.printSocietyAdapterMethod(1963, 1);
        } catch (ClassCastException e) {
            printRedGenericLn("This happens because we specified that the `printSocietyAdapterMethod` would return `String` -> %s", e);
            printRedGenericLn("However we also generically specify that if input parameters are numbers, then it should return a `Double` number.");
            printRedGenericLn("This is why it fail this way. Let's make it good now.");
        }
        printMagentaGenericLn(theGreatSocietyString.printSocietyAdapterMethod("The civil liberties act was signed off by LBJ in ", 1963));
        var theGreatSocietyDouble = new TheGreatSocietyAdapter<Double>();
        printMagentaGenericLn("The Great Society term was coined in %d which led to the creation of the Civil Rights act of %f", 1964, theGreatSocietyDouble.printSocietyAdapterMethod(1963, 1));
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. We can specify a generic type for one specify class before runtime or during runtime with anonymous classes");
        printGreenGenericLn("2. We can also, regardless of the class generic type, specify the input params of each individual method of an instance object during runtime");
        printGreenGenericLn("3. We can, in the same way specify the return parameters");
    }

    private static void exercise4() {
        printBrightCyanGenericLn("--- 4. Last `Exception` to execute before exiting program abruptly");
        printRainbowLn("==");
        printGreenGenericLn("Case: It is 1969, June 28th and you went downtown NY to the famous `The Stonewall Inn`");
        printGreenGenericLn("It was a nice cosy night and now its early morning and all of the sudden the police charges in!");
        printGreenGenericLn("You are now facing the beginnings of what later became known as the Stonewall riots");

        try {
            try {
                printMagentaGenericLn("Patrons are having after hours fun!");
                throw new RaidException();
            } finally {
                try {
                    throw new ResponseException();
                } catch (ResponseException e) {
                    printRedGenericLn("This should be first exception: %s", e);
                    printRedGenericLn("If our story had ended here, the raid would have never happened.");
                    printRedGenericLn("In other words, System.exit(1), would have not allowed to see the output of RaidException.");
                    // System.exit(1);
                }
            }
        } catch (RaidException e) {
            printRedGenericLn("Notice when this exception occurs: %s", e);
        } finally {
            printRedGenericLn("You see this here, but if you did a System.exit(1) in the previous location, you wouldn't see this message");
        }
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Although finally always occurs in a try catch, the exception doesn't do anything yet although it has been thrown, if no catch is declared");
        printGreenGenericLn("2. Further process that block the thread from continuing will prevent this exception to affect anything at all.");
    }

    private static void exercise3() {
        printBrightCyanGenericLn("--- 3. JLS evaluation order in multiple operands");
        printRainbowLn("==");
        printGreenGenericLn("https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html");
        printGreenGenericLn("Case: We have the initials LBJ and we want to know how many years was he/she president.");
        printGreenGenericLn("We don't know anything about them. Just the initials.");
        printGreenGenericLn("We have a map from initials to president name.");
        printGreenGenericLn("Another from president name to year.");
        printGreenGenericLn("Another from year to president number.");
        printGreenGenericLn("And finally and array from president number to how many years.");
        printGreenGenericLn("Can we do this in one go?");

        var mapPresidentName = new HashMap<String, String>() {{
            put("LBJ", "Lyndon B. Johnson");
        }};
        var mapNameToYear = new HashMap<String, Integer>() {{
            put("Lyndon B. Johnson", 1963);
        }};
        var mapYearToNumber = new HashMap<Integer, Integer>() {{
            put(1963, 37);
        }};
        var array = new Integer[45];
        var yearsInPower = 2;
        printRedGenericLn("We seem to have found a mistake. It wasn't %d years. That's for sure!", yearsInPower);
        var presidentName = "JFK";
        presidentSearch(presidentName, presidentName, presidentName = mapPresidentName.get("LBJ"));
        final int years = array[mapYearToNumber.get(mapNameToYear.get(mapPresidentName.get("LBJ"))) - 1] = yearsInPower = 3;
        printMagentaGenericLn("I guess our calculation is correct. They were %d years!", years);
        printMagentaGenericLn("An now it is corrected also in our data structures: %d years!", yearsInPower);
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Expression evaluation can be seriously complicated");
        printGreenGenericLn("2. Most counter intuitive rule might be that the left operand is evaluated first.");
        printGreenGenericLn("3. All operands have to be evaluated");
        printGreenGenericLn("4. Read https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html for more details±!");
    }

    private static void presidentSearch(String presidentName, String presidentName1, String lbj) {
        printBrightCyanGenericLn("We though it was %s, but then it wasn't %s and instead it was %s", presidentName, presidentName1, lbj);
    }

    private static void exercise2() {
        printBrightCyanGenericLn("--- 2. What is the output of `String` for it's 3 different kind of values: `null`, \"\" and \"Something\"");
        printRainbowLn("==");
        printGreenGenericLn("Case: Three students are making resets: Katie, Chloe and Susan");
        printBlueGenericLn("Teacher: In what year was JFK assigned to the ONI field office at Headquarters");
        final String katieResponse = null;
        printMagentaGenericLn("Katie: Hmmmm.... " + katieResponse);
        printBlueGenericLn("T: That is not correct. Chloe?");
        final var chloeResponse = "";
        printMagentaGenericLn("Chloe: I don't know, maybe, %s", chloeResponse);
        printBlueGenericLn("T: You also don't know? How about you Susan?");
        final Object susanResponse = "January 1942";
        printMagentaGenericLn("Susan: Of course I do! It was in %s", susanResponse);

        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. An empty string does not generate output");
        printGreenGenericLn("2. A null string generates `null` as output");
        printGreenGenericLn("3. A string with a value, generates that value as output");
    }

    private static void exercise1() {
        printBrightCyanGenericLn("--- 1. `Exception` `catch` order");
        printRainbowLn("==");
        printGreenGenericLn("Case: We have just made a test about the history of the United States of America.");
        printGreenGenericLn("You are applying for a United States residency and nationality.");
        printGreenGenericLn("You will be qualified in 6 levels in lowest to highest order:");
        printGreenGenericLn("rookie, beginner, junior, medior, expert or senior");
        final var scanner = new Scanner(System.in);
        try {
            question(scanner, "In what year was president JFK born?", "1917", new RookieException());
            question(scanner, "JFK was which president of the United States of America?", "35", new BeginnerException());
            question(scanner, "How many years was JFK in power?", "3", new JuniorException());
            question(scanner, "In what year did JFK enrolled in Harvard University?", "1936", new MediorException());
            question(scanner, "In what year did JFK write his senior thesis on " +
                    "how Britain was in a considerable weak position against the germans in WWII?", "1939", new ExpertException());
            question(scanner, "When did JFK graduated?", "1940", new SeniorException());
            question(scanner, "How many copies did `Why England Slept` sold?", "80000", new SuperSeniorException());
        } catch (SuperSeniorException e) {
            printMagentaGenericLn("You are a Super Senior!");
        } catch (SeniorException e) {
            printMagentaGenericLn("You are a Senior!");
        } catch (ExpertException e) {
            printMagentaGenericLn("You are a Expert!");
        } catch (MediorException e) {
            printMagentaGenericLn("You are a Medior!");
        } catch (JuniorException e) {
            printMagentaGenericLn("You are a Junior!");
        } catch (BeginnerException e) {
            printMagentaGenericLn("You are a Beginner!");
        } catch (RookieException e) {
            printMagentaGenericLn("You are a Rookie!");
        } catch (Exception e) {
            printRedThrowableAndExit(e);
        }
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. In a try with multiple catches, the order is more specific to more generic");
    }

    private static void question(Scanner scanner, String s, String s2, RookieException e) throws RookieException {
        printBrightCyanGenericLn(s);
        String a7;
        if (skipQuestions) {
            a7 = s2;
            printGreenGenericLn(a7);
        } else {
            a7 = scanner.nextLine();
        }
        if (!a7.equals(s2)) {
            throw e;
        }
    }
}
