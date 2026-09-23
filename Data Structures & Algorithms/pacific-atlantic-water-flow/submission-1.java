class Solution {
    //understanding 
    //heights[r][c]: height above sea level at (r, c)
    //water flow rules
    //Water can flow in four directions (up, down, left, or right) from a cell          
    //to a neighboring cell with height equal or lower.

    //n is row m is col 
    int n, m;
    //dir array 
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    //정답
    List<List<Integer>> waters;
    boolean[][] pacificVisited;
    boolean[][] atlanticVisited;

    public boolean isRange(int row, int col){
        return row>=0 && col>=0 && row<n && col<m;
    }

    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        waters = new ArrayList<>();
        n = heights.length;
        m = heights[0].length;

        pacificVisited = new boolean[n][m];
        atlanticVisited = new boolean[n][m];

        Deque<int[]> q1 = new ArrayDeque<>();
        Deque<int[]> q2 = new ArrayDeque<>();

        //q에 다 올려놓기
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                //pacific
                if(r==0 || c==0){
                    pacificVisited[r][c] = true;
                    q1.offer(new int[]{r, c});
                }
                //atlantic
                if(r==n-1 || c==m-1){
                    atlanticVisited[r][c] = true;
                    q2.offer(new int[]{r,c});
                }
                
            }
        }

        while(!q1.isEmpty()){
            int[] curPoint = q1.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];

            for(int dir=0; dir<4; dir++){
                int nxtRow = curRow + dr[dir];
                int nxtCol = curCol + dc[dir];
                if(isRange(nxtRow, nxtCol) && !pacificVisited[nxtRow][nxtCol] && heights[nxtRow][nxtCol] >= heights[curRow][curCol]){
                    pacificVisited[nxtRow][nxtCol] = true;
                    q1.offer(new int[]{nxtRow, nxtCol});
                }

            }
        }

        while(!q2.isEmpty()){
            int[] cPoint = q2.poll();
            int cRow = cPoint[0];
            int cCol = cPoint[1];

            for(int dir=0; dir<4; dir++){
                int nRow = cRow + dr[dir];
                int nCol = cCol + dc[dir];
                if(isRange(nRow, nCol) && !atlanticVisited[nRow][nCol] && heights[nRow][nCol] >= heights[cRow][cCol]){
                    atlanticVisited[nRow][nCol] = true;
                    q2.offer(new int[]{nRow, nCol});
                }

            }
        }

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                //둘다 가능하다면
                if(pacificVisited[r][c] && atlanticVisited[r][c]){
                    List<Integer> canPoint = new ArrayList<>();
                    canPoint.add(r);
                    canPoint.add(c);
                    waters.add(canPoint);
                }
            }
        }
        return waters;
    }
}
