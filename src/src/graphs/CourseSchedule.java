package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseSchedule {
    private boolean isCycleStart(ArrayList<ArrayList<Integer>> adj, int curr, Map<Integer, Integer> map, int[] visited) {
        if (visited[curr] != -1) {
            if(map.containsKey(curr)) {
                return true;
            }
            return false;
        }
        visited[curr] = 0;

        for (int i : adj.get(curr)) {
            if (visited[i] == -1) {
                map.put(i,0);
                if(isCycleStart(adj, i, map, visited) == true) return true;
                map.remove(i);
            }
            else if(map.containsKey(i)) return true;
        }
        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        for (int i = 0; i < V; i++)
            visited[i] = -1;

        for (int i = 0; i < V; i++) {
            if (visited[i] == -1) {
                Map<Integer, Integer> path = new HashMap<>();
                path.put(i,0);
                if (isCycleStart(adj, i, path, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[] ans;
    int stackIndex;

    private void dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] isVisited) {
        isVisited[curr] = true;

        for (int i : adj.get(curr)) {
            if (isVisited[i] == false) {
                dfs(adj, i, isVisited);
            }
        }

        ans[stackIndex--] = curr;
    }

    private int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        ans = new int[V];
        stackIndex = V - 1;
        boolean[] isVisited = new boolean[V];
        for (int i = 0; i < V; i++)
            isVisited[i] = false;

        for (int i = 0; i < V; i++) {
            if (isVisited[i] == false) {
                dfs(adj, i, isVisited);
            }
        }
        return ans;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            arr.add(new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            ArrayList<Integer> temp = arr.get(prerequisites[i][1]);
            temp.add(prerequisites[i][0]);
            arr.set(prerequisites[i][1],temp);
        }

        if(isCycle(numCourses, arr)) {
            int[] ans = new int[0];
            return ans;
        }

        return topoSort(numCourses, arr);
    }
}
