class Solution {
    //방향배열
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};

    boolean[][] visited;

    int maxArea;
    
    //n is the number of row
    //m is the number of col. 
    int n, m;

    public class Point{
        //attributes
        int row;
        int col;

        //constructor
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public boolean isRange(int row, int col){
        return row >= 0 && col >= 0 && row < n && col < m;
    }

    public void findArea(int startRow, int startCol, int[][] grid){
        int curArea = 0;
        //make queue using deque
        Point startPoint = new Point(startRow, startCol);
        //Queue
        Deque<Point> q = new ArrayDeque<>();
        q.push(startPoint);
        //mark it as visited
        visited[startRow][startCol] = true;
        curArea++;

        while(!q.isEmpty()){
            //take it off
            Point cur = q.pop();

            for(int dir=0; dir<4; dir++){
                int nxtRow = cur.row + dr[dir];
                int nxtCol = cur.col + dc[dir];
                if(isRange(nxtRow, nxtCol) && !visited[nxtRow][nxtCol] && grid[nxtRow][nxtCol] == 1){
                    //mark it as visited
                    visited[nxtRow][nxtCol] = true;
                    Point nxtPoint = new Point(nxtRow, nxtCol);
                    curArea++;
                    q.push(nxtPoint);
                }
                
            }

            
        }

        //update the maxArea
        maxArea = Math.max(maxArea, curArea);

        return;
    }

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        visited = new boolean[n][m];

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(visited[r][c]) continue;
                if(grid[r][c] == 1){
                    findArea(r, c, grid);
                }
            }
        }

        return maxArea;
    }
}
