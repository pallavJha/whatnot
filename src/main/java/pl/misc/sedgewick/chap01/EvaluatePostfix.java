package pl.misc.sedgewick.chap01;

import java.util.Stack;

public class EvaluatePostfix {

	public static void main(String[] args) {
		evalPostFix("12+34-56-**");
	}

	public static void evalPostFix(String postFixStr) {

		Stack<String> stack = new Stack<String>();
		String operators = "+-*/";

		for (int i = 0; i < postFixStr.length(); i++) {
			String current = String.valueOf(postFixStr.charAt(i));
			if (operators.contains(current)) {
				int b = Integer.parseInt(stack.pop());
				int a = Integer.parseInt(stack.pop());
				stack.push(calculate(a, b, current).toString());
			} else {
				stack.push(current);
			}
		}
		System.out.println(stack.pop());
	}

	public static Integer calculate(int a, int b, String operator) {
		if (operator.equals("+")) {
			return a + b;
		} else if (operator.equals("-")) {
			return a - b;
		} else if (operator.equals("*")) {
			return a * b;
		} else if (operator.equals("/")) {
			return a / b;
		}
		return null;
	}
}