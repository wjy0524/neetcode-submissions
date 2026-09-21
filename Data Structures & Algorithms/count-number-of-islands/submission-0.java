class Solution {
    boolean[][] visited;
    int numOfIslands;

    //방향배열
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};

    public boolean isRange(int row, int col, int n, int m){
        return row >=0 && col>=0 && row<n && col<m;
    }
    
    public void findIsland(char[][]grid, int startRow, int startCol, int n, int m){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while(!q.isEmpty()){
            int[] curPoint = q.pop();
            int curRow = curPoint[0];
            int curCol = curPoint[1];

            for(int dir=0; dir<4; dir++){
                int nxtRow = curRow + dr[dir];
                int nxtCol = curCol + dc[dir];
                if(isRange(nxtRow, nxtCol, n, m) && !visited[nxtRow][nxtCol] && grid[nxtRow][nxtCol] == '1'){
                    visited[nxtRow][nxtCol] = true;
                    q.add(new int[]{nxtRow, nxtCol});
                }
            }
        }

        numOfIslands++;

        return;
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];
    
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c] == '1' && !visited[r][c]){
                    findIsland(grid, r, c, n, m);
                }
            }
        }

        return numOfIslands;

    }
}
