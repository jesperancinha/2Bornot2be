package com.steelzack.b2b2designpatterns.facade.maker;

import com.steelzack.b2b2designpatterns.facade.entities.Cancer;
import com.steelzack.b2b2designpatterns.facade.entities.Pegasus;
import com.steelzack.b2b2designpatterns.facade.entities.Sagittarius;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by joaofilipesabinoesperancinha on 11-04-16.
 */
public class ConstellationMakerTest {
    @Test
    public void drawCancer() throws Exception {
        Logger logger = Logger.getLogger(Cancer.class.getName());
        Formatter formatter = new SimpleFormatter();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Handler handler = new StreamHandler(out, formatter);
        logger.addHandler(handler);


        final ConstellationMaker constellationMaker = new ConstellationMaker();
        final Runnable drawCancer = constellationMaker::drawCancer;
        final ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(drawCancer);
        service.shutdown();
        service.awaitTermination(60, TimeUnit.SECONDS);

        handler.flush();
        String logMsg = out.toString();
        assertThat(logMsg, containsString("Constellation Cancer is drawn!"));
    }

    @Test
    public void drawPegasus() throws Exception {
        Logger logger = Logger.getLogger(Pegasus.class.getName());
        Formatter formatter = new SimpleFormatter();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Handler handler = new StreamHandler(out, formatter);
        logger.addHandler(handler);

        final ConstellationMaker constellationMaker = new ConstellationMaker();
        final Runnable drawPegasus = constellationMaker::drawPegasus;
        final ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(drawPegasus);
        service.shutdown();
        service.awaitTermination(60, TimeUnit.SECONDS);

        handler.flush();
        String logMsg = out.toString();
        assertThat(logMsg, containsString("Constellation Pegasus is drawn!"));
    }

    @Test
    public void drawSagittarius() throws Exception {
        Logger logger = Logger.getLogger(Sagittarius.class.getName());
        Formatter formatter = new SimpleFormatter();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Handler handler = new StreamHandler(out, formatter);
        logger.addHandler(handler);

        final ConstellationMaker constellationMaker = new ConstellationMaker();
        final Runnable drawSagittarius = constellationMaker::drawSagittarius;
        final ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(drawSagittarius);
        service.shutdown();
        service.awaitTermination(60, TimeUnit.SECONDS);

        handler.flush();
        String logMsg = out.toString();
        assertThat(logMsg, containsString("Constellation Sagittarius is drawn!"));
    }

}