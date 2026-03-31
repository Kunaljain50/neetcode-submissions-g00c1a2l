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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1) {
            return true;
        }
        return solution(intervals);
    }

    public static boolean solution(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(interval -> interval.end));
        int limit = intervals.get(0).end;

        for(int i = 1; i<intervals.size(); i++) {
            System.out.println(intervals.get(i).start + ", "+ intervals.get(i).end);
            System.out.println("Limit : "+ limit);
            if(limit>intervals.get(i).start) {
                return false;
            }

            limit = intervals.get(i).end;
        }
        return true;
    }
}
