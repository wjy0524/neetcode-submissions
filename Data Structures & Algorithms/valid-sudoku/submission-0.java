class Solution {
    public boolean isValidSudoku(char[][] board) {
        //for each row and column, make a hashSet
        //Set array를 만듬
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        //각 row, col, box마다 실질적인 HashSet 객체를 만들어야함
        for(int i=0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        //now have to iterate through each grid on sudoku map
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                char num = board[r][c];
                //.이면 skip
                if(num == '.') continue;
                //row, col, box index 구하기
                int rowIdx = r / 3;
                int colIdx = c / 3;
                int boxIdx = rowIdx * 3 + colIdx;
                if(!rows[r].add(num)) return false;
                if(!cols[c].add(num)) return false;
                if(!boxes[boxIdx].add(num)) return false;
            }
        }

        return true;
    }
}
