package com.steelzack.b2b2designpatterns.chainofresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
public class Caproni extends ArmadaAbstract {
    final static Logger logger = LoggerFactory.getLogger(Caproni.class);
    public Caproni(int chainLevel) {
        this.chainLevel = chainLevel;
    }

    @Override
    void makeFightersExitHanger(String ref) {
        logger.info(MessageFormat.format("Fighter Caproni has left the hanger with ref {0}", ref));
    }
}
