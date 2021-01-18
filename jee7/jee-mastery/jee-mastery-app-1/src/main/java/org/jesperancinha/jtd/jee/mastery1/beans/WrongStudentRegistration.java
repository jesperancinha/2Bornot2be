package org.jesperancinha.jtd.jee.mastery1.beans;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BRIGHT_CYAN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;

@Named
public class WrongStudentRegistration implements Serializable {

    @Inject
    private StudentBean studentBean;

    WrongStudentRegistration(){
        YELLOW.printGenericTitleLn("Starting with %s", this.getClass().getCanonicalName());
        GREEN.printGenericLn("Notice what happens to this instance");
        GREEN.printGenericLn(this);
        BRIGHT_CYAN.printGenericTitleLn("It's important to notice that studentBean will be injected, but not using the setter.");
        GREEN.printInstanceLn(this);
    }

    public StudentBean getStudentBean() {
        ORANGE.printInstanceLn(this);
        return studentBean;
    }

    public void setStudentBean(StudentBean studentBean) {
        MAGENTA.printGenericLn("Set studentBean being called!");
        MAGENTA.printInstanceLn(this);
        this.studentBean = studentBean;
    }

    @Override
    public String toString() {
        return "WrongStudentRegistration{" +
                "studentBean=" + studentBean +
                '}';
    }
}
