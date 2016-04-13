package com.steelzack.b2b2designpatterns.interpreterpattern;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by joaofilipesabinoesperancinha on 13-04-16.
 */
public class MultiAnimalExpressionTest {

    public static final String ORANGUTAN = "Orangutan";
    public static final String MONKEY = "Monkey";
    public static final String GORILLA = "Gorilla";
    public static final String WOMBAT = "Wombat";

    @Test
    public void interpret() throws Exception {
        final AnimalMaxWeightExpression expression1 = new AnimalOneExpression(MONKEY, 100);
        final AnimalMaxWeightExpression expression2 = new AnimalOneExpression(GORILLA, 400);
        final AnimalMaxWeightExpression expression3 = new AnimalOneExpression(ORANGUTAN, 600);
        final AnimalMaxWeightExpression expression4 = new AnimalOneExpression(WOMBAT, 20);

        final MultiAnimalExpression multiAnimalExpression = new MultiAnimalExpression( //
                expression1, //
                expression2, //
                expression3, //
                expression4 //
        );

        assertTrue(multiAnimalExpression.interpret(MONKEY + "," + 100));
        assertTrue(multiAnimalExpression.interpret(GORILLA + "," + 400));
        assertTrue(multiAnimalExpression.interpret(ORANGUTAN + "," + 600));
        assertTrue(multiAnimalExpression.interpret(WOMBAT + "," + 20));
    }

    @Test
    public void interpret_false() throws Exception {
        final AnimalMaxWeightExpression expression1 = new AnimalOneExpression(MONKEY, 100);
        final AnimalMaxWeightExpression expression2 = new AnimalOneExpression(GORILLA, 400);
        final AnimalMaxWeightExpression expression3 = new AnimalOneExpression(ORANGUTAN, 600);
        final AnimalMaxWeightExpression expression4 = new AnimalOneExpression(WOMBAT, 20);

        final MultiAnimalExpression multiAnimalExpression = new MultiAnimalExpression( //
                expression1, //
                expression2, //
                expression3, //
                expression4 //
        );

        assertFalse(multiAnimalExpression.interpret(MONKEY + "," + 101));
        assertFalse(multiAnimalExpression.interpret(GORILLA + "," + 401));
        assertFalse(multiAnimalExpression.interpret(ORANGUTAN + "," + 601));
        assertFalse(multiAnimalExpression.interpret(WOMBAT + "," + 21));
    }
}