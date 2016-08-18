package com.steelzack.b2b2designpatterns.builderpattern.experiment;

import com.steelzack.b2b2designpatterns.builderpattern.bacterias.AerosphaeraTaetra;
import com.steelzack.b2b2designpatterns.builderpattern.bacterias.CarnococcusAllantoicus;
import com.steelzack.b2b2designpatterns.builderpattern.containers.GelBlocks;
import com.steelzack.b2b2designpatterns.builderpattern.cultures.Agar;
import com.steelzack.b2b2designpatterns.builderpattern.cultures.BeefBroth;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by joaofilipesabinoesperancinha on 10-04-16.
 */
public class ExperimentBuilderTest {
    @Test
    public void createAerosphaeraTaetraExperiment() throws Exception {
        final ExperimentBuilder experimentBuilder = new ExperimentBuilder();

        final Experiment experiment = experimentBuilder.createAerosphaeraTaetraExperiment();
        final List<Item> allItems = experiment.getItems();
        final Item item1 = allItems.get(0);
        final Item item2 = allItems.get(1);

        assertEquals(2, allItems.size());
        assertTrue(item1 instanceof Agar);
        assertTrue(item2 instanceof AerosphaeraTaetra);
        assertTrue(((AerosphaeraTaetra)item2).getForm() instanceof GelBlocks);
    }

    @Test
    public void createCarnococcusAllantoicusExperiment() throws Exception {
        final ExperimentBuilder experimentBuilder = new ExperimentBuilder();

        final Experiment experiment = experimentBuilder.createCarnococcusAllantoicusExperiment();
        final List<Item> allItems = experiment.getItems();
        final Item item1 = allItems.get(0);
        final Item item2 = allItems.get(1);

        assertEquals(2, allItems.size());
        assertTrue(item1 instanceof BeefBroth);
        assertTrue(item2 instanceof CarnococcusAllantoicus);
        assertTrue(((CarnococcusAllantoicus)item2).getForm() instanceof GelBlocks);
    }

}