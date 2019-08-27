package pl.misc.leetcode.stack;

import java.util.Stack;

/**
 * Baseball Game - LeetCode
 *
 * @author Pallav Jha
 * @apiNote https://leetcode.com/problems/baseball-game/
 * @since August 27, 2019
 */
public class BaseballGame {

    private static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String op : ops) {
            switch (op) {
                case "+":
                    // "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
                    int first = stack.pop();
                    int second = stack.pop();
                    int currentElem = first + second;
                    sum += currentElem;
                    stack.push(second);
                    stack.push(first);
                    stack.push(currentElem);
                    break;
                case "C":
                    // "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
                    sum -= stack.pop();
                    break;
                case "D":
                    // "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
                    first = stack.pop();
                    currentElem = first * 2;
                    sum += currentElem;
                    stack.push(first);
                    stack.push(currentElem);
                    break;
                default:
                    currentElem = Integer.parseInt(op);
                    sum += currentElem;
                    stack.push(currentElem);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] inputs = {
                {"5", "2", "C", "D", "+"},
                {"5", "-2", "4", "C", "D", "9", "+", "+"},
        };
        for (String[] input : inputs) {
            System.out.println(calPoints(input));
        }
    }
}
