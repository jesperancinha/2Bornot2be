package com.steelzack.b2b2designpatterns.chainofresponsibility;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
public class Arado extends ArmadaAbstract {
    final static Logger logger = LoggerFactory.getLogger(Arado.class);

    public Arado(int chainLevel) {
        this.chainLevel = chainLevel;
    }

    @Override
    void makeFightersExitHanger(String ref) {
        logger.info(MessageFormat.format("Fighter arado has left the hanger with ref {0}", ref));
    }
}
