package com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.flowers;

import com.steelzack.b2b2designpatterns.abstractfactorydesignpattern.entities.FlowerImpl;

/**
 * Created by joaofilipesabinoesperancinha on 10-04-16.
 */
public class Rose extends FlowerImpl {
    public Rose() {
        this.petals = 5;
    }

    @Override
    public Integer getNumberOfPetals() {
        return petals;
    }
}
