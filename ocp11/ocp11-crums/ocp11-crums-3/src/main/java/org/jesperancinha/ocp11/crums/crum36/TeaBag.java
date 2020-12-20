package org.jesperancinha.ocp11.crums.crum36;

public class TeaBag {

    private final String designation;
    private final double price;

    public TeaBag(String designation, double price) {
        this.designation = designation;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return "TeaBag{" + "designation='" + designation + '\'' + ", price=" + price + '}';
    }
}
