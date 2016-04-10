package com.steelzack.b2b2designpatterns.builderpattern.cultures;

import com.steelzack.b2b2designpatterns.builderpattern.containers.PetriDish;
import com.steelzack.b2b2designpatterns.builderpattern.experiment.Item;

/**
 * Created by joaofilipesabinoesperancinha on 10-04-16.
 */
public abstract class Culture implements Item {
    private final PetriDish container;

    public Culture()
    {
        this.container = new PetriDish();
    }

    public PetriDish getContainer() {
        return container;
    }
}
