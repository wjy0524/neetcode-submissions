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
        //minHeap heap에 올라가 있는 미팅 시간중 가장 빨리 끝나는 애
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

        for(Interval inter : intervals){
            if(minHeap.isEmpty()){
                minHeap.offer(inter);
                continue;
            }

            Interval earliestEnd = minHeap.peek();
            //겹치면 추가한다
            //안겹치면 그냥 빼고 넣는다
            if(earliestEnd.end > inter.start){
                minHeap.offer(inter);
            }else{
                minHeap.poll();
                minHeap.offer(inter);
            }
        }

        return minHeap.size();
    }
}
