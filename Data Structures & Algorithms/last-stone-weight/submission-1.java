class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(x == y){
                continue;
            }else{
                maxHeap.offer(y-x);
            }
        }

        if(maxHeap.isEmpty()){
            return 0;
        }else{
            return maxHeap.poll();
        }
    }
}
