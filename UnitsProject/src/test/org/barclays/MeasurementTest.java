package org.barclays;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class MeasurementTest
{
    @Test
    public void shouldAddMeasurement() {
        Measurement first = new Measurement(5, 80, 100);
        Measurement second = new Measurement(0, 40, 100);
        first.addMaterial(second);
        assertEquals(6, first.getMeters());
        assertEquals(20, first.getCentimeters());
    }

    @Test
    public void shouldCompareMeasurement() {
        Measurement first = new Measurement(5, 80, 100);
        Measurement second = new Measurement(4, 180, 100);
        assertTrue(first.compareMaterial(second));
    }
}
