class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];

        //elem (value, index)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> Integer.compare(b[0], a[0]));

        for(int i=0; i<nums.length; i++){
            pq.offer(new int[]{nums[i], i});

            //만약에 k개까지 읽었으면
            //result 채워넣기
            if(i >= k-1){
                while(pq.peek()[1] < i-k+1){
                    pq.poll();
                }
                result[i-k+1] = pq.peek()[0];
            }
        }
        return result;
    }
}
