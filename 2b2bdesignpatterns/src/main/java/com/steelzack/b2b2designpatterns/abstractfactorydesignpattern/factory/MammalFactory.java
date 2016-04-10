package com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.factory;

import com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.entities.Flower;
import com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.entities.Mammal;
import com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.mammals.Dog;
import com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.mammals.Platypus;
import com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.mammals.Whale;

/**
 * Created by joaofilipesabinoesperancinha on 10-04-16.
 */
public class MammalFactory extends AbstractFactory {
    public Flower getFlower(String flowerType) {
        return null;
    }

    public Mammal getMammal(String mammalType) {
        switch (mammalType)
        {
            case "Dog" :  return new Dog();
            case "Platypus" : return new Platypus();
            case "Whale" : return  new Whale();
        }
        return null;
    }
}
