class Solution {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        boolean[] inTree = new boolean[n];
        minDist[0] = 0;
        int res = 0;

        for (int step = 0; step < n; step++) {
            // 트리 밖에서 가장 가까운 점 고르기
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!inTree[i] && (u == -1 || minDist[i] < minDist[u])) u = i;
            }
            inTree[u] = true;
            res += minDist[u];

            // u를 넣었으니 나머지 점들의 최소 비용 갱신
            for (int v = 0; v < n; v++) {
                if (!inTree[v]) {
                    int d = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    minDist[v] = Math.min(minDist[v], d);
                }
            }
        }
        return res;
    }

}
