package pl.misc.interviewstreet.arrays;

import java.util.ArrayList;

/**
 * <h4>
 * Merge Intervals
 * </h4>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 * <p>
 * Example 2:
 * <p>
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * Make sure the returned intervals are also sorted.
 * https://www.interviewbit.com/problems/merge-intervals/
 *
 * @author Pallav Jha
 * @version 1.0
 * @since 2/3/18
 */

class MergeIntervals {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        //Checking/Replacing the order
        if (newInterval.end < newInterval.start) {
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }

        //Blank Check
        if (intervals == null || intervals.size() == 0) {
            intervals = new ArrayList<>();
            intervals.add(newInterval);
            return intervals;
        }

        //If the given interval should be the first element
        if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }

        //If the given interval should be the last element
        if (newInterval.start > intervals.get(intervals.size() - 1).end) {
            intervals.add(newInterval);
            return intervals;
        }

        //If the given interval is greater than all the intervals
        if (newInterval.start <= intervals.get(0).start
                && intervals.get(intervals.size() - 1).end <= newInterval.end) {
            intervals = new ArrayList<>();
            intervals.add(newInterval);
            return intervals;
        }

        boolean mergeDone = false;
        ArrayList<Interval> returnList = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval previous = i > 0 ? intervals.get(i - 1) : null;
            Interval current = intervals.get(i);
            if (!mergeDone && (current.start >= newInterval.start
                    || (previous != null && current.start > newInterval.start && previous.end < newInterval.start)
                    || (current.start < newInterval.start && current.end >= newInterval.start))) {

                for (int j = i; j < intervals.size(); j++) {
                    Interval previousForEnd = j > 0 ? intervals.get(j - 1) : null;
                    Interval forEnd = intervals.get(j);
                    if (forEnd.end >= newInterval.end && forEnd.start < newInterval.end) {
                        Interval intervalToAdd = new Interval();
                        intervalToAdd.start = current.start < newInterval.start ? current.start : newInterval.start;
                        intervalToAdd.end = forEnd.end > newInterval.end ? forEnd.end : newInterval.end;
                        returnList.add(intervalToAdd);
                        i = j;
                        mergeDone = true;
                        break;
                    }
                    if (forEnd.start > newInterval.end && previousForEnd.end < forEnd.end) {
                        Interval intervalToAdd = new Interval();
                        intervalToAdd.start = current.start < newInterval.start ? current.start : newInterval.start;
                        intervalToAdd.end = newInterval.end;
                        returnList.add(intervalToAdd);
                        i = j - 1;
                        mergeDone = true;
                        break;
                    }
                    if (forEnd.end < newInterval.end && j == intervals.size() - 1) {
                        Interval intervalToAdd = new Interval();
                        intervalToAdd.start = current.start < newInterval.start ? current.start : newInterval.start;
                        intervalToAdd.end = newInterval.end;
                        returnList.add(intervalToAdd);
                        i = intervals.size();
                        mergeDone = true;
                        break;
                    }
                }
            } else {
                returnList.add(current);
            }
        }

        return returnList;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        System.out.println(insert(intervals, new Interval(2, 5)));


        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(8, 10));

        System.out.println(insert(intervals, new Interval(3, 6)));

        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));


        System.out.println(insert(intervals, new Interval(4, 9)));


        //A : [ (17032215, 17300041), (22368188, 22481642), (26324918, 27072635), (27313592, 27316602), (31866590, 31891391),
        //      (38724170, 38983286), (43693400, 44934170), (47043623, 51328762), (51561691, 52662807), (53831026, 61611247),
        //      (66163387, 68886608), (74664841, 80562561), (84819103, 84940788), (87986147, 88623498), (93943969, 99949547) ]
        //B : (10905624, 49527715)

        intervals = new ArrayList<>();
        intervals.add(new Interval(17032215, 17300041));
        intervals.add(new Interval(22368188, 22481642));
        intervals.add(new Interval(26324918, 27072635));
        intervals.add(new Interval(27313592, 27316602));
        intervals.add(new Interval(31866590, 31891391));
        intervals.add(new Interval(38724170, 38983286));
        intervals.add(new Interval(43693400, 44934170));
        intervals.add(new Interval(47043623, 51328762));
        intervals.add(new Interval(51561691, 52662807));
        intervals.add(new Interval(53831026, 61611247));
        intervals.add(new Interval(66163387, 68886608));
        intervals.add(new Interval(74664841, 80562561));
        intervals.add(new Interval(84819103, 84940788));
        intervals.add(new Interval(87986147, 88623498));
        intervals.add(new Interval(93943969, 99949547));


        System.out.println(insert(intervals, new Interval(10905624, 49527715)));

    }


    private MergeIntervals() {

    }
}
