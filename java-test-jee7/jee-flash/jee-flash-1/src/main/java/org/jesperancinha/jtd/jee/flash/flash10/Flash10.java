package org.jesperancinha.jtd.jee.flash.flash10;

import java.util.Arrays;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;
import static org.jesperancinha.console.consolerizer.ConsolerizerInteractions.performQuestion;

public class Flash10 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Flash 10 - Persistence management types");
        setupFastDefaultWideTitleSpread();
        final String question = "In a persistence-unit, we can configure a transaction-type. Which are the most known types?";

        int maxFails = 1;
        final var correctAnswers = Arrays.asList("JTA", "RESOURCE_LOCAL");

        if (!Arrays.asList(args).contains("-d10")) {
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