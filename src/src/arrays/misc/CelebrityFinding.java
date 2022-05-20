package arrays.misc;

public class CelebrityFinding {
    public int celebrity(int M[][], int n)
    {
        // code here
        int x = 0, y = n-1;

        while(x<y) {
            if(M[x][y] == 1) {
                x++;
            }
            else y--;
        }
        for(int i=0; i<n; i++) {
            if(i==x) continue;
            if(M[x][i] == 1) return -1;
            if(M[i][x] == 0) return -1;
        }
        return x;
    }
}
