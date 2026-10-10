class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        int answer = 0;

        Deque<Integer> q = new ArrayDeque<>();

        for(int node=0; node<n; node++){
            if(!visited[node]){
                answer++;
                q.offer(node);
                visited[node] = true;
                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(int nxt : adjList.get(cur)){
                        if(!visited[nxt]){
                            q.offer(nxt);
                            visited[nxt] = true;
                        }
                    }
                }
            }   
        }

        return answer;
    }
}
