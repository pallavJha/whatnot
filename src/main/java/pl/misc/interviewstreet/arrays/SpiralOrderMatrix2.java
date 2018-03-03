package pl.misc.interviewstreet.arrays;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author pallav
 * @version 1.0
 * @since 3/3/18
 */
public class SpiralOrderMatrix2 {

    private static class Interval {
        int x;
        int y;

        Interval(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Interval interval = (Interval) o;

            if (x != interval.x) {
                return false;
            }
            return y == interval.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }


    private static int[][] generateMatrix(int n) {
        Set<Interval> allLocations = new LinkedHashSet<>();
        allLocations.add(new Interval(0, 0));
        int startX = 0;
        int startY = 0;
        char incrIndex = 'Y';
        boolean incr = true;
        while (allLocations.size() != n * n) {
            if (incrIndex == 'Y') {
                if (incr) {
                    if (startY == n - 1 || allLocations.contains(new Interval(startX, startY + 1))) {
                        incrIndex = 'X';
                    } else {
                        startY++;
                        allLocations.add(new Interval(startX, startY));
                    }
                } else {
                    if (startY == 0 || allLocations.contains(new Interval(startX, startY - 1))) {
                        incrIndex = 'X';
                    } else {
                        startY--;
                        allLocations.add(new Interval(startX, startY));
                    }
                }
            }
            if (incrIndex == 'X') {
                if (incr) {
                    if (startX == n - 1 || allLocations.contains(new Interval(startX + 1, startY))) {
                        incrIndex = 'Y';
                        incr = false;
                    } else {
                        startX++;
                        allLocations.add(new Interval(startX, startY));
                    }
                } else {
                    if (startX == 0 || allLocations.contains(new Interval(startX - 1, startY))) {
                        incrIndex = 'Y';
                        incr = true;
                    } else {
                        startX--;
                        allLocations.add(new Interval(startX, startY));
                    }
                }
            }
            //System.out.println(allLocations);
        }
        int[][] arr = new int[n][n];
        ArrayList<Interval> intervals = new ArrayList<>(allLocations);
        for (int i = 1; i <= n * n; i++) {
            Interval interval = intervals.get(i - 1);
            arr[interval.x][interval.y] = i;
        }
        //System.out.println(Arrays.deepToString(arr));
        return arr;
    }


    public static void main(String[] args) {
        generateMatrix(3);
    }

}
