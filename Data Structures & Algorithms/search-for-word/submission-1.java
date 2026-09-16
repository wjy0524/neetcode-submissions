class Solution {
    //방향 배열
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};

    int[][] visited;

    StringBuilder curString;
    boolean isExist;

    public boolean isRange(int row, int col, char[][] board){
        return row >= 0 && col >=0 && row < board.length && col < board[0].length;
    }

    public void wordExist(char[][] board, String word, int currSelected, int curRow, int curCol){
        //base case if num of currSelected == word.length then check if curString == word
        if(isExist) return;

        if(currSelected == word.length()){
            isExist = true;
            return;
        }

        for(int dir=0; dir<4; dir++){
            int nxtRow = curRow + dr[dir];
            int nxtCol = curCol + dc[dir];
            //if it hasn't been visited and in the range
            if(isRange(nxtRow, nxtCol, board) && visited[nxtRow][nxtCol] == 0 && board[nxtRow][nxtCol] == word.charAt(currSelected)){
                //mark it as visited
                visited[nxtRow][nxtCol] = 1;
                //add it to the String
                curString.append(board[nxtRow][nxtCol]);
                wordExist(board, word, currSelected + 1, nxtRow, nxtCol);
                curString.deleteCharAt(curString.length()-1);
                //unmark it as visited
                visited[nxtRow][nxtCol] = 0;
            }
            
        }
    }
    
    public boolean exist(char[][] board, String word) {
        curString = new StringBuilder();

        visited = new int[board.length][board[0].length];

        for(int r=0; r<board.length; r++){
            if(isExist) break;
            for(int c=0; c<board[0].length; c++){
                if(isExist) break;
                //pruning, 첫글자 틀리면 볼필요도 없어
                if(board[r][c] == word.charAt(0)){  // 첫 글자 확인!
                visited[r][c] = 1;                // 시작점 방문 표시!
                curString.append(board[r][c]);    // 시작점 글자 추가!
            
                wordExist(board, word, 1, r, c);  // currSelected=1부터 (이미 1글자 처리했으니)
                curString.deleteCharAt(curString.length()-1);  // 되돌리기
                visited[r][c] = 0;
            }
            }
        } 
        return isExist;
    }
}
