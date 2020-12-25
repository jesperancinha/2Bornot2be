package org.jesperancinha.jtd.jee.crums.crums2;

import org.jesperancinha.jtd.jee.crums.crums2.crum1.Crum2C1;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum2 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum2 - EJB Business tier");

        printYellowGenericLn("from:");
        printYellowGenericLn("https://docs.oracle.com/javaee/7/tutorial/ejb-intro001.htm#GIPMB");
        printYellowGenericLn("https://www.appservgrid.com/documentation111/docs/fmw12c1211documentation/web.1211/e24972/understanding.htm");
        printYellowGenericLn("https://access.redhat.com/documentation/en-us/jboss_enterprise_application_platform/6.3/html/development_guide/implementing_a_custom_load_balancing_policy_for_ejb_calls");
        printYellowGenericLn("https://docs.oracle.com/cd/E18930_01/html/821-2431/abeea.html");
        printYellowGenericLn("https://docs.oracle.com/cd/E16439_01/doc.1013/e13981/undejdev008.htm");
        printYellowGenericLn("https://docs.oracle.com/cd/E23095_01/Platform.93/ATGProgGuide/html/s1205transactiondemarcation01.html#:~:text=The%20demarcation%20initializes%20some%20transactional,calls%20to%20the%20TransactionManager%20object.");

        Crum2C1.main(args);
    }
}
