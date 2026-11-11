class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        //graph를 만들자
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        //graph를 채워놓자
        for(int[] edge : times){
            int startNode = edge[0];
            int endNode = edge[1];
            int weight = edge[2];
            graph.get(startNode).add(new int[]{endNode, weight});
        }
        //(dist, vertex)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        dist[k] = 0;
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curDist = cur[0];
            int curNode = cur[1];
            if(curDist > dist[curNode]) continue;

            for(int[] edge : graph.get(curNode)){
                int nxtNode = edge[0];
                int weight = edge[1];
                if(curDist + weight < dist[nxtNode]){
                    dist[nxtNode] = curDist + weight;
                    pq.offer(new int[]{dist[nxtNode], nxtNode});
                }
            }
        }
        int minTime = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime, dist[i]);
        }

        return minTime;
    }
}
