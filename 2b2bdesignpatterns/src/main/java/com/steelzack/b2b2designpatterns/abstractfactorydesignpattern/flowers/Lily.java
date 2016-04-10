package com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.flowers;

import com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.entities.FlowerImpl;

/**
 * Created by joaofilipesabinoesperancinha on 10-04-16.
 */
public class Lily extends FlowerImpl {
    public Lily()
    {
        this.petals = 3;
    }

    @Override
    public Integer getNumberOfPetals() {
        return petals;
    }
}
