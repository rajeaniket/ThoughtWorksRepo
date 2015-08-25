package org.barclays;

public class Metre implements MetricUnit {

    private int value;
    private static final double conversionFactor = 1.0;

    public Metre(int value) {
        this.value = value;
    }

    @Override
    public Metre convertToBase(MetricUnit metricUnit) {

        return null;
    }

    @Override
    public MetricUnit convertFromBase(MetricUnit metricUnit) {
        return null;
    }
}
