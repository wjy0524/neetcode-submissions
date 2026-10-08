class Solution {

    //방향배열
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    
    int n, m;
    boolean[][] visited;

    public boolean isRange(int r, int c){
        return r>=0 && c>=0 && r<n && c<m;
    }

    public void findIsland(char[][] grid, int row, int col){
        Deque<int[]> q = new ArrayDeque<>();
        visited[row][col] = true;
        q.offer(new int[]{row, col});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for(int dir=0; dir<4; dir++){
                int nxtRow = curRow + dr[dir];
                int nxtCol = curCol + dc[dir];
                if(isRange(nxtRow, nxtCol) && !visited[nxtRow][nxtCol] && grid[nxtRow][nxtCol] == '1'){
                    //mark it as visited
                    visited[nxtRow][nxtCol] = true;
                    q.offer(new int[]{nxtRow, nxtCol});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int numOfIslands = 0;

        visited = new boolean[n][m];

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(!visited[r][c] && grid[r][c] == '1'){
                    findIsland(grid, r, c);
                    numOfIslands++;
                }
            }
        }


        return numOfIslands;
    }
}
