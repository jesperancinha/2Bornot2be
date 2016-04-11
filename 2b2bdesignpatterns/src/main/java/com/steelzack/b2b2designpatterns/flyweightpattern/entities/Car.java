package com.steelzack.b2b2designpatterns.flyweightpattern.entities;

import java.awt.*;
import java.text.MessageFormat;

/**
 * Created by joaofilipesabinoesperancinha on 11-04-16.
 */
public class Car implements FourWheels {
    /**
     * Max speed by km/h
     */
    Integer maxSpeed;

    Color color;

    String knownName;

    public Car(String knownName) {
        this.knownName = knownName;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String rideTheCar()
    {
        return MessageFormat.format( //
                "Car {0} is riding up to  {1} km/h with a fine {2} color tone", //
                knownName, //
                maxSpeed, //
                color.getRGB() //
        );
    }
}
