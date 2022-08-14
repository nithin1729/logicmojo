package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StronglyConnectedComponents {
    static class Graph{
        int vertex;
        Map<Integer, LinkedList<Integer>> map = new HashMap<Integer,LinkedList<Integer>>();
        Graph(int vertex)
        {
            this.vertex = vertex;
            for(int i=0;i<vertex;i++)
            {
                this.map.put(i, new LinkedList<Integer>());
            }
        }

        public void addEdge(int source, int destination){
            this.map.get(source).add(destination);
        }
    }

    int currIndex;

    public void isConnected(Graph graph){
        boolean[] visited = new boolean[graph.vertex];
        LinkedList<Integer> adjList[] = new LinkedList[graph.vertex];
        for(int i=0; i<visited.length; i++) {
            visited[i] = false;
            adjList[i] = graph.map.get(i);
        }
        currIndex = graph.vertex-1;

        visited[0] = true;
        DFS(0, adjList, visited);

        if(currIndex != -1) {
            System.out.println("False");
            return;
        }

        Graph reverseGraph = new Graph(graph.vertex);
        for(int i=0; i<graph.vertex; i++) {
            LinkedList<Integer> curr = graph.map.get(i);
            for(int j=0; j<curr.size(); j++) reverseGraph.addEdge(curr.get(j), i);
        }

        currIndex = reverseGraph.vertex-1;
        for(int i=0; i<visited.length; i++) {
            visited[i] = false;
        }

        visited[0] = true;
        DFS(0, adjList, visited);

        if(currIndex != -1) {
            System.out.println("False");
            return;
        }

        System.out.println("True");
    }

    public void DFS(int source, LinkedList<Integer> adjList [], boolean[] visited){
        //Write your code Here
        for(int i=0; i<adjList[source].size(); i++) {
            if(visited[adjList[source].get(i)] == false) {
                visited[adjList[source].get(i)] = true;

                DFS(adjList[source].get(i), adjList, visited);
            }
        }

        currIndex--;
    }
}
