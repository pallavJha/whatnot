package pl.misc.design.patterns.creational.factory;

/**
 * @author Pallav Jha
 * @since 20/5/18
 */
public class Square implements Shape {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}
