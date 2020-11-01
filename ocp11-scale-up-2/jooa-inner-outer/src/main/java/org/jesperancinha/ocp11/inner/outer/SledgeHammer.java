package org.jesperancinha.ocp11.inner.outer;

/**
 * SledgeHammer
 */
public class SledgeHammer {

    /**
     * FruitCage
     */
    public abstract class FruitCage{
        // Inner classes cannot have static declarations
        // public static  int year = 1985;
        public static final int year = 1985;

        abstract String bake();
    }

    /**
     * Anonymous classes cannot be static
     * Anonymous must follow construction rules of the super class
     * Anonymous classes cannot define their own constructors
     * @return {@link FruitCage}
     */
    public FruitCage getFruitCage(){
        return new FruitCage() {
            public String bake(){
                return "--- baking fruit cage ---";
            }
        };
    }
}
