class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //understanding the problem first
        //n is the number of airports (labeled from 0 to n-1)
        //first I would make graph 
        //I would use dijkstra's algo to solve this question but with limit of k edges
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : flights){
            int from = edge[0];
            int to = edge[1];
            int price = edge[2];
            graph.get(from).add(new int[]{to, price});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        //dist, numOfEdges, node
        pq.offer(new int[]{0, 0, src});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curCost = cur[0];
            int curFlightNum = cur[1];
            int curNode = cur[2];

            if (curNode == dst) return curCost;
            if(curFlightNum > k) continue;
            if (curFlightNum >= dist[curNode]) continue;  // 더 싸고 엣지도 적은 상태로 이미 처리함
            dist[curNode] = curFlightNum;

            for (int[] e : graph.get(curNode)) {
                pq.offer(new int[]{curCost + e[1], curFlightNum + 1, e[0]});
            }
        }
        
        return -1;

    }
}
