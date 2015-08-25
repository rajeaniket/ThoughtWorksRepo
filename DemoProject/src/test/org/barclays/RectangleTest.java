package org.barclays;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void shouldCalculatePerimeter() {
        Rectangle rectangle = new Rectangle(5, 6);
        assertEquals(22, rectangle.perimeter());
    }

    @Test
    public void shouldCalculateArea() {
        Rectangle rectangle = new Rectangle(7, 4);
        assertEquals(28, rectangle.area());
    }
}