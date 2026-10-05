class Solution {
    public int dist(int[] pt){
        return pt[0] * pt[0] + pt[1]*pt[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        //maxHeap으로 k번 유지하기
        int[][] result = new int[k][2];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(dist(b), dist(a)));

        for(int[] pt : points){
            maxHeap.offer(pt);
            if(maxHeap.size() > k) maxHeap.poll();
        }

        for(int i=0; i<k; i++){
            result[i] = maxHeap.poll();

        }

        return result;

    }
}
