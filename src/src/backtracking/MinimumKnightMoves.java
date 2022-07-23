package backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumKnightMoves {
    class Point {
        int x;
        int y;

        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(obj==null || obj.getClass() != this.getClass()) return false;

            Point temp = (Point) obj;
            return temp.x==this.x && temp.y==this.y;
        }

        public int hashCode() {
            return this.x + this.y;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int knight(int A, int B, int C, int D, int E, int F) {
        if(C==E && D == F) return 0;
        Map<Point, Boolean> isVisited = new HashMap<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(C,D));
        isVisited.put(queue.peek(), true);
        int ans = 0;
        int[] x = {2,2,-2,-2,1,1,-1,-1};
        int[] y = {1,-1,1,-1,2,-2,2,-2};

        while(queue.size() > 0) {
            ans++;
            int currSize = queue.size();
            for(int i=0; i<currSize; i++) {
                Point curr = queue.remove();
                for(int j=0; j<8; j++) {
                    int currX = curr.x + x[j];
                    int currY = curr.y + y[j];

                    if(currX>0 && currX<=A && currY>0 && currY<=B && !isVisited.containsKey(new Point(currX, currY))) {
                        isVisited.put(new Point(currX, currY), true);
                        queue.add(new Point(currX, currY));

                        if(currX == E && currY == F) return ans;
                    }
                }
            }
        }
        return -1;
    }
}
