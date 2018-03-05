package com.ny.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ny
 * @Date: Created in 11:24 2018/3/5 0005
 */
public class InsertInterval {
    static class Interval {
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
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i, start = newInterval.start, end = newInterval.end, len = intervals.size();
        for (i = 0; i < len; i++) {
            if (intervals.get(i).end < start) result.add(new Interval(intervals.get(i).start, intervals.get(i).end));
            else break;
        }
        if (i < len)
            start = Math.min(intervals.get(i).start, start);
        for (; i < len; i++) {
            //考虑边界
            if (end >= intervals.get(i).start) {
                end = Math.max(intervals.get(i).end, end);
            } else {
                break;
            }
        }
        result.add(new Interval(start, end));
        for (; i < len; i++) {
            result.add(new Interval(intervals.get(i).start, intervals.get(i).end));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(5, 7));
        list.add(new Interval(8, 9));
        list.add(new Interval(12, 15));
        insert(list, new Interval(8, 18));
    }
}
