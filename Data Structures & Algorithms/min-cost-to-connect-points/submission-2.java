class Solution {
    public int minCostConnectPoints(int[][] points) {
        //정석적이 prim's algorithm풀기
        int n = points.length;
        boolean[] visited = new boolean[n];

        //(dist, point idx)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});

        int minCost = 0;
        int cnt = 0;

        while(!pq.isEmpty() && cnt < n){
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];

            if(visited[node]) continue;

            visited[node] = true;
            minCost += cost;
            cnt++;

            for(int neigh=0; neigh<n; neigh++){
                if(visited[neigh]) continue;
                int dist = calcDist(points[node], points[neigh]);
                pq.offer(new int[]{dist, neigh});
            }
        }
        return minCost;
    }

    private int calcDist(int[] p1, int[] p2){
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }
}
