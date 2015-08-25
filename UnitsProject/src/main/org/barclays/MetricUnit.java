package org.barclays;

public interface MetricUnit {
    public MetricUnit convertToBase(MetricUnit metricUnit);
    public MetricUnit convertFromBase(MetricUnit metricUnit);
}
