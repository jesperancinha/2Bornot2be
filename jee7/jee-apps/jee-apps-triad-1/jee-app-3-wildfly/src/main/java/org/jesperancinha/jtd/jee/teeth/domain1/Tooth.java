package org.jesperancinha.jtd.jee.teeth.domain1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity(name = "tooth1")
@Table(name = "tooth1")
public class Tooth {

    @Id
    @Column
    @NotNull
    private UUID uuid;

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
