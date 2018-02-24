package pl.misc.interviewstreet.arrays;

import java.util.ArrayList;

/**
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

