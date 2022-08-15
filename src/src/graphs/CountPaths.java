package graphs;

import java.util.ArrayList;
import java.util.List;

public class CountPaths {
    int ans;

    private void dfs(List<List<Integer>> paths, int curr, int dest, boolean[] visited) {
        if(curr==dest) {
            ans++;
            return;
        }

        visited[curr] = true;
        for(int i: paths.get(curr)) {
            if(visited[i] == false) {
                dfs(paths,i,dest,visited);
            }
        }
        visited[curr] = false;
    }

    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        ans = 0;
        List<List<Integer>> paths = new ArrayList<>();
        for(int i=0; i<n; i++) paths.add(new ArrayList<>());

        for(int i=0; i<edges.length; i++) {
            paths.get(edges[i][0]).add(edges[i][1]);
        }

        boolean[] visited = new boolean[n];
        for(int i=0; i<visited.length; i++) visited[i] = false;

        dfs(paths, s, d, visited);
        return ans;
    }
}
