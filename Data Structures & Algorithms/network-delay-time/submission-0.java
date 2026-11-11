class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //ui(start node), vi(arrive node), ti(weight)
        //k (origin node)
        //goal of the program: min sum of weights to traverse the graph
        //then have to use dijkstra
        //dijstra 첫번째 모든 노드의 dist를 무한으로 초기화 하기
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        //times 기반으로 그래프 그리기
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<times.length; i++){
            int startNode = times[i][0];
            int arrivNode = times[i][1];
            int time = times[i][2];
            graph.get(startNode).add(new int[]{arrivNode, time});
        }

        //pq 만들기 (distance, node)
        //거리가 가까운 순서대로
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        //pq에 origin node 넣기
        pq.offer(new int[]{0, k});
        //시작node dist = 0
        dist[k] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curDist = cur[0];
            int curNode = cur[1];
            //현재 거리가 지금까지 정립된 거리보다 길 시 그냥 skip
            if(curDist > dist[curNode]) continue;

            for(int[] edge : graph.get(curNode)){
                int nxtNode = edge[0];
                int time = edge[1];
                //curDist + time < dist[nxtNode] 일때만 업뎃
                if(curDist + time < dist[nxtNode]){
                    dist[nxtNode] = curDist + time;
                    pq.offer(new int[]{dist[nxtNode], nxtNode});
                }
            }
        }

        int minTime = 0;
        for(int i=1; i<=n; i++){
            //도달하지 못한 노드가 있다면 return -1
            if (dist[i] == Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime, dist[i]);
        }

        return minTime;

    }
}
