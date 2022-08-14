package graphs;

public class LargestIsland {
    private int dfs(int[][] grid, int currX, int currY) {
        if(grid[currX][currY] == 0) return 0;

        int ans = 1;
        grid[currX][currY] = 0;

        int[] x = {-1,-1,-1,0,0,1,1,1};
        int[] y = {-1,0,1,-1,1,-1,0,1};

        for(int i=0; i<x.length; i++) {
            int currPosX = currX + x[i];
            int currPosY = currY + y[i];

            if(currPosX>=0 && currPosX<grid.length && currPosY>=0 && currPosY<grid[currPosX].length && grid[currPosX][currPosY] == 1) {
                ans += dfs(grid, currPosX, currPosY);
            }
        }
        return ans;
    }
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int ans = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int curr = dfs(grid, i, j);
                    ans = Math.max(ans, curr);
                }
            }
        }
        return ans;
    }
}
