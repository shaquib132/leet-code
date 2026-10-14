
import java.util.*;

class Solution {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build the weighted graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }

        double[] answer = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) ||
                !graph.containsKey(end)) {
                answer[i] = -1.0;
            } else if (start.equals(end)) {
                answer[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                answer[i] = dfs(
                    start, end, 1.0, graph, visited
                );
            }
        }

        return answer;
    }

    private double dfs(
            String current,
            String target,
            double product,
            Map<String, Map<String, Double>> graph,
            Set<String> visited) {

        if (current.equals(target)) {
            return product;
        }

        visited.add(current);

        for (Map.Entry<String, Double> edge
                : graph.get(current).entrySet()) {

            String next = edge.getKey();

            if (visited.contains(next)) {
                continue;
            }

            double result = dfs(
                next,
                target,
                product * edge.getValue(),
                graph,
                visited
            );

            if (result != -1.0) {
                return result;
            }
        }

        return -1.0;
    }
}
