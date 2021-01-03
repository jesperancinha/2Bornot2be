package org.jesperancinha.jtd.jee.teeth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table
public class Tooth {

    private UUID uuid;

    private Jaw jaw;

    @ManyToOne
    public Jaw getJaw() {
        return jaw;
    }

    public void setJaw(Jaw jaw) {
        this.jaw = jaw;
    }

    @Id
    @Column
    @NotNull
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String toString(){
        return uuid.toString();
    }
}