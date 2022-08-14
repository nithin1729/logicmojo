package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] ans = new int[adj.size()];
        for(int i=0; i<ans.length; i++) {
            ans[i] = 1000005;
        }

        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(
                new Comparator<ArrayList<Integer>>() {
                    @Override
                    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                        if(o1.get(1) < o2.get(1)) return -1;
                        if(o1.get(1) == o2.get(1)) return 0;
                        return 1;
                    }
                });


        ans[S] = 0;
        ArrayList<Integer> curr = new ArrayList<>();
        curr.add(S);
        curr.add(0);
        pq.add(curr);

        Map<Integer, Boolean> visited = new HashMap<>();

        while(!pq.isEmpty() && visited.size() < ans.length) {
            ArrayList<Integer> currNode = pq.poll();
            if(visited.containsKey(currNode.get(0))) {
                continue;
            }
            visited.put(currNode.get(0), true);

            int node = currNode.get(0);
            int dist = currNode.get(1);

            for(int i=0; i<adj.get(node).size(); i++) {
                int currrNode = adj.get(node).get(i).get(0);
                int currrDist = adj.get(node).get(i).get(1);

                if(ans[currrNode] > dist + currrDist) {
                    ans[currrNode] = dist + currrDist;

                    pq.add(new ArrayList<Integer>(){
                        {
                            add(currrNode);
                            add(ans[currrNode]);
                        }
                    });
                }
            }
        }

        return ans;
    }
}
