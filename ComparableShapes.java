package hw6;

/**
 * Represents the general idea of a two-dimensional shape. Every
 * two-dimensional shape has an area and a perimeter.
 */
abstract class Shape {
    public abstract double getArea();
    public abstract double getPerimeter();
}


class Rectangle extends Shape implements Comparable<Rectangle> {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() { return length * width; }

    @Override
    public double getPerimeter() { return 2 * length + 2 * width; }

    @Override
    public String toString() {
        return "Rectangle with length " + length + " and width " + width;
    }

    @Override
    public int compareTo(Rectangle other) {
        if (this.getArea() > other.getArea())
            return 1;
        else if (this.getArea() < other.getArea())
            return -1;
        else
            return 0;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Rectangle)
            return this.length == ((Rectangle)other).length &&
                   this.width == ((Rectangle)other).width;
        else
            return false;
    }
}


class Circle extends Shape implements Comparable<Circle> {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() { return Math.PI * Math.pow(radius, 2); }

    @Override
    public double getPerimeter() { return 2 * Math.PI * radius; }

    @Override
    public String toString() { return "Circle with radius " + radius; }

    @Override
    public boolean equals(Object obj) { 
        if (obj instanceof Circle) 
            return this.radius == ((Circle)obj).radius;
        else
            return false; 
    }

    @Override
    public int compareTo(Circle other) {
        if (this.radius > other.radius)
            return 1;
        else if (this.radius < other.radius)
            return -1;
        else
            return 0;
    }
}

public class ComparableShapes {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(6.0, 3.0);
	Rectangle r2 = new Rectangle(10.0, 1.0);

	if (r1.compareTo(r2) > 0)
            System.out.println("r1 is greater than r2 (in terms of area)\n");
        else if (r1.compareTo(r2) < 0)
            System.out.println("r1 is smaller than r2 (in terms of area)\n");
        else
            System.out.println("r1 is equal to r2 (in terms of area)\n");

        Circle[] circles = {new Circle(3.0), new Circle(1.0),
                            new Circle(5.0), new Circle(2.0)};

        java.util.Arrays.sort(circles);   // if we import java.util.Arrays, we
					  // could say "Arrays.sort(circles);"

	for (Circle c : circles)
            System.out.println(c);
    }
}
