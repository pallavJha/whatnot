package pl.misc.design.patterns.creational.factory;

/**
 * @author Pallav Jha
 * @since 20/5/18
 */
public class Circle implements Shape {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
