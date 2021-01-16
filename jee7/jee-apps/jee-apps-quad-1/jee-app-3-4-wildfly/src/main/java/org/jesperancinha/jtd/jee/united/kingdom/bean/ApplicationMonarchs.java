package org.jesperancinha.jtd.jee.united.kingdom.bean;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ApplicationScoped
public class ApplicationMonarchs implements Serializable {

    private Monarch monarch = new Monarch();

    ApplicationMonarchs(){
        monarch.setName("Edward VII");
        monarch.setFamily("Saxe-Coburg and Gotha");
    }

    public void save(){
        Consolerizer.printOrangeGenericLn("You have just recorder monarch -> %s", monarch);
    }

    public void setMonarch(Monarch monarch) {
        this.monarch = monarch;
    }

    public Monarch getMonarch() {
        return monarch;
    }
}
