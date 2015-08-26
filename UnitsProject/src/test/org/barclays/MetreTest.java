package org.barclays;

import junit.framework.Assert;
import org.barclays.Length.Metre;
import org.junit.Test;

public class MetreTest {
    @Test
    public void shouldConvertToBase() {
        Metre metre = new Metre(10);
        Assert.assertEquals(10.0, metre.convertToBase());
    }
}
