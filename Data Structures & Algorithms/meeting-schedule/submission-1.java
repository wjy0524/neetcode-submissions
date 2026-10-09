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

        for(Interval inter : intervals){
            if(result.isEmpty()){
                result.add(inter);
                continue;
            }
            Interval last = result.get(result.size()-1);
            if(last.end <= inter.start){
                result.add(inter);
            }else{
                return false;
            }
        }

        return true;
    }
}
