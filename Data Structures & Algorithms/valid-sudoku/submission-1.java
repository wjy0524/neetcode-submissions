class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Set arrays for each row, col, box
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        //실질적인 HashSet object만들기
        for(int i=0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        //iterate through each grid on sudoku board
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                char num = board[r][c];
                if(num == '.') continue; //skimplements
                if(!rows[r].add(num)) return false;
                if(!cols[c].add(num)) return false;

                int boxIdx = r / 3 * 3 + c / 3;
                if(!boxes[boxIdx].add(num)) return false;
            }
        }
        return true;
    }
}
