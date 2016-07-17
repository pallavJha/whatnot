package pl.misc.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * <h6>The Class DateTimeFinder.</h6>
 * <p>On running the main method the user can find the occurences of a datatype in the specified class <i>z</i></p>
 * <p>It'll search in all the fields and their subsequent fields till the classes list turns empty.</p>
 * <p>Currently it finds all the occurences of org.joda.time.DateTime.</p>
 *
 * @author Pallav Jha(pallav_kumar71 at yahoo dot com)
 */
public class ClassInFields {

    private ClassInFields() {
    }

    /**
     * The ignored classes.
     * Contains the classes which needs to be ignored.
     */
    static Set<Class<?>> ignoredClasses = getWrapperTypes();

    /**
     * The classes.
     * Contains the fields of the current class, it'll keep on growing.
     */
    static List<Class<?>> classes = new ArrayList<>();

    /**
     * The z.
     * Initial Class
     **/
    static Class<?> z = String.class;

    /**
     * The field array.
     */
    static Field[] fieldArray;
    static Integer i = 0;

    static {
        classes.add(z);
    }

    /**
     * The main method.
     *
     * @param strings the arguments
     * @throws Throwable the throwable
     */
    public static void main(String... strings) throws Throwable {
        extractFields();
    }

    /**
     * Gets the date time.
     *
     * @param z the z
     */
    public static void getDateTime(Class<?> z) {

        for (Field f : fieldArray) {

            if (!(f.getType().isPrimitive()) && !ignoredClasses.contains(f.getType())) {
                
                /*  
                 * This condition checks for the occurence of the desired class
                 *           ^
                 *         /   \
                 *          | |
                 *          | |
                 */
                if (f.getType().equals(Number.class)) {//SomeClassNameToLookFor;
                    System.out.print(++i);
                    for (int k = 0; k < (5 - i.toString().length()); k++) {
                        System.out.print(" ");
                    }
                    System.out.print(f.getName());
                    for (int k = 0; k < (32 - f.getName().length()); k++) {
                        System.out.print(" ");
                    }
                    System.out.print(f.getType() + "\t");
                    System.out.println(z + "\t");
                    continue;
                }
                
                /*  
                 * This condition checks the generic type of the collection api objects
                 *           ^
                 *         /   \
                 *          | |
                 *          | |
                 */

                if (f.getType().equals(List.class) || f.getType().equals(Set.class) || f.getType().equals(HashMap.class)) {
                    ParameterizedType pType = (ParameterizedType) f.getGenericType();
                    try {
                        Class<?> sampleClass = (Class<?>) pType.getActualTypeArguments()[0];
                        if (!classes.contains(sampleClass)) {
                            classes.add(sampleClass);
                        }
                        continue;
                    } catch (java.lang.Exception e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                }
                if (!classes.contains(f.getType())) {
                    classes.add(f.getType());
                }
            }
        }

    }

    /**
     * Extract fields.
     */
    public static void extractFields() {

        for (int i = 0; i < classes.size(); i++) {
            fieldArray = classes.get(i).getDeclaredFields();
            getDateTime(classes.get(i));
        }
    }

    /**
     * Gets the wrapper types.
     *
     * @return the wrapper types
     */
    public static Set<Class<?>> getWrapperTypes() {
        Set<Class<?>> ret = new HashSet<>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        ret.add(String.class);
        return ret;
    }
}
