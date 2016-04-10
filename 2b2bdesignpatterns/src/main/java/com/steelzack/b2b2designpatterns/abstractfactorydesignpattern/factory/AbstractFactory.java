package com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.factory;

import com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.entities.Flower;
import com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.entities.Mammal;

/**
 * Created by joaofilipesabinoesperancinha on 10-04-16.
 */
public abstract class AbstractFactory {
    public abstract Flower getFlower(String flowerType);

    public abstract Mammal getMammal(String mammalType);
}
