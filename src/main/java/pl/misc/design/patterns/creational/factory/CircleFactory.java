package pl.misc.design.patterns.creational.factory;

/**
 * @author Pallav Jha
 * @since 20/5/18
 */
public class CircleFactory implements ShapeAbstractFactory {

    private int radius;

    public CircleFactory(int radius) {
        this.radius = radius;
    }


    @Override
    public Shape createShape() {
        return new Circle(radius);
    }
}
