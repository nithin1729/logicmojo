package graphs;

import java.util.ArrayList;
import java.util.List;

public class SourceDestinationPaths {
    List<List<Integer>> ans = new ArrayList<>();

    private void dfs(int[][] graph, int currIndex, List<Integer> currPath) {
        currPath.add(currIndex);
        if(currIndex == graph.length-1) {
            ans.add(new ArrayList<>(currPath));
            currPath.remove(currPath.size()-1);
            return;
        }

        for(int i=0; i<graph[currIndex].length; i++) {
            dfs(graph, graph[currIndex][i], currPath);
        }
        currPath.remove(currPath.size()-1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans.clear();
        List<Integer> curr = new ArrayList<>();
        dfs(graph,0,curr);
        return ans;
    }
}
