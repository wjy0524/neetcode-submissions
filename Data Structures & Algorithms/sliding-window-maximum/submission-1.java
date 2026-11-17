class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        //pq에 [value, index]로 넣기
        //maxHeap of value
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for(int i=0; i<nums.length; i++){
            //pq에 넣기
            pq.offer(new int[]{nums[i], i});
            if(i >= k-1){
                //답 기록
                //최댓값 중에 범위를 벗어난 애들은 pq에서 버리기
                while(pq.peek()[1] < i-k+1){
                    pq.poll();
                }
                result[i-k+1] = pq.peek()[0];
            }

        }

        return result;
    }
}
