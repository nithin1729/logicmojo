package graphs;

import java.util.ArrayList;

public class CycleUnDirectedGraph {
    private boolean isCycleStart(ArrayList<ArrayList<Integer>> adj, int curr, int parent, int[] visited, int prev) {
        if(visited[curr] != -1) {
            if(visited[curr] == parent) return true;
            return false;
        }
        visited[curr] = parent;

        for(int i: adj.get(curr)) {
            if(i!=prev) {
                if(isCycleStart(adj, i, parent, visited, curr) == true) return true;
            }
        }
        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        for(int i=0; i<V; i++) visited[i] = -1;

        for(int i=0; i<V; i++) {
            if(visited[i] == -1) {
                if(isCycleStart(adj,i,i,visited,-1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
