package pl.misc.interviewbit.arrays;

import java.util.ArrayList;

/**
 * Interviewstreet Min Steps in Infinite Grid Solution
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * <pre>
 * (x,y) to
 * (x+1, y),
 * (x - 1, y),
 * (x, y+1),
 * (x, y-1),
 * (x-1, y-1),
 * (x+1,y+1),
 * (x-1,y+1),
 * (x+1,y-1)
 * </pre>
 * You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
 * <p>
 * Example :
 * <p>
 * Input : [(0, 0), (1, 1), (1, 2)]
 * Output : 2
 * It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 * <p>
 * This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.
 *
 * @author pallav
 * @version 1.0
 * @since 24/2/18
 */
public class MinStepsInInfiniteGrid {

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        int sum = 0;
        if (A.size() > 1) {
            for (int i = 1; i < A.size(); i++) {
                int tempSum = coverPoints(A.get(i - 1), B.get(i - 1), A.get(i), B.get(i));
                sum += tempSum;
            }
        }
        return sum;

    }

    private int coverPoints(int x1, int y1, int x2, int y2) {
        int steps = 0;
        if (x2 > x1 && y2 > y1) {
            while (x1 != x2 && y1 != y2) {
                x1++;
                y1++;
                steps++;
            }
            if (x1 == x2 && y1 != y2) {
                steps += Math.abs(y2 - y1);
            } else if (x1 != x2 && y1 == y2) {
                steps += Math.abs(x2 - x1);
            }
            return steps;
        } else if (x2 < x1 && y2 > y1) {
            while (x1 != x2 && y1 != y2) {
                x1--;
                y1++;
                steps++;
            }
            if (x1 == x2 && y1 != y2) {
                steps += Math.abs(y2 - y1);
            } else if (x1 != x2 && y1 == y2) {
                steps += Math.abs(x1 - x2);
            }
            return steps;
        } else if (x2 < x1 && y2 < y1) {
            while (x1 != x2 && y1 != y2) {
                x1--;
                y1--;
                steps++;
            }
            if (x1 == x2 && y1 != y2) {
                steps += Math.abs(y1 - y2);
            } else if (x1 != x2 && y1 == y2) {
                steps += Math.abs(x1 - x2);
            }
            return steps;
        } else if (x2 > x1 && y2 < y1) {
            while (x1 != x2 && y1 != y2) {
                x1++;
                y1--;
                steps++;
            }
            if (x1 == x2 && y1 != y2) {
                steps += Math.abs(y2 - y1);
            } else if (x1 != x2 && y1 == y2) {
                steps += Math.abs(x2 - x1);
            }
            return steps;
        } else if (x2 == x1 && y1 != y2) {
            steps = (y1 > y2) ? (y1 - y2) : (y2 - y1);
        } else if (x2 != x1 && y1 == y2) {
            steps = (x1 > x2) ? (x1 - x2) : (x2 - x1);
        }

        return steps;
    }
}

