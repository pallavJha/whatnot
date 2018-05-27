package pl.misc.design.patterns.creational.factory;

/**
 * @author Pallav Jha
 * @since 20/5/18
 */
public class TriangleFactory implements ShapeAbstractFactory {

    private int side;

    public TriangleFactory(int side) {
        this.side = side;
    }


    @Override
    public Shape createShape() {
        return new Triangle(side, side, side);
    }
}
