package org.jesperancinha.jtd.jee.flash.flash2;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;

public class Flash2 {
    public static void main(String[] args) {
        setupFastDefaultWideTitleSpread();
        BLUE.printGenericTitleLn("Crum2 - EJB Business tier");

        YELLOW.printGenericLn("from:");
        YELLOW.printGenericLn("https://docs.oracle.com/javaee/7/tutorial/ejb-intro001.htm#GIPMB");
        YELLOW.printGenericLn("https://www.appservgrid.com/documentation111/docs/fmw12c1211documentation/web.1211/e24972/understanding.htm");
        YELLOW.printGenericLn("https://access.redhat.com/documentation/en-us/jboss_enterprise_application_platform/6.3/html/development_guide/implementing_a_custom_load_balancing_policy_for_ejb_calls");
        YELLOW.printGenericLn("https://docs.oracle.com/cd/E18930_01/html/821-2431/abeea.html");
        YELLOW.printGenericLn("https://docs.oracle.com/cd/E16439_01/doc.1013/e13981/undejdev008.htm");
        YELLOW.printGenericLn("https://docs.oracle.com/cd/E23095_01/Platform.93/ATGProgGuide/html/s1205transactiondemarcation01.html#:~:text=The%20demarcation%20initializes%20some%20transactional,calls%20to%20the%20TransactionManager%20object.");

        Flash2C1.main(args);
    }
}
