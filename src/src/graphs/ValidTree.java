package graphs;

import java.util.ArrayList;
import java.util.List;

public class ValidTree {
    private boolean isCycleStarted(List<List<Integer>> adj, int curr, int parent, int[] visited, int prev) {
        if(visited[curr] != -1) {
            if(visited[curr] == parent) return true;
            return false;
        }
        visited[curr] = parent;

        for(int i: adj.get(curr)) {
            if(i!=prev) {
                if(isCycleStarted(adj,i,parent,visited,curr)) return true;
            }
        }
        return false;
    }
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<Integer>());

        for(int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] visited = new int[n];
        for(int i=0; i<n; i++) visited[i] = -1;

        boolean isCyclic = isCycleStarted(adj,0,0,visited,-1);

        if(isCyclic) return false;
        for(int i=0; i<n; i++) if(visited[i] == -1) return false;
        return true;
    }
}
