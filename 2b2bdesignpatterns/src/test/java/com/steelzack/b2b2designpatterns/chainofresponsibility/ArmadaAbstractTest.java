package com.steelzack.b2b2designpatterns.chainofresponsibility;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static com.steelzack.b2b2designpatterns.chainofresponsibility.ArmadaAbstract.FORMATION1;
import static com.steelzack.b2b2designpatterns.chainofresponsibility.ArmadaAbstract.FORMATION3;
import static com.steelzack.b2b2designpatterns.chainofresponsibility.ArmadaAbstract.FORMATION6;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ArmadaAbstractTest {
    private final ArmadaAbstract arado = new Arado(FORMATION1);
    private final ArmadaAbstract bell = new Bell(FORMATION3);
    private final ArmadaAbstract caproni = new Caproni(FORMATION6);

    @Test
    public void testChainOfResponsibilityFull() {
        final ArmadaAbstract armadaAbstractChain = getArmadaTestChain();
        final String ref = "all fighters!";
        armadaAbstractChain.issueFighters(FORMATION6, ref);
    }

    @Test
    public void testChainOfResponsibilityHalf() {
        final ArmadaAbstract armadaAbstractChain = getArmadaTestChain();
        final String ref = "all fighters!";
        armadaAbstractChain.issueFighters(FORMATION3, ref);
    }

    @Test
    public void testChainOfResponsibilityFirst() {
        final ArmadaAbstract armadaAbstractChain = getArmadaTestChain();
        final String ref = "all fighters!";
        armadaAbstractChain.issueFighters(FORMATION1, ref);
    }

    private ArmadaAbstract getArmadaTestChain() {
        arado.setNextFormation(bell);
        bell.setNextFormation(caproni);
        return arado;
    }
}