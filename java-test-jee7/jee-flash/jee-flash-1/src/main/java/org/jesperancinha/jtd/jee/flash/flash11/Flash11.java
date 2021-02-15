package org.jesperancinha.jtd.jee.flash.flash11;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;
import static org.jesperancinha.console.consolerizer.ConsolerizerInteractions.performQuestion;

public class Flash11 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Flash 11 - How to make composite keys");
        setupFastDefaultWideTitleSpread();
        final String question = "In order to use @IdClass, @Embeddable and @EmbeddedId, we should know where should they apply. Please describe in map form, where can these be applied";

        int maxFails = 5;

        final var correctAnswers = Map.of(
                "@IdClass", Collections.singletonList("TYPE"),
                "@Embeddable", Collections.singletonList("TYPE"),
                "@EmbeddableId", Arrays.asList("METHOD", "FIELD")
        );

        if (!Arrays.asList(args).contains("-d11")) {
            performQuestion(question, maxFails, correctAnswers);
        }

        GREEN.printGenericLn("More reading");

        YELLOW.printGenericLn("from:\nhttps://dzone.com/articles/resource-local-vs-jta-transaction-types-and-payara");
        MAGENTA.printGenericLn("1. JTA - Java Transaction Architecture. Example:");
        BLUE.printGenericLn("{        Context ctx = new InitialContext();\n" +
                "        UserTransaction utx =\n" +
                "                (UserTransaction) ctx.lookup(\"java:comp/UserTransaction\");\n" +
                "        utx.begin();\n" +
                "        entityManager.merge(concert);\n" +
                "        utx.commit();\n        }");
        MAGENTA.printGenericLn("And nother example:");
        BLUE.printGenericLn("@TransactionAttribute(TransactionAttributeType.REQUIRED)\n" +
                "public void createConcertAndThenNot(Concert concert) throws Exception {\n" +
                "    entityManager.persist(concert);\n}\n");
        MAGENTA.printGenericLn("2. RESOURCE_LOCAL - Example:");
        BLUE.printGenericLn("{        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(\"secondary\");\n" +
                "        final EntityManager entityManager = entityManagerFactory.createEntityManager();\n" +
                "        final Concert concert1 = entityManager.find(Concert.class, concert.getUuid());\n" +
                "        entityManager.getTransaction().begin();\n" +
                "        entityManager.merge(concert1);\n" +
                "        entityManager.getTransaction().commit();\n        }\n");
    }
}