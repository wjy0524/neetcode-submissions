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

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

        for(Interval inter : intervals){
            if(minHeap.isEmpty()){
                minHeap.offer(inter);
                continue;
            }

            Interval earliestEnd = minHeap.peek();
            if(earliestEnd.end <= inter.start){
                minHeap.poll();
                minHeap.offer(inter);
            }else{
                minHeap.offer(inter);
            }
        }

        return minHeap.size();

    }
}
