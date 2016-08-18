package com.steelzack.b2b2designpatterns.abstractfactorypattern.producer;

import com.steelzack.b2b2designpatterns.abstractfactorypattern.entities.Flower;
import com.steelzack.b2b2designpatterns.abstractfactorypattern.entities.Mammal;
import com.steelzack.b2b2designpatterns.abstractfactorypattern.factory.AbstractFactory;
import com.steelzack.b2b2designpatterns.abstractfactorypattern.factory.FlowerFactory;
import com.steelzack.b2b2designpatterns.abstractfactorypattern.factory.MammalFactory;
import com.steelzack.b2b2designpatterns.abstractfactorypattern.flowers.Daisy;
import com.steelzack.b2b2designpatterns.abstractfactorypattern.flowers.Lily;
import com.steelzack.b2b2designpatterns.abstractfactorypattern.flowers.Rose;
import com.steelzack.b2b2designpatterns.abstractfactorypattern.mammals.Dog;
import com.steelzack.b2b2designpatterns.abstractfactorypattern.mammals.Platypus;
import com.steelzack.b2b2designpatterns.abstractfactorypattern.mammals.Whale;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by joaofilipesabinoesperancinha on 10-04-16.
 */
public class FactoryProducerTest {
    public static final String MAMMAL = "Mammal";
    public static final String FLOWER = "Flower";
    public static final String NOTHING = "Nothing";
    public static final String DAISY = "Daisy";
    public static final String LILY = "Lily";
    public static final String ROSE = "Rose";
    public static final String DOG = "Dog";
    public static final String PLATYPUS = "Platypus";
    public static final String WHALE = "Whale";
    
    private FactoryProducer factoryProducer;

    @Before
    public void setUp() throws Exception {
        factoryProducer = new FactoryProducer();
    }

    @After
    public void tearDown() throws Exception {
        factoryProducer = null;
    }

    @Test
    public void getFactory() throws Exception {
        final AbstractFactory mammalFactory = factoryProducer.getFactory(MAMMAL);
        final AbstractFactory flowerFactory = factoryProducer.getFactory(FLOWER);
        final AbstractFactory nothingFactory  = factoryProducer.getFactory(NOTHING);

        final Flower daisy = flowerFactory.getFlower(DAISY);
        final Flower lily = flowerFactory.getFlower(LILY);
        final Flower rose = flowerFactory.getFlower(ROSE);
        final Flower nothingFlower = flowerFactory.getFlower(NOTHING);

        final Mammal dog = mammalFactory.getMammal(DOG);
        final Mammal platypus = mammalFactory.getMammal(PLATYPUS);
        final Mammal whale = mammalFactory.getMammal(WHALE);
        final Mammal nothingMammal = mammalFactory.getMammal(NOTHING);

        // Fake tests. they should all be null
        final Flower fakedaisy = mammalFactory.getFlower(DAISY);
        final Flower fakelily = mammalFactory.getFlower(LILY);
        final Flower fakerose = mammalFactory.getFlower(ROSE);
        final Flower fakenothingFlower = mammalFactory.getFlower(NOTHING);

        final Mammal fakedog = flowerFactory.getMammal(DOG);
        final Mammal fakeplatypus = flowerFactory.getMammal(PLATYPUS);
        final Mammal fakewhale = flowerFactory.getMammal(WHALE);
        final Mammal fakenothingMammal = flowerFactory.getMammal(WHALE);

        assertTrue(mammalFactory instanceof MammalFactory);
        assertTrue(flowerFactory instanceof FlowerFactory);
        assertNull(nothingFactory);

        assertTrue(daisy instanceof Daisy);
        assertTrue(lily instanceof Lily);
        assertTrue(rose instanceof Rose);
        assertNull(nothingFlower);

        assertTrue(dog instanceof Dog);
        assertTrue(platypus instanceof Platypus);
        assertTrue(whale instanceof Whale);
        assertNull(nothingMammal);

        // Fake assertions

        assertNull(fakedaisy);
        assertNull(fakelily);
        assertNull(fakerose);
        assertNull(fakedaisy);
        assertNull(fakenothingFlower);
        assertNull(fakedog);
        assertNull(fakeplatypus);
        assertNull(fakewhale);
        assertNull(fakenothingMammal);
    }
}