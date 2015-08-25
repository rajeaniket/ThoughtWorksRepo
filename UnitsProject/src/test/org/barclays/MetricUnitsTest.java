package org.barclays;

import org.junit.Test;

public class MetricUnitsTest {
    @Test
    public void shouldbeTrueForMetricObjects() {
        MetricUnits first = new MetricUnits(1, 100, 10);
        MetricUnits second = new MetricUnits(2, 0, 20);

    }
}
