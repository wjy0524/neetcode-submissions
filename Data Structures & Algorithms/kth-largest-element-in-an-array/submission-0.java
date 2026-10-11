class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int n : nums){
            maxHeap.offer(n);
        }

        int answer = 0;
        
        for(int i=0; i<k; i++){
            answer = maxHeap.poll();
        }

        return answer;
    }
}
