package arrays.greedy;

public class CandiesDistribute {
    public int candy(int[] ratings) {
        int leftArr[] = new int[ratings.length];
        leftArr[0] = 1;
        for(int i=1; i<ratings.length; i++) leftArr[i] = ratings[i-1]<ratings[i]? 1+leftArr[i-1]:1;
        int[] rightArr = new int[ratings.length];
        rightArr[ratings.length-1] = 1;
        for(int i=ratings.length-2; i>=0; i--) rightArr[i] = ratings[i]>ratings[i+1]?1+rightArr[i+1]:1;
        int ans = 0;
        for(int i=0; i<ratings.length; i++) ans += Math.max(leftArr[i], rightArr[i]);
        return ans;
    }
}
