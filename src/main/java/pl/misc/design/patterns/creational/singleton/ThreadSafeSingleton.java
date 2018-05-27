package pl.misc.design.patterns.creational.singleton;

/**
 * @author Pallav Jha
 * @since 20/5/18
 */
@SuppressWarnings({"unused"})
public class ThreadSafeSingleton {

    /**
     * This time the instance will be created in a
     * `synchronized` block which addressed the con
     * which is present in Static Block Initialization
     * Singleton pattern. Since the Method #getInstance is synchronized,
     * each and every other thread will have to wait for the currently
     * accessing thread to complete even if instance is instantiated.
     */
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {

    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
