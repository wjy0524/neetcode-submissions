class Solution {
    boolean[][] located;
    List<List<String>> answer;

    List<String> boardToStringList(int n) {
        List<String> board = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            StringBuilder row = new StringBuilder();
            for (int c = 0; c < n; c++) {
                row.append(located[r][c] ? 'Q' : '.');
            }
            board.add(row.toString());
        }
        return board;
    }

    public boolean canLocate(int row, int col, int n){
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                if(located[r][c]){
                    if(r == row || c == col || Math.abs(r-row) == Math.abs(c-col)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void locateNQueens(int row, int n){
        if(row == n){
            answer.add(boardToStringList(n));
            return;
        }

        for(int c=0; c<n; c++){
            if(canLocate(row, c, n)){
                located[row][c] = true;
                locateNQueens(row+1, n);
                located[row][c] = false;
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        answer = new ArrayList<>();
        located = new boolean[n][n];  // n 크기로 동적 생성
        locateNQueens(0, n);
        return answer;
    }
}