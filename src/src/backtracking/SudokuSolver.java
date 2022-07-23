package backtracking;

public class SudokuSolver {
    private boolean isCharPossible(char[][] board, int row, int col, char ch) {
        for(int i=0; i<9; i++) if(board[row][i] == ch || board[i][col] == ch) return false;

        row = 3*(row/3);
        col = 3*(col/3);

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[row+i][col+j] == ch) return false;
            }
        }
        return true;
    }

    private boolean func(char[][] board, int count) {
        if(count==81) return true;
        int row = count/9;
        int col = count%9;

        if(board[row][col] != '.') return func(board, count+1);
        for(char ch = '1'; ch <= '9'; ch++) {
            if(isCharPossible(board, row, col, ch)) {
                board[row][col] = ch;
                boolean isPossible = func(board, count+1);
                if(isPossible) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        func(board,0);
    }
}
