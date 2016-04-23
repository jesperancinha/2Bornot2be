package com.steelzack.b2b2designpatterns.chainofresponsibility;

import org.junit.Test;

import static com.steelzack.b2b2designpatterns.chainofresponsibility.ArmadaAbstract.FORMATION1;
import static com.steelzack.b2b2designpatterns.chainofresponsibility.ArmadaAbstract.FORMATION3;
import static com.steelzack.b2b2designpatterns.chainofresponsibility.ArmadaAbstract.FORMATION6;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
public class ArmadaAbstractTest extends LoggerInfoTest {
    private final ArmadaAbstract arado = new Arado(FORMATION1);
    private final ArmadaAbstract bell = new Bell(FORMATION3);
    private final ArmadaAbstract caproni = new Caproni(FORMATION6);

    @Test
    public void testChainOfResponsibilityFull() {
        final ArmadaAbstract armadaAbstractChain = getArmadaTestChain();
        final String ref = "all fighters!";
        armadaAbstractChain.issueFighters(FORMATION6, ref);

        final String logMessageResult = flushLogs();
        assertThat(logMessageResult, containsString("Fighter Arado has left the hanger with ref all fighters!"));
        assertThat(logMessageResult, containsString("Fighter Bell left the hanger with ref all fighters!"));
        assertThat(logMessageResult, containsString("Fighter Caproni has left the hanger with ref all fighters!"));
    }

    @Test
    public void testChainOfResponsibilityHalf() {
        final ArmadaAbstract armadaAbstractChain = getArmadaTestChain();
        final String ref = "two fighters!";

        armadaAbstractChain.issueFighters(FORMATION3, ref);

        final String logMessageResult = flushLogs();
        assertThat(logMessageResult, containsString("Fighter Arado has left the hanger with ref two fighters!"));
        assertThat(logMessageResult, containsString("Fighter Bell left the hanger with ref two fighters!"));
        assertThat(logMessageResult, not(containsString("Fighter Caproni has left the hanger with ref two fighters!")));
    }

    @Test
    public void testChainOfResponsibilityFirst() {
        final ArmadaAbstract armadaAbstractChain = getArmadaTestChain();
        final String ref = "one fighter!";
        armadaAbstractChain.issueFighters(FORMATION1, ref);

        final String logMessageResult = flushLogs();
        assertThat(logMessageResult, containsString("Fighter Arado has left the hanger with ref one fighter!"));
        assertThat(logMessageResult, not(containsString("Fighter Bell left the hanger with ref one fighter!")));
        assertThat(logMessageResult, not(containsString("Fighter Caproni has left the hanger with ref two fighter!")));
    }

    private ArmadaAbstract getArmadaTestChain() {
        arado.setNextFormation(bell);
        bell.setNextFormation(caproni);
        return arado;
    }
}