package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    List<List<String>> ans;

    private void updateBoard(int[][] board, int currRow, int currCol, int value) {
        int[] x = {-1,0,1};
        int[] y = {-1,0,1};

        for(int i=0; i<x.length; i++) {
            for(int j=0; j<y.length; j++) {
                if(x[i]!= 0 || y[j]!= 0) {
                    int currX = currRow;
                    int currY = currCol;

                    while(currX>=0 && currX<board.length && currY>=0 && currY<board[currX].length) {
                        board[currX][currY] += value;
                        currX += x[i];
                        currY += y[j];
                    }
                }
            }
        }

        board[currRow][currCol] -= 8*value;
    }

    private void func(int[][] board, int row) {
        if(row == board.length) {
            List<String> curr = new ArrayList<>();
            for(int i=0; i<board.length; i++) {
                String temp = "";
                for(int j=0; j<board[i].length; j++) {
                    if(board[i][j]==0) temp = temp + 'Q';
                    else temp = temp + '.';
                }
                curr.add(temp);
            }
            ans.add(curr);
            return;
        }
        for(int i=0; i<board[row].length; i++) {
            if(board[row][i] == 0) {
                updateBoard(board, row, i, 1);
                func(board, row+1);
                updateBoard(board, row, i, -1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) board[i][j] = 0;
        func(board,0);
        return ans;
    }
}
