package pl.misc.design.patterns.creational.factory;

/**
 * @author Pallav Jha
 * @since 20/5/18
 */
@SuppressWarnings({"unused"})
public class ShapeFactory {

    /**
     * <p>
     * This is factory design pattern.
     * In here the constructor of the desired object is called
     * by the factory(in here, ShapeFactory) and the client
     * has to pass the arguments.
     * </p>
     * <p>
     * If there are some changes to be done before instantiation
     * then those changes will be written in the methods of
     * the factory rather than the client's code which propagates
     * the idea of loose coupling.
     * </p>
     * <p>
     * Also, the constructor code and data modification before calling
     * the constructor is done at Factory which makes the object
     * creation part abstract.
     * </p>
     * <p>
     * CONS:
     * If a new sub type is created then #getShape Method is
     * likely to have changes as new cases in the switch block
     * have to be introduced which is one of its drawbacks.
     * This drawback is addressed by Abstract Factory Pattern.
     * Second problem lies in the number of optional arguments passed to
     * the constructor. This problem is addressed by Builder Pattern
     * </p>
     *
     * @param shapeType type of desired shape
     * @param num       integer value of radius or side of the square
     * @return Shape
     */
    public static Shape getShape(ShapeType shapeType, int num) {
        switch (shapeType) {
            case CIRCLE:
                return new Circle(num);
            case TRIANGLE:
                return new Triangle(num, num, num);
            case SQUARE:
                return new Square(num);
            default:
                throw new UnsupportedOperationException("Unknown shape type passed!");
        }
    }

    /**
     * The issue with Factory Pattern lies in two sections:
     * 1. New Subtype, as it requires a change in switch statements
     * 2. Number of optional arguments
     *
     * First issue is solved by Abstract Factory Pattern. Instead of
     * creating objects based on type, Factory class uses another
     * factory to create the object. Whenever a new sub-type is created,
     * a new Factory is also created along with it whose responsibility
     * is to create the object for that sub-type. This factory also
     * implements an interface and that interface is present in the
     * argument list of this class.
     *
     * @param shapeAbstractFactory factory by shape type, it can be either circleFactory, triangleFactory, squareFactory
     * @return Shape
     */
    public static Shape getShape(ShapeAbstractFactory shapeAbstractFactory) {
        return shapeAbstractFactory.createShape();
    }
}
