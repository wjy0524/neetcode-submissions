class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int node=0; node<n; node++){
            adjList.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        int cnt = 1;
        boolean[] visited = new boolean[n];

        Deque<Integer> q = new ArrayDeque<>();
        visited[0] = true;
        q.offer(0);

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : adjList.get(cur)){
                if(!visited[nxt]){
                    cnt++;
                    visited[nxt] = true;
                    q.offer(nxt);
                }
            }
        }
        return cnt == n;

    }
}
