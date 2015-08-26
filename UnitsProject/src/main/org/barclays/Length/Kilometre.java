package org.barclays.Length;

public class Kilometre extends MetricUnits {
    private double value;
    private static final double kilometreUnitByBaseUnit = 1 / 1000;

    public Kilometre(double value) {
        this.value = value;
    }

    @Override
    public double convertFromBase(double value) {
        return value * kilometreUnitByBaseUnit;
    }

    @Override
    public double convertToBase() {
        return this.value / kilometreUnitByBaseUnit;
    }

    @Override
    public Kilometre makeUnit(double value) {
        return new Kilometre(value);
    }
}
