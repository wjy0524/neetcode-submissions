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
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        List<Interval> result = new ArrayList<>();
        for(Interval interval : intervals){
            if(result.isEmpty()){
                result.add(interval);
                continue;
            }
            Interval last = result.get(result.size()-1);
            if(interval.start < last.end){
                return false;
            }else{
                result.add(interval);
            }
        }

        return true;
    }
}
