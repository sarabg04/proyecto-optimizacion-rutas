package tsp;


import java.util.*;

public class TwoOpt {

    public static List<Integer> improve(List<Integer> route, double[][] dist) {
        boolean improved = true;

        while (improved) {
            improved = false;

            for (int i = 1; i < route.size() - 2; i++) {
                for (int j = i + 1; j < route.size() - 1; j++) {

                    double before = dist[route.get(i-1)][route.get(i)] +
                                    dist[route.get(j)][route.get(j+1)];

                    double after = dist[route.get(i-1)][route.get(j)] +
                                   dist[route.get(i)][route.get(j+1)];

                    if (after < before) {
                        Collections.reverse(route.subList(i, j + 1));
                        improved = true;
                    }
                }
            }
        }

        return route;
    }
}
