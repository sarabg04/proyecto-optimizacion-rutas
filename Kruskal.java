
import java.util.*;

public class Kruskal {

    public static class Edge implements Comparable<Edge> {
        int u, v;
        double weight;

        public Edge(int u, int v, double weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return Double.compare(this.weight, other.weight);
        }
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int a, int b) {
            parent[find(a)] = find(b);
        }
    }

    public static List<Edge> computeMST(List<Edge> edges, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);
        UnionFind uf = new UnionFind(n);

        List<Edge> mst = new ArrayList<>();

        while (!pq.isEmpty() && mst.size() < n - 1) {
            Edge e = pq.poll();

            if (uf.find(e.u) != uf.find(e.v)) {
                uf.union(e.u, e.v);
                mst.add(e);
            }
        }

        return mst;
    }
}