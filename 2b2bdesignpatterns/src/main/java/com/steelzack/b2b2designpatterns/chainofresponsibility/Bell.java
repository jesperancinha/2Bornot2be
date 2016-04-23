package com.steelzack.b2b2designpatterns.chainofresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
public class Bell extends ArmadaAbstract {
    final static Logger logger = LoggerFactory.getLogger(Bell.class);

    public Bell(int chainLevel) {
        this.chainLevel = chainLevel;
    }

    @Override
    void makeFightersExitHanger(String ref) {
        logger.info(MessageFormat.format("Fighter Bell left the hanger with ref {0}", ref));
    }
}
