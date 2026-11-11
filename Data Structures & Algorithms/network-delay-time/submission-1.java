class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //다익스타를 k를 start Node로 돌리면 각각의 dist는 k에서의 최소거리
        //돌리고도 여전히 초기화 무한이 남아있다면 그건 도달이 불가능하다는 소리
        int[] dist = new int[n+1]; // 1~n node 라서
        Arrays.fill(dist, Integer.MAX_VALUE);

        //times 기반으로 일단 graph를 만들어야한다
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : times){
            int startNode = edge[0];
            int endNode = edge[1];
            int weight = edge[2];
            graph.get(startNode).add(new int[]{endNode, weight});
        }

        //pq 만들기 ele = int[거리, vertext]
        //거리가 가까운 순으로 prioritized
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        //시작점 넣고 dist = 0으로 초기화
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
