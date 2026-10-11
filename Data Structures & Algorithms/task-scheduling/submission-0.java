class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> cnt = new HashMap<>();
        for(char task : tasks){
            cnt.put(task, cnt.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int count : cnt.values()) {
            maxHeap.offer(count);
        }
        Deque<int[]> cooldown = new ArrayDeque<>();

        /*time = 0
while (heap이나 cooldown이 비어있지 않은 동안):
    time++
    1) heap이 비어있지 않으면:
         count = heap.poll() - 1
         count > 0 이면 cooldown에 {count, time + n} 추가
    2) cooldown의 맨 앞 원소의 사용 가능 시간 == time 이면:
         꺼내서 heap에 다시 넣기
return time
*/
        int time = 0;
        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll() - 1;
                if(count>0){
                    cooldown.offer(new int[]{count, time+n});
                }
            }
            if(!cooldown.isEmpty() && cooldown.peek()[1] == time){
                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        return time;
    }
}
