/**
 * Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.
 */

// ********* 225 ************

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {

  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    ArrayList<Interval> newList = new ArrayList<Interval>();

    Comparator<Interval> comparator = new Comparator<Interval>() {

      @Override
      public int compare(Interval first, Interval second) {
        return first.start - second.start;
      }
    };

    intervals.sort(comparator);

    newList.add(intervals.get(0));

    for (int x = 0; x < intervals.size(); x++) {
      int finalStart = newList.get(newList.size() - 1).start;
      int endStart = newList.get(newList.size() - 1).end;
      int newStart = intervals.get(x).start;
      int newEnd = intervals.get(x).end;

      if (endStart >= newStart) {
        newEnd = Math.max(endStart, newEnd);
        Interval newInterval = new Interval(finalStart, newEnd);
        newList.set(newList.size() - 1, newInterval);
      } else {
        newList.add(intervals.get(x));
      }
    }

    newList.sort(comparator);

    return newList;
  }
}
