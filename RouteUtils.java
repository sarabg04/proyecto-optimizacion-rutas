
import java.util.*;

public class RouteUtils {

    public static double computeDistance(List<Integer> route, double[][] dist) {
        double total = 0;

        for (int i = 0; i < route.size() - 1; i++) {
            total += dist[route.get(i)][route.get(i + 1)];
        }

        total += dist[route.get(route.size() - 1)][route.get(0)];

        return total;
    }
}