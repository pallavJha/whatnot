package pl.misc.sedgewick.chap01;

import java.util.Stack;


public class TextBuffer<T> {
    private Stack<T> stack1 = null;
    private Stack<T> stack2 = null;
    private int      left;

    public TextBuffer() {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    public void insert(T data) {
        stack1.push(data);
    }

    public T delete() {
        return stack1.pop();
    }

    public void left(int k) {

        if (k > stack1.size()) {
            System.out.println("K should be less than " + stack1.size());
            return;
        }

        _1To2(k);
        left += k;
    }

    public void right(int k) {
        if (k > stack2.size()) {
            System.out.println("K should be less than " + stack2.size());
            return;
        }
        _2To1(k);
        left -= k;
    }
    
    private void _1To2(int k) {
        for (int i = 1 ; i <= k ; i++) {
            T temp_T = stack1.pop();
            stack2.push(temp_T);
        }
    }

    private void _2To1(int k) {
        for (int i = 1 ; i <= k ; i++) {
            T temp_T = stack2.pop();
            stack1.push(temp_T);
        }
    }

    public String toString() {
        String s = "";
        try {
            s += stack1.toString();
        } catch (Exception e) {
            System.err.println("\n" + "Error in fetching stack1 details.");
        }
        try {
            s += new StringBuffer(stack2.toString()).reverse().toString();
        } catch (Exception e) {
            System.err.println("\n" + "Error in fetching stack2 details.");
        }
        return s;
    }

    public static void main(String... aStrings) {
        TextBuffer<Character> buffer = new TextBuffer<Character>();
        buffer.insert('A');
        buffer.insert('B');
        buffer.insert('C');
        buffer.left(1);
        buffer.left(1);
        buffer.left(1);
        buffer.insert('D');
        buffer.right(1);
        buffer.right(1);
        System.out.println(buffer);
    }
}
