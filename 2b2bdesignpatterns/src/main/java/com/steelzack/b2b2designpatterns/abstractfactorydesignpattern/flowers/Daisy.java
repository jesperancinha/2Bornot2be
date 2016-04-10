package com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.flowers;

import com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.entities.FlowerImpl;

/**
 * Created by joaofilipesabinoesperancinha on 10-04-16.
 */
public class Daisy extends FlowerImpl {
    public Daisy ()
    {
        this.petals = 42;
    }

    @Override
    public Integer getNumberOfPetals() {
        return this.petals;
    }
}
