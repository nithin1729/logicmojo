package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int currState = -1;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    int[] temp = new int[2];
                    temp[0] = i;
                    temp[1] = j;

                    queue.add(temp);
                }
            }
        }
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};
        while(queue.size() > 0) {
            currState++;
            int currSize = queue.size();
            for(int i=0; i<currSize; i++) {
                int[] curr = queue.poll();
                for(int j=0; j<x.length; j++) {
                    int currX = curr[0] + x[j];
                    int currY = curr[1] + y[j];

                    if(currX>=0 && currX<grid.length && currY>=0 && currY<grid[currX].length && grid[currX][currY] == 1) {
                        grid[currX][currY] = 2;
                        int[] temp = new int[2];
                        temp[0] = currX;
                        temp[1] = currY;

                        queue.add(temp);
                    }
                }
            }
        }

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }

        return Math.max(0, currState);
    }
}
