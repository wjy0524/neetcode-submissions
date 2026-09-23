class Solution {
    //방향배열
    //
    int n, m;
    int[] dr={-1, 0, 1, 0};
    int[] dc={0, -1, 0, 1};

    public boolean isRange(int row, int col){
        return row >=0 && col>=0 && row<n && col<m;
    }

    public void islandsAndTreasure(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        Deque<int[]> q = new ArrayDeque<>();
        //put all the starting points(treasure onto queue)
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == 0){
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for(int dir=0; dir<4; dir++){
                int nxtRow = curRow + dr[dir];
                int nxtCol = curCol + dc[dir];
                if(isRange(nxtRow, nxtCol)&&!visited[nxtRow][nxtCol]&&grid[nxtRow][nxtCol] > 0){
                    visited[nxtRow][nxtCol] = true;
                    grid[nxtRow][nxtCol] = grid[curRow][curCol] + 1;
                    q.offer(new int[]{nxtRow, nxtCol});
                }
            }
        }
    }
}
