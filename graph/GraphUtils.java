package graph;


import java.util.*;

public class GraphUtils {

    public static double[][] computeDistanceMatrix(List<Node> nodes) {
        int n = nodes.size();
        double[][] dist = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double dx = nodes.get(i).x - nodes.get(j).x;
                double dy = nodes.get(i).y - nodes.get(j).y;
                dist[i][j] = Math.sqrt(dx*dx + dy*dy);
            }
        }

        return dist;
    }

    public static List<Kruskal.Edge> generateEdges(double[][] dist) {
        List<Kruskal.Edge> edges = new ArrayList<>();
        int n = dist.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Kruskal.Edge(i, j, dist[i][j]));
            }
        }

        return edges;
    }
}
