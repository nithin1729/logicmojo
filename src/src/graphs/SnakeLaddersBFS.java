package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeLaddersBFS {
    static int minThrow(int N, int arr[]){
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i+=2) {
            map.put(arr[i], arr[i+1]);
        }
        int total = 30;
        boolean[] visited = new boolean[total+1];
        for(int i=1; i<=total; i++) visited[i] = false;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int currRoll = -1;
        while(queue.size() > 0) {
            currRoll++;
            int currSize = queue.size();
            for(int j=0; j<currSize; j++) {
                int num = queue.poll();
                if(num == total) return currRoll;

                for(int i=1; i<=6 && num+i<=total; i++) {
                    int val = num + i;
                    if(map.containsKey(num + i)) {
                        val = map.get(num + i);
                    }
                    if(visited[val] == false) {
                        visited[val] = true;
                        queue.add(val);
                    }
                }
            }
        }

        return 30;
    }
}
