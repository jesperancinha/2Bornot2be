package org.jesperancinha.jtd.jee.teeth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table
public class Tooth {

    private UUID uuid;

    private Jaw jaw;

    private Nerve nerve;

    private ToothType toothType;

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
    // org.jboss.arquillian.container.spi.client.container.DeploymentException:
    // Cannot deploy test.war:
    // {"WFLYCTL0062: Composite operation failed and was rolled back.
    // Steps that failed:" => {"Operation step-1" =>
    // {"WFLYCTL0080: Failed services" => {"jboss.persistenceunit.\"test.war#primary\"" =>
    // "org.hibernate.AnnotationException: @Column(s) not allowed on a
    // @OneToOne property: org.jesperancinha.jtd.jee.teeth.domain.Tooth.nerve
    //    Caused by: org.hibernate.AnnotationException: @Column(s)
    //    not allowed on a @OneToOne property:
    //    org.jesperancinha.jtd.jee.teeth.domain.Tooth.nerve"}}}}
    // @Column
    @OneToOne
    public Nerve getNerve() {
        return nerve;
    }

    public void setNerve(Nerve nerve) {
        this.nerve = nerve;
    }

    @Enumerated(EnumType.STRING)
    public ToothType getToothType() {
        return toothType;
    }

    public void setToothType(ToothType toothType) {
        this.toothType = toothType;
    }
}
