class Solution {
    public boolean isValidSudoku(char[][] board) {
        //rules for valid sudoku board
        //Each row must contain the digits 1-9 without duplicates.
        //Each column must contain the digits 1-9 without duplicates.
        //Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.

        //so basically need to check for each column, each row, and each sub box
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        //have to make an actual set for each row, col, box
        for(int i=0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        //check it for each grid
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                char num = board[r][c];
                if(num == '.') continue;
                if(!rows[r].add(num)) return false;
                if(!cols[c].add(num)) return false;

                int boxIdx = r / 3 * 3 + c / 3;
                if(!boxes[boxIdx].add(num)) return false;
            }
        }

        return true;

    }
}
