package org.barclays;

import junit.framework.Assert;
import org.junit.Test;

public class MetreTest {
    @Test
    public void shouldConvertToBase() {
        Metre metre = new Metre(10);
        Assert.assertEquals(null, metre.convertToBase(metre));
    }
}
