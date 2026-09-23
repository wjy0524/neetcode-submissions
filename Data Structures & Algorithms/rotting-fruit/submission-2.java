class Solution {

    //방향배열
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};

    int n, m;
    //understanding the problem
    //0: empty cell
    //1: a fresh fruit
    //2: rotten fruit
    //flood fill problem
    int[][] visited;

    public boolean isRange(int row, int col){
        return row>=0 && col>=0 && row<n && col<m;
    }

    public int orangesRotting(int[][] grid) {
        int minMinute = 0;
        Deque<int[]> q = new ArrayDeque<>();
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m];

        //push all the rotten fruit points on the Queue
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == 2){
                    visited[r][c] = 1;
                    q.offer(new int[]{r,c});
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
                if(isRange(nxtRow, nxtCol) && visited[nxtRow][nxtCol]==0 && grid[nxtRow][nxtCol]==1){
                    visited[nxtRow][nxtCol] = visited[curRow][curCol]+1;
                    q.offer(new int[]{nxtRow, nxtCol});
                }
            }
        }

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(visited[r][c]>0){
                    minMinute = Math.max(minMinute, visited[r][c]);
                }
                //freshfruit이면서 visited[][] = 0이면 도달 못했다는거니까 retunr -1
                if(grid[r][c] == 1 && visited[r][c] == 0){
                    return -1;
                }
            }
        }
        

        return Math.max(minMinute - 1, 0);

    }
}
