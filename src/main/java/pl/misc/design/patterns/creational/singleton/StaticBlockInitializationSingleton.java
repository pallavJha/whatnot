package pl.misc.design.patterns.creational.singleton;

/**
 * @author Pallav Jha
 * @since 20/5/18
 */
@SuppressWarnings({"unused"})
public class StaticBlockInitializationSingleton {

    /**
     * This instance will be instantiated in the static block.
     * Difference between this method of Singleton and Eager Initialization
     * Singleton is the try/catch block surrounding the instance creation
     * part. This and Eager Initialization method both will create
     * instance object when class is loaded by the classloader.
     */
    private static StaticBlockInitializationSingleton instance;

    static {
        try {
            instance = new StaticBlockInitializationSingleton();
        } catch (Exception e) {
            System.err.println("Error while creating instance");
            System.err.println(e);
        }
    }

    private StaticBlockInitializationSingleton() {

    }

    public static StaticBlockInitializationSingleton getInstance() {
        return instance;
    }
}
