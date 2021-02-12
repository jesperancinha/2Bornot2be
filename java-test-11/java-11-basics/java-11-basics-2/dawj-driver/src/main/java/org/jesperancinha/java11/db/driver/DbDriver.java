package org.jesperancinha.java11.db.driver;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED;

public class DbDriver {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.
                    getConnection("jdbc:h2:mem:", "sa", "");
            System.out.printf("Connection: %s / %s\n", conn.getMetaData().getDatabaseProductName(), conn.getCatalog());
            System.out.printf("Current auto-commit setting: %s\n", conn.getAutoCommit());
            conn.close();
        } catch (Exception e) {
            RED.printThrowableAndExit(e);
        }
    }
}
