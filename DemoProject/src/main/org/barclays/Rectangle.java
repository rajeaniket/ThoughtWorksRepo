package org.barclays;

public class Rectangle {
    private int length;
    private int breadth;

    public static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }

    public Rectangle(int length) {
        this.length = length;
        this.breadth = length;
    }

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public int area() {
        return this.length * this.breadth;
    }

    public int perimeter() {
        return 2 * (this.length + this.breadth);
    }

}