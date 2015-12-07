package pl.misc.sedgewick.chap01;

import java.util.EmptyStackException;
import java.util.Stack;

public class Parentheses {
	@SuppressWarnings("unused")
	public static void main(String... args) throws MisMatchException {
		String s2 = "[()]{}{[()()]()}";
		String s = "[(])";
		String opening_braces = "[{(";
		String closing_braces = "]})";
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (opening_braces.contains(String.valueOf(s.charAt(i)))) {
				stack.push(s.charAt(i));
			} else if (closing_braces.contains(String.valueOf(s.charAt(i)))) {
				char popped = 'A';
				try {
					popped = stack.pop();
				} catch (EmptyStackException e) {
					throw new MisMatchException("Empty Stack");
				}
				if (popped == '[' && s.charAt(i) == ']') {
					System.out.println("Matched! [ ]");
				} else if (popped == '{' && s.charAt(i) == '}') {
					System.out.println("Matched! { }");
				} else if (popped == '(' && s.charAt(i) == ')') {
					System.out.println("Matched! ( )");
				} else {
					throw new MisMatchException("Mismatch");
				}
			}
		}
	}

	private static class MisMatchException extends Exception {
		private static final long serialVersionUID = 1L;

		public MisMatchException(String msg) {
			super(msg);
		}
	}

}