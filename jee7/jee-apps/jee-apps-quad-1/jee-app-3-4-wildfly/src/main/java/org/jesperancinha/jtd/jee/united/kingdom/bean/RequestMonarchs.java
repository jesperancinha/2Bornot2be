package org.jesperancinha.jtd.jee.united.kingdom.bean;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RequestMonarchs {

    private Monarch monarch = new Monarch();

    RequestMonarchs(){
        monarch.setName("Anne Stuart");
        monarch.setFamily("Stuart");
    }

    public void save(){
        Consolerizer.printOrangeGenericLn("You have just recorder monarch -> %s", monarch);
    }

    public Monarch getMonarch() {
        return monarch;
    }

    public void setMonarch(Monarch monarch) {
        this.monarch = monarch;
    }
}

