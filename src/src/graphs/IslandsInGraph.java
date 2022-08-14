package graphs;

public class IslandsInGraph {
    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        int[] x = {-1,1,0,0};
        int[] y = {0,0,1,-1};

        for(int i=0; i<x.length; i++) {
            int currX = row + x[i];
            int currY = col + y[i];

            if(currX>=0 && currX<grid.length && currY>=0 && currY<grid[currX].length && grid[currX][currY] == '1') {
                dfs(grid, currX, currY);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
}
