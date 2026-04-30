package tsp;

import graph.Kruskal;
import java.util.*;

public class TSPApproximation {

    public static List<Integer> generateRoute(List<Kruskal.Edge> mst, int n) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (Kruskal.Edge e : mst) {
    adj.get(e.getU()).add(e.getV());
    adj.get(e.getV()).add(e.getU());
    }

        List<Integer> route = new ArrayList<>();
        boolean[] visited = new boolean[n];

        dfs(0, adj, visited, route);

        return route;
    }

    private static void dfs(int u, List<List<Integer>> adj, boolean[] visited, List<Integer> route) {
        visited[u] = true;
        route.add(u);

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited, route);
            }
        }
    }
}
