package pl.misc.prep.java8.chap02;

import javax.swing.*;
import java.io.PrintStream;
import java.util.function.Function;

/**
 * @author pallav
 * @version 1.0
 * @since 8/7/16
 */
public class Q01 {

    static PrintStream out = System.out;

    public static void main(String... args){
        Function<Long, Long> function = x -> x+1;
        out.print(function.apply(7L));

        Thread thread = new Thread(() ->out.println("Thread Ran"));
        thread.start();

        JButton button = new JButton();
        button.addActionListener(event -> println(event.getActionCommand()));
    }

    static void println(Object o){
        out.println(o.toString());
    }
}
