package arrays.traversal;
import java.util.List;
import java.util.ArrayList;

public class SpiralTraversalOfMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        int dir = 0;

        while(top<=bottom && left<=right) {
            switch(dir) {
                case 0:
                    for(int i=left; i<=right; i++) ans.add(matrix[top][i]);
                    top++;
                    dir++;
                    break;
                case 1:
                    for(int i=top; i<=bottom; i++) ans.add(matrix[i][right]);
                    right--;
                    dir++;
                    break;
                case 2:
                    for(int i=right; i>=left; i--) ans.add(matrix[bottom][i]);
                    bottom--;
                    dir++;
                    break;
                case 3:
                    for(int i=bottom; i>=top; i--) ans.add(matrix[i][left]);
                    left++;
                    dir=0;
                    break;
            }
        }
        return ans;
    }
}
