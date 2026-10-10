class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        //valid tree가 되려면 circle 없어야함
        //bfs 돌면서 visited check하고 방문했던데 또 돌면 그때 return false
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        //offer the root onto Queue
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            //since it is undirecitonal
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        q.offer(0);
        visited[0] = true;

        int cnt = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : adjList.get(cur)){
                if(!visited[nxt]){
                    visited[nxt] = true;
                    cnt++;
                    q.offer(nxt);
                }
            }
        }

        return cnt == n;

    }
}
