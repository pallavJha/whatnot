package pl.misc.design.patterns.creational.singleton;

/**
 * @author Pallav Jha
 * @since 20/5/18
 */
@SuppressWarnings({"unused"})
public class EagerInitializationSingleton {

    /**
     * This instance is instantiated at very beginning, i.e,
     * when the class is loaded by class loader
     * This property of instantiation is a demerit too
     * because the instantiation part can be costly and
     * it is also possible that the instance might not be used
     * in the whole process which defeats the creation of this
     * instance.
     */
    private static EagerInitializationSingleton instance = new EagerInitializationSingleton();

    private EagerInitializationSingleton() {

    }

    public static EagerInitializationSingleton getInstance() {
        return EagerInitializationSingleton.instance;
    }
}
