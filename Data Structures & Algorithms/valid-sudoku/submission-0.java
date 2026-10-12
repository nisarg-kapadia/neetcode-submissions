class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int i=0;i<9;i++){

            for(int j=0;j<9;j++){
                if(board[i][j] == '.') continue;
                int cur = (int)(board[i][j] - '0') - 1;
                
                if(row[i][cur]) return false;
                row[i][cur] = true;

                if(col[j][cur]) return false;
                col[j][cur] = true;

                int idx = (i/3 * 3) + j/3;
                if(box[idx][cur]) return false;
                box[idx][cur] = true;


            }
        }

        return true;
    }
}
