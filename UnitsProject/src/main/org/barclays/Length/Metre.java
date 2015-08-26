package org.barclays.Length;

public class Metre extends MetricUnits {

    private double value;
    private static final double metreUnitByBaseUnit = 1.0;

    public Metre(double value) {
        this.value = value;
    }

    @Override
    public double convertToBase() {
        return value / metreUnitByBaseUnit;
    }

    @Override
    public double convertFromBase(double value) {
        return value * metreUnitByBaseUnit;
    }

    @Override
    public Metre makeUnit(double value) {
        return new Metre(value);
    }
}
