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
        /*1. 시작 시간 기준으로 회의 정렬
        2. 회의를 하나씩 보면서:
            - 가장 일찍 비는 방(heap.peek())이 이 회의 시작 전에 비었나?
                ✅ 비었음 → 그 방 재사용 → poll() (그 방의 이전 끝 시간 제거)
            - 이 회의의 끝 시간을 heap에 offer()
        3. 마지막에 heap의 크기 = 필요한 회의실 수*/

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
