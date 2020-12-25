package org.jesperancinha.jtd.jee.crums;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.jtd.jee.crums.crums1.Crum1;
import org.jesperancinha.jtd.jee.crums.crums2.Crum2;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

@Named("CrumRunner")
@ApplicationScoped
@Startup
@Singleton
public class CrumRunner {

    @PostConstruct
    public void postConstruct() {
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.maxLineCharsGlobal = 150;
        Consolerizer.titleSpread = 150;
        Consolerizer.blackAndWhite = false;
        printBlueGenericTitleLn("Welcome to the Crums 1 module about JEE");
        Crum1.main(null);
        Crum2.main(null);
        printBlueGenericTitleLn("This is the end of the Crums 1 module about JEE");
        printGreenGeneric("");
    }

}
