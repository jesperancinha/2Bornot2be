module $mastery22$ {
    // 6. Conflicting exports in modularization
    // Duplicate 'exports': org.jesperancinha.ocp11.mastery2dot2
    // exports org.jesperancinha.ocp11.mastery2dot2;
    exports org.jesperancinha.ocp11.mastery2dot2 to org.jesperancinha.ocp11.master2dot2.module;
    requires transitive org.assertj.core;
    requires consolerizer;
    requires java.sql;
}