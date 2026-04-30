package utils;
import graph.Node;
import java.util.*;

public class DataGenerator {

    public static List<Node> generateRandomNodes(int n) {
        List<Node> nodes = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i, rand.nextDouble()*100, rand.nextDouble()*100));
        }

        return nodes;
    }
}
