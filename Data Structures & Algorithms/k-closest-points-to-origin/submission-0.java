class Solution {
    public int dist(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        
        //make max heap
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(dist(b), dist(a)));

        for(int[] pt : points){
            //일단 넣고
            maxHeap.offer(pt);
            //k개 이상이면 한개 빼기
            if(maxHeap.size() > k) maxHeap.poll();
        }

        for(int i=0; i<k; i++){
            result[i] = maxHeap.poll();
        }

        return result;

    }
}
