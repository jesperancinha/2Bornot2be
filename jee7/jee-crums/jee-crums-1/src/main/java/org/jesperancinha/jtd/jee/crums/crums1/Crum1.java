package org.jesperancinha.jtd.jee.crums.crums1;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum1 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum1 - Which are Java EE components ?");
        printYellowGenericLn("from:\nhttps://turngeek.github.io/javaee7inaweek/chapter/i-2-the-component-architecture-of-java-ee-7/");
        printMagentaGenericLn("Web Components:");
        printOrangeGenericLn("Java Server Faces (JSF)");
        printOrangeGenericLn("Java Servlet");
        printOrangeGenericLn("Java Server Pages (JSP)");
        printMagentaGenericLn("Java EE Components:");
        printOrangeGenericLn("Application clients and applets that run on the client");
        printOrangeGenericLn("Enterprise Java Beans (EJB) and business components that run on the server");
    }
}
