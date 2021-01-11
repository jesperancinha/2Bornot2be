package org.jesperancinha.jtd.jee.portugal.rest.def.scope.beans;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;
import java.util.Stack;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

@Stateless
public class HistoryStatelessDeliveryDefault implements Serializable {
    final Stack<String> stackOfEvents1 = HistoryContentCreator.stackOfEvents1();

    public HistoryStatelessDeliveryDefault() {
        printYellowGenericLn("This is a %s with hash %s", this.getClass()
            .getCanonicalName(), this.hashCode());
        printYellowGenericLn(stackOfEvents1);
        printGreenGenericLn("A @Stateless bean is never passivated and only has two stages:");
        printGreenGenericLn("Non-existent and ready for activation");
        printGreenGenericLn("nonexistent and ready for the invocation of business methods.");
    }

    public List<String> getSomeHistory() {
        return HistoryContentCreator.stackOfEvents1();
    }

    public String getLatestElementOfHistory() {
        printBlueGenericLn("This is instance of type %s with hash %s and elements %s", this.getClass()
            .getCanonicalName(), this.hashCode(), stackOfEvents1);
        return stackOfEvents1.pop();
    }

    @PreDestroy
    public void destroy() {
        printBlueGenericTitleLn("Bean %s is being destroyed", this.getClass()
            .getCanonicalName());
    }

    @PostConstruct
    public void postConstruct() {
        Consolerizer.titleSpread = 150;
        printBlueGenericTitleLn("Bean %s with hash %s is being passivated", this.getClass()
            .getCanonicalName(), this.hashCode());
    }
}
