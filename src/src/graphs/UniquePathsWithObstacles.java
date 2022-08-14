package graphs;

public class UniquePathsWithObstacles {
    int[][] dp = new int[105][105];

    private int dfs(int[][] obstacles, int currX, int currY) {
        //System.out.println("currX: " + currX + " currY: " + currY);
        //if(currX == 0 && currY == 0) return 2;
        if(dp[currX][currY] != -1) return dp[currX][currY];
        if(currX==obstacles.length-1 && currY==obstacles[0].length-1 && obstacles[currX][currY] == 0) {
            return dp[currX][currY] = 1;
        }

        if(obstacles[currX][currY] == 1) return dp[currX][currY] = 0;

        obstacles[currX][currY] = 1;

        int[] x = {0,1};
        int[] y = {1,0};
        int ans = 0;

        for(int i=0; i<x.length; i++) {
            int currPosX = currX + x[i];
            int currPosY = currY + y[i];

            if(currPosX>=0 && currPosX<obstacles.length && currPosY>=0 && currPosY<obstacles[0].length && obstacles[currPosX][currPosY] == 0) {
                ans += dfs(obstacles, currPosX, currPosY);
            }
        }

        obstacles[currX][currY] = 0;
        return dp[currX][currY] = ans;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        for(int i=0; i<=obstacleGrid.length; i++) for(int j=0; j<=obstacleGrid[0].length; j++) dp[i][j] = -1;
        return dfs(obstacleGrid,0,0);
    }
}
