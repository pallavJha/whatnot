package pl.misc.design.patterns.creational.singleton;

/**
 * @author Pallav Jha
 * @since 20/5/18
 */
@SuppressWarnings({"unused"})
public class LazyInitializationSingleton {

    /**
     * This instance will be lazily created, unlike, Eager Initialization
     * and Static block initialization methods which makes it more
     * viable than those methods.
     * It's con is poor handling of Thread Safety, i.e, if multiple threads
     * are accessing getInstance() method at the same time, then
     * there are chances that instance field will be instantiated
     * multiple times.
     */
    private static LazyInitializationSingleton instance;

    private LazyInitializationSingleton() {

    }

    public static LazyInitializationSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializationSingleton();
        }
        return instance;
    }
}