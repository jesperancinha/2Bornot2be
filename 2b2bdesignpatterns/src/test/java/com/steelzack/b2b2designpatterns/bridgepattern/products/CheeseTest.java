package com.steelzack.b2b2designpatterns.bridgepattern.products;

import com.steelzack.b2b2designpatterns.bridgepattern.producers.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.logging.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by joaofilipesabinoesperancinha on 13-04-16.
 */
public class CheeseTest {
    @Test
    public void makeCheese() throws Exception {
        final Logger loggerCabrales = Logger.getLogger(CabralesCheese.class.getName());
        final Logger loggerGouda = Logger.getLogger(GoudaCheese.class.getName());
        final Logger loggerIlha = Logger.getLogger(IlhaCheese.class.getName());
        final Logger loggerSerra = Logger.getLogger(SerraCheese.class.getName());
        final Formatter formatter = new SimpleFormatter();
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final  Handler handler = new StreamHandler(out, formatter);
        loggerCabrales.addHandler(handler);
        loggerGouda.addHandler(handler);
        loggerIlha.addHandler(handler);
        loggerSerra.addHandler(handler);

        final Cheese cabralesCheese = new Cheese(5,10,new CabralesCheese());
        final Cheese goudaCheese = new Cheese(15,20,new GoudaCheese());
        final Cheese ilhaCheese = new Cheese(25,30,new IlhaCheese());
        final Cheese serraCheese = new Cheese(35,40,new SerraCheese());


        cabralesCheese.makeCheese();
        goudaCheese.makeCheese();
        ilhaCheese.makeCheese();
        serraCheese.makeCheese();

        assertEquals(5, cabralesCheese.getRadius());
        assertEquals(15, goudaCheese.getRadius());
        assertEquals(25, ilhaCheese.getRadius());
        assertEquals(35, serraCheese.getRadius());

        assertEquals(10, cabralesCheese.getHeight());
        assertEquals(20, goudaCheese.getHeight());
        assertEquals(30, ilhaCheese.getHeight());
        assertEquals(40, serraCheese.getHeight());

        handler.flush();
        final String fullLog = out.toString();

        assertThat(fullLog, containsString("Cabrales Cheese is made!"));
        assertThat(fullLog, containsString("Gouda Cheese is made!"));
        assertThat(fullLog, containsString("Ilha Cheese is made!"));
        assertThat(fullLog, containsString("Serra Cheese is made!"));
    }

}