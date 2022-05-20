package arrays.searchingAlgo;

public class SearchRowColumnSorted {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int currRow = 0;
        int currCol = col-1;
        while(currRow<row && currCol>=0) {
            if(matrix[currRow][currCol] == target) {
                return true;
            }
            if(matrix[currRow][currCol] > target) {
                currCol--;
            }
            else currRow++;
        }
        return false;
    }
}
