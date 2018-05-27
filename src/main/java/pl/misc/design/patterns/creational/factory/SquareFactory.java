package pl.misc.design.patterns.creational.factory;

/**
 * @author Pallav Jha
 * @since 20/5/18
 */
public class SquareFactory implements ShapeAbstractFactory {

    private int side;

    public SquareFactory(int side) {
        this.side = side;
    }


    @Override
    public Shape createShape() {
        return new Square(side);
    }
}
