package org.jesperancinha.jtd.jee.portugal.beans;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Stack;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

@Stateless
@Dependent
public class HistoryStatelessDelivery implements Serializable {
    final Stack<String> stackOfEvents1 = HistoryContentCreator.stackOfEvents1();

    public HistoryStatelessDelivery() {
        printYellowGenericLn("This is a %s with hash %s", this.getClass()
            .getCanonicalName(), this.hashCode());
        printYellowGenericLn(stackOfEvents1);
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
}
