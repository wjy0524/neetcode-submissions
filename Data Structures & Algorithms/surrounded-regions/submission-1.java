class Solution {
    //understanding the probl
    //O가 상하좌우로 연결되어 border(테두리)까지 도달할 수 없으면, 그 O를 전부 X로 바꾼다
    //size of the board
    int n, m;

    boolean[][] visited;

    //dir array 
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};

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
        return row>=0 && col>=0 && row<n && col<m;
    }

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;

        visited = new boolean[n][m];

        Deque<Point> q = new ArrayDeque<>();

        //border에 있는 O에서 bfs돌려서 
        //다 돌리고 visited false인데 O인 애들을 다 x로 바꿔야해
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(r==0 || r==n-1 || c==0 || c==m-1){
                    if(board[r][c] == 'O'){
                        visited[r][c] = true;
                        q.offer(new Point(r, c));
                    }
                }
            }
        }

        while(!q.isEmpty()){
            Point cur = q.poll();
            int curRow = cur.row;
            int curCol = cur.col;

            for(int dir=0; dir<4; dir++){
                int nxtRow = curRow + dr[dir];
                int nxtCol = curCol + dc[dir];
                if(isRange(nxtRow, nxtCol) && !visited[nxtRow][nxtCol] && board[nxtRow][nxtCol] == 'O'){
                    visited[nxtRow][nxtCol] = true;
                    q.offer(new Point(nxtRow, nxtCol));
                }
            }
        }

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(!visited[r][c] && board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }
        

        
        return;

    }
}
