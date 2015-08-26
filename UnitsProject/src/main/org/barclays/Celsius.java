package org.barclays;

public class Celsius implements Temperature {
    private double value;

    public Celsius(double value) {
        this.value = value;
    }

    @Override
    public double convertToBase() {
        return value + 273.15;
    }
}
