class Solution {
    public int minCostConnectPoints(int[][] points) {
        //n is the number of points
        int n = points.length;
        //make visited 
        boolean[] visited = new boolean[n];
        //현재 방문 하지 않은 점중 가장 가까운 거리 minDist[i] i로 부터
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        int totalCost = 0;

        //시작점은 0
        minDist[0] = 0;

        for(int i=0; i<n; i++){
            //nxtNode
            int nxtNode = -1;
            //find the closest unvisited node(which will be our next node)
            for(int j=0; j<n; j++){
                if(!visited[j] && (nxtNode == -1 || minDist[j] < minDist[nxtNode])){
                    nxtNode = j;
                }
            }

            //mark it as visited
            visited[nxtNode] = true;
            totalCost += minDist[nxtNode];

            //update the distances
            for(int v=0; v<n; v++){
                if(!visited[v]){
                    int dist = calcDist(points[nxtNode], points[v]);
                    minDist[v] = Math.min(dist, minDist[v]);
                }
            }
        }

        return totalCost;

    }

    private int calcDist(int[] p1, int[] p2){
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }
}
