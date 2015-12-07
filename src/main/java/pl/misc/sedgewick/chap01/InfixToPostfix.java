package pl.misc.sedgewick.chap01;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String args[]) {
		String infixString = "((1+2)*((3-4)*(5-6)))";
		convert(infixString);
	}
	
	
	public static void convert(String str){
		String infixString = str;
		String operatorString = "+-/*";
		String valueString = "0123456789";
		Stack<String> values = new Stack<String>();
		Stack<String> operators = new Stack<String>();
		for (int i = 0; i < infixString.length(); i++) {
			String temp = String.valueOf(infixString.charAt(i));
			if (infixString.charAt(i) == '(') {

			} else if (operatorString.contains(temp)) {
				operators.push(temp);
			} else if (valueString.contains(temp)) {
				values.push(temp);
			} else if (infixString.charAt(i) == ')') {
				String b = values.pop();
				String a = values.pop();
				String operator = operators.pop();
				values.push(a + b + operator);
			}
		}
		System.out.println(values.pop());
	
	}
}