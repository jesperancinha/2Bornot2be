package org.jesperancinha.java11.db.driver;

import java.sql.DriverManager;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

public class DbDriver {
    public static void main(String[] args) {
        try {
            final var conn = DriverManager.
                    getConnection("jdbc:h2:mem:", "sa", "");
            MAGENTA.printGenericLn("Connection: %s / %s\n", conn.getMetaData().getDatabaseProductName(), conn.getCatalog());
            MAGENTA.printGenericLn("Current auto-commit setting: %s\n", conn.getAutoCommit());
            conn.close();
        } catch (Exception e) {
            RED.printThrowableAndExit(e);
        }
    }
}
