package pl.misc.interviewstreet.arrays;

import java.util.ArrayList;

/**
 * @author pallav
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

        if (newInterval.end < newInterval.start) {
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }

        if (intervals == null || intervals.size() == 0) {
            intervals = new ArrayList<>();
            intervals.add(newInterval);
            return intervals;
        }

        if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }

        if (newInterval.start <= intervals.get(0).start
                && intervals.get(intervals.size() - 1).end <= newInterval.end) {
            intervals = new ArrayList<>();
            intervals.add(newInterval);
            return intervals;
        }


        if (newInterval.start > intervals.get(intervals.size() - 1).end) {
            intervals.add(newInterval);
            return intervals;
        }

        ArrayList<Interval> returnList = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            if (interval.start == newInterval.start
                    || interval.end == newInterval.start
                    || (interval.start < newInterval.start && interval.end > newInterval.start)) {
                Interval intervalForMerge = null;
                int indexPos = -1;
                for (int j = i + 1; j < intervals.size(); j++) {
                    Interval currInterval = intervals.get(j);
                    if (currInterval.start > newInterval.end) {
                        indexPos = j - 1;
                        break;
                    } else if (currInterval.start == newInterval.end
                            || currInterval.end == newInterval.end
                            || (currInterval.start < newInterval.end && interval.end > newInterval.end)) {
                        indexPos = j;
                        intervalForMerge = currInterval;
                        break;
                    }
                    if (j == intervals.size() - 1) {
                        indexPos = j;
                    }
                }
                if (intervalForMerge != null && indexPos > 0) {
                    Interval abc = new Interval();
                    abc.start = interval.start > newInterval.start ? newInterval.start : interval.start;
                    abc.end = intervalForMerge.end > newInterval.end ? intervalForMerge.end : newInterval.end;
                    returnList.add(abc);
                    i = indexPos;
                } else if (indexPos > -1) {
                    Interval abc = new Interval();
                    abc.start = interval.start > newInterval.start ? newInterval.start : interval.start;
                    abc.end = intervals.get(indexPos).end > newInterval.end ? intervals.get(indexPos).end : newInterval.end;
                    returnList.add(abc);
                    i = indexPos;
                }
            } else if (interval.start == newInterval.end
                    || interval.start < newInterval.end && interval.end > newInterval.end
                    || interval.end == newInterval.end) {

                Interval abc = new Interval();
                abc.start = interval.start > newInterval.start ? newInterval.start : interval.start;
                abc.end = interval.end > newInterval.end ? interval.end : newInterval.end;
                returnList.add(abc);

            } else if (interval.end < newInterval.start
                    && (i == intervals.size() - 1 || intervals.get(i + 1).start > newInterval.end)) {
                returnList.add(interval);
                returnList.add(newInterval);

            } else {
                returnList.add(interval);
            }
        }

        return returnList;

    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        System.out.println(insert(intervals, new Interval(2, 5)));

    }


    private MergeIntervals() {

    }
}
