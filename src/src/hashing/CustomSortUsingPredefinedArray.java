package hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CustomSortUsingPredefinedArray {
    public static int[] sortA1ByA2(int A11[], int N, int A2[], int M)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<M; i++) {
            if(!map.containsKey(A2[i])) map.put(A2[i],i);
        }
        Integer[] A1 = new Integer[N];
        for(int i=0; i<N; i++) A1[i] = A11[i];
        Arrays.sort(A1, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(!map.containsKey(a) && !map.containsKey(b)) {
                    return a-b;
                }
                if(!map.containsKey(a)) {
                    return 1;
                }
                if(!map.containsKey(b)) {
                    return -1;
                }
                if(map.get(a) > map.get(b)) {
                    return 1;
                }
                if(map.get(a) == map.get(b)) {
                    return 0;
                }
                return -1;
            }
        });
        for(int i=0; i<N; i++) A11[i] = A1[i];
        return A11;
    }
}
