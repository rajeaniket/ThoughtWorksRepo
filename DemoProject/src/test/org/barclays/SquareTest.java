package org.barclays;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SquareTest {
    @Test
    public void shouldCalculateArea() {
        Rectangle square = Rectangle.createSquare(5);
        assertEquals(25, square.area());
    }

    @Test
    public void shouldCalculatePerimeter() {
        Rectangle square = Rectangle.createSquare(10);
        assertEquals(40, square.perimeter());
    }

}