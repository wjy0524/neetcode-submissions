class Solution {
    //n is the row
    //m is the col 
    int m, n;
    //방향배열
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    int[][] visited;

    public boolean isRange(int row, int col){
        return row >=0 && col>=0 && row<n && col<m;
    }

    public void reset(){
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                visited[r][c] = -1;
            }
        }
    }

    public void findPath(int startRow, int startCol, int[][]grid){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = 0;
        
        while(!q.isEmpty()){
            int[] curPoint = q.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];

            for(int dir=0; dir<4; dir++){
                int nxtRow = curRow + dr[dir];
                int nxtCol = curCol + dc[dir];
                if(isRange(nxtRow, nxtCol) && visited[nxtRow][nxtCol] == -1 && grid[nxtRow][nxtCol] > 0){
                    visited[nxtRow][nxtCol] = visited[curRow][curCol] + 1;
                    grid[nxtRow][nxtCol] = Math.min(grid[nxtRow][nxtCol],visited[nxtRow][nxtCol]);
                    q.offer(new int[]{nxtRow, nxtCol});
                }
            }
        }
    }


    public void islandsAndTreasure(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        visited = new int[n][m];
        //start point should be treasure
        //every running bfs, visited has to be 초기화
        //그리고 update 할때마다 값 비교 해줘야해
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                reset();
                if(grid[r][c] == 0){
                    findPath(r, c, grid);
                }
            }
        }

        return;

    }
}
