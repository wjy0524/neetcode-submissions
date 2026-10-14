class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.offer(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        while(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
