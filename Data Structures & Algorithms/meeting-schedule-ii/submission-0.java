/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        return solution(intervals);
    }

    public static int solution(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(interval -> interval.end));
        int limit = intervals.get(0).end;
        int count = 1;

        for(int i = 1; i<intervals.size(); i++) {
            if(limit>intervals.get(i).start) {
                count++;
            }

            limit = intervals.get(i).end;
        }
        return count;
    }
}
