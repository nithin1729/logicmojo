package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(queue.size() > 0) {
            int curr = queue.poll();
            ans.add(curr);
            for(int i=0; i<adj.get(curr).size(); i++) {
                if(visited[adj.get(curr).get(i)] == false) {
                    visited[adj.get(curr).get(i)] = true;
                    queue.add(adj.get(curr).get(i));
                }
            }
        }
        return ans;
    }
}
