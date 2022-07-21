package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    static ArrayList<String> ans = new ArrayList<>();

    static boolean isValid(int x, int y, int n) {
        if(x>=0 && x<n && y>=0 && y<n) return true;
        return false;
    }

    static void func(int[][] m, List<Character> path, int currX, int currY) {
        if(currX == m.length-1 && currY == m[0].length-1) {
            ans.add(path.toString().replaceAll("[,\\s\\[\\]]", ""));
            return;
        }
        m[currX][currY] *= -1;

        if(isValid(currX-1, currY, m.length) && m[currX-1][currY] == 1) {
            path.add('U');
            func(m,path,currX-1,currY);
            path.remove(path.size()-1);
        }

        if(isValid(currX+1, currY, m.length) && m[currX+1][currY] == 1) {
            path.add('D');
            func(m,path,currX+1,currY);
            path.remove(path.size()-1);
        }

        if(isValid(currX, currY-1, m.length) && m[currX][currY-1] == 1) {
            path.add('L');
            func(m,path,currX,currY-1);
            path.remove(path.size()-1);
        }

        if(isValid(currX, currY+1, m.length) && m[currX][currY+1] == 1) {
            path.add('R');
            func(m,path,currX,currY+1);
            path.remove(path.size()-1);
        }

        m[currX][currY] *= -1;
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ans.clear();
        List<Character> path = new ArrayList<>();
        if(m[0][0] == 0) return ans;
        func(m,path,0,0);
        return ans;
    }
}
