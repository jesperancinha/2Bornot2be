package org.jesperancinha.ocp11.disambiguity.beans;

public class BeansRunner {
    public static void main(String[] args) {
        final var beanPlant = new BeanPlant();
        System.out.println(beanPlant.getColor());
        final var brokenBeanPlant = new BrokenBeanPlant();
        System.out.println(brokenBeanPlant.getColor());
    }
}
