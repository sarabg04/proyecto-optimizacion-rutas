import java.util.*;

public class Main {

    public static void main(String[] args) {

        // 1. Generar datos
        List<Node> nodes = DataGenerator.generateRandomNodes(20);

        // 2. Distancias
        double[][] dist = GraphUtils.computeDistanceMatrix(nodes);

        // 3. Grafo
        List<Kruskal.Edge> edges = GraphUtils.generateEdges(dist);

        // 4. MST
        List<Kruskal.Edge> mst = Kruskal.computeMST(edges, nodes.size());

        // 5. Ruta inicial
        List<Integer> route = TSPApproximation.generateRoute(mst, nodes.size());

        double d1 = RouteUtils.computeDistance(route, dist);

        // 6. Mejora
        route = TwoOpt.improve(route, dist);

        double d2 = RouteUtils.computeDistance(route, dist);

        // 7. Output
        System.out.println("Ruta inicial: " + route);
        System.out.println("Distancia inicial: " + d1);

        System.out.println("Ruta optimizada: " + route);
        System.out.println("Distancia optimizada: " + d2);
        Visualizer.show(nodes, route);
    }
   
}
    