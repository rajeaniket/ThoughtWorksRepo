package org.barclays.Length;

public class Centimetre extends MetricUnits {
    private double value;
    private static final double centimetreUnitByBaseUnit = 100.0;

    public Centimetre(double value) {
        this.value = value;
    }

    @Override
    public double convertToBase() {
        return value / centimetreUnitByBaseUnit;
    }

    @Override
    public double convertFromBase(double value) {
        return value * centimetreUnitByBaseUnit;
    }

    @Override
    public Centimetre makeUnit(double value) {
        return new Centimetre(value);
    }
}
