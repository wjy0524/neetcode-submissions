class Solution {
    //n is the size of the row, m is the size of col 
    int n, m;
    int[][] visited;
    //방향배열
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};

    private boolean isRange(int r, int c){
        return r>=0 && c>=0 && r<n && c<m;
    }

    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        n = grid.length;
        m = grid[0].length;
        int numOfFresh = 0;
        visited = new int[n][m];
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                visited[r][c] = -1;
                if(grid[r][c] == 2){
                    visited[r][c] = 0;
                    q.offer(new int[]{r, c});  
                }else if(grid[r][c] == 1){
                    numOfFresh++;
                }
            }
        }

        if(numOfFresh == 0) return 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for(int dir=0; dir<4; dir++){
                int nxtRow = curRow + dr[dir];
                int nxtCol = curCol + dc[dir];
                if(isRange(nxtRow, nxtCol) && visited[nxtRow][nxtCol] == -1 && grid[nxtRow][nxtCol] == 1){
                    visited[nxtRow][nxtCol] = visited[curRow][curCol] + 1;
                    numOfFresh--;
                    if(numOfFresh == 0){
                        return visited[nxtRow][nxtCol];
                    }
                    q.offer(new int[]{nxtRow, nxtCol});
                }
            }
        }

        return -1;
    }
}
